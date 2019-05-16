package com.example.lenovo.daochulvxing.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.example.lenovo.daochulvxing.bean.BanXiangBean;
import com.example.lenovo.daochulvxing.fragment.DongTaiFragment;
import com.example.lenovo.daochulvxing.fragment.XiangLuFragment;
import com.example.lenovo.daochulvxing.util.ImageLoader;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import presenter.BanXIangPresenter;
import view.BanXiangView;

public class BanMiXiangActivity extends BaseActivity<BanXiangView, BanXIangPresenter> implements BanXiangView, View.OnClickListener {

    private ImageView mBanxiangBack;
    private ImageView mBanxiangFnexiang;
    private Toolbar mHomeToolbar;
    private ImageView mBanxiangBanphoto;
    /**
     * 杨晨
     */
    private TextView mBanxiangBantitle;
    private ImageView mBanxiangFollow;
    /**
     * 1523人关注
     */
    private TextView mBanxiangGuanzhu;
    /**
     * 东京
     */
    private TextView mBanxiangDizhi;
    /**
     * 日本旅游协会
     */
    private TextView mBanxiangDesc;
    /**
     * 简介：我是杨晨，日本国家旅游局专栏作者。旅居
     * 东京五年时间，遇到了太多美景和惊喜，感谢在这
     * 里得到的一切。对于美的发现，永远是我“在路上”的动力。
     */
    private String tiken;
    private static final String TAG = "BanMiXiangActivity";
    private TextView mBanxiangJianjie;
    private TabLayout mBanxiangTab;
    private FrameLayout mBanxiangFrag;
    private BanXiangBean.ResultEntity banxiang;
    private int id;
    private ArrayList<Fragment> fragments;
    private FragmentManager manager;
    private int lostposition=0;
    private XiangLuFragment xiangLuFragment;

    @Override
    protected BanXIangPresenter initPresenter() {
        return new BanXIangPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_ban_mi_xiang;
    }


    @Override
    protected void initView() {
        super.initView();
        StatusBarUtil.setLightMode(BanMiXiangActivity.this);
        id = getIntent().getIntExtra("id",54);

        mBanxiangBack = (ImageView) findViewById(R.id.banxiang_back);
        mBanxiangBack.setOnClickListener(this);
        mBanxiangFnexiang = (ImageView) findViewById(R.id.banxiang_fnexiang);
        mBanxiangFnexiang.setOnClickListener(this);
        mHomeToolbar = (Toolbar) findViewById(R.id.home_toolbar);
        mBanxiangBanphoto = (ImageView) findViewById(R.id.banxiang_banphoto);
        mBanxiangBantitle = (TextView) findViewById(R.id.banxiang_bantitle);
        mBanxiangFollow = (ImageView) findViewById(R.id.banxiang_follow);
        mBanxiangGuanzhu = (TextView) findViewById(R.id.banxiang_guanzhu);
        mBanxiangDizhi = (TextView) findViewById(R.id.banxiang_dizhi);
        mBanxiangDesc = (TextView) findViewById(R.id.banxiang_desc);
        mBanxiangJianjie = (TextView) findViewById(R.id.banxiang_jianjie);
        mBanxiangTab = (TabLayout) findViewById(R.id.banxiang_tab);
        mBanxiangFrag = (FrameLayout) findViewById(R.id.banxiang_frag);

        mBanxiangTab.addTab(mBanxiangTab.newTab().setText("动态"));
        mBanxiangTab.addTab(mBanxiangTab.newTab().setText("线路"));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.banxiang_back:
            finish();
                break;
            case R.id.banxiang_fnexiang:

                break;
        }
    }

    @Override
    public void Success(BanXiangBean.ResultEntity bean) {
        Log.d(TAG, "Success: "+bean+".........");
        setViews(bean);
    }

    @Override
    protected void initData() {
        super.initData();
        tiken = (String) SpUtil.getParam("token", "");
      mPresenter.initBanXiang(id,1,tiken);
      mBanxiangTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
          @Override
          public void onTabSelected(TabLayout.Tab tab) {
              switchFragment(tab.getPosition());
          }

          @Override
          public void onTabUnselected(TabLayout.Tab tab) {

          }

          @Override
          public void onTabReselected(TabLayout.Tab tab) {

          }
      });
    }

    private void setViews(final BanXiangBean.ResultEntity bean) {
        ImageLoader.setImage(this,bean.getBanmi().getPhoto(),mBanxiangBanphoto,R.mipmap.zhanweitu_home_kapian_hdpi);
        mBanxiangBantitle.setText(bean.getBanmi().getName());
        mBanxiangGuanzhu.setText(bean.getBanmi().getFollowing()+"人关注");
        mBanxiangDizhi.setText(bean.getBanmi().getLocation());
        mBanxiangDesc.setText(bean.getBanmi().getOccupation());
        mBanxiangJianjie.setText("简介："+bean.getBanmi().getIntroduction());
        fragments = new ArrayList<>();
        fragments.add(new DongTaiFragment());
        xiangLuFragment = new XiangLuFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id",bean.getBanmi().getId());
        xiangLuFragment.setArguments(bundle);
        fragments.add(xiangLuFragment);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.banxiang_frag,fragments.get(0));
        transaction.commit();
        mBanxiangFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bean.getBanmi().isIsFollowed()){
                    id = bean.getBanmi().getId();
                    ImageLoader.setImage(BanMiXiangActivity.this,R.mipmap.follow_unselected,mBanxiangFollow,R.mipmap.zhanweitu_home_kapian_hdpi);
                }else{
                    ImageLoader.setImage(BanMiXiangActivity.this,R.mipmap.follow,mBanxiangFollow,R.mipmap.zhanweitu_home_kapian_hdpi);
                }
            }
        });

    }

    @Override
    public void fain(String msg) {

    }

    private void switchFragment(int type) {
        Fragment fragment = fragments.get(type);
        FragmentTransaction tran = manager.beginTransaction();
        if (!fragment.isAdded()) {
            tran.add(R.id.banxiang_frag, fragment);
        }
        tran.hide(fragments.get(lostposition));
        tran.show(fragment);
        tran.commit();
        lostposition = type;
    }
}
