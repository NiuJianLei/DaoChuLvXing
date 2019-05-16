package com.example.lenovo.daochulvxing.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.adapter.XianLuRecAdapter;
import com.example.lenovo.daochulvxing.base.BaseFragment;
import com.example.lenovo.daochulvxing.bean.BanXiangBean;
import com.example.lenovo.daochulvxing.util.SpUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import presenter.BanXIangPresenter;
import presenter.XIanLuPresenter;
import view.BanXiangView;
import view.XianLuView;

public class XiangLuFragment extends BaseFragment<BanXiangView, BanXIangPresenter> implements BanXiangView {
    @BindView(R.id.xianlu_recycyc)
    RecyclerView xianluRecycyc;
    private XianLuRecAdapter adapter;


    @Override
    protected void initView() {
        super.initView();
        xianluRecycyc.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            //解决ScrollView里存在多个RecyclerView时滑动卡顿的问题
            //如果你的RecyclerView是水平滑动的话可以重写canScrollHorizontally方法
            public boolean canScrollVertically() {
                return false;
            }
        });
        adapter = new XianLuRecAdapter(getContext());
        xianluRecycyc.setAdapter(adapter);


        adapter.setOnitenClickListener(new XianLuRecAdapter.OnitenClickListener() {

            private PhotoView image;

            @Override
            public void listener(String url) {
                //加载popupwindow布局，布局中为下文控件（此控件类似于ImageView）
                View view =View.inflate(getContext(),R.layout.image_popup_layout,null);
                //找到布局中控件的id
                image = view.findViewById(R.id.photoview);
                //给他设置初始化图片时是不进行缩放的
                image.enable();
                //将接口回调穿过来的Url给Popupwindow中的控件设置上
                Glide.with(getContext())
                        .load(url)
                        .into(image);
                final PopupWindow pp = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                pp.setOutsideTouchable(true);
                pp.showAtLocation(xianluRecycyc,Gravity.CENTER,0,0);
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pp.dismiss();
                    }
                });
            }
        });
    }

    @Override
    protected BanXIangPresenter initPresenter() {
        return new BanXIangPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        int id = getArguments().getInt("id");
        String token = (String) SpUtil.getParam("token", "");
        mPresenter.initBanXiang(id,1,token);
    }

    @Override
    protected int LayoutId() {
        return R.layout.xianlu_fragment_layout;
    }

    @Override
    public void Success(BanXiangBean.ResultEntity bean) {
    adapter.setList((ArrayList<BanXiangBean.ResultEntity.ActivitiesEntity>) bean.getActivities());
    }

    @Override
    public void fain(String msg) {

    }
}
