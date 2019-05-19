package com.example.lenovo.daochulvxing.activity;

import android.os.Bundle;
import android.service.quicksettings.Tile;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.adapter.DiquVpAdapter;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.example.lenovo.daochulvxing.bean.DiquBean;
import com.example.lenovo.daochulvxing.fragment.GuoNeiFragment;
import com.example.lenovo.daochulvxing.fragment.GuojiFragment;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import presenter.DiquPresenter;
import view.DiquView;

public class DiQuActivity extends BaseActivity<DiquView, DiquPresenter> implements DiquView {

    private TabLayout mDiquTab;
    private ViewPager mDiquVp;
    private ArrayList<Fragment> fraglist;
    private String[] title={"国内","国际"};
    private DiquVpAdapter diquVpadapter;

    @Override
    protected DiquPresenter initPresenter() {
        return new DiquPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_di_qu;
    }

    @Override
    protected void initView() {
        super.initView();
        StatusBarUtil.setLightMode(DiQuActivity.this);
        mDiquTab = (TabLayout) findViewById(R.id.diqu_tab);
        mDiquVp = (ViewPager) findViewById(R.id.diqu_vp);

        fraglist = new ArrayList<>();
        fraglist.add(new GuoNeiFragment());
        fraglist.add(new GuojiFragment());
        diquVpadapter = new DiquVpAdapter(getSupportFragmentManager(), fraglist, title);
        mDiquVp.setAdapter(diquVpadapter);
        mDiquTab.setupWithViewPager(mDiquVp);
    }


    @Override
    public void initDiquSuccess(DiquBean.ResultEntity bean) {

    }

    @Override
    public void initDiquFain(String msg) {

    }

}
