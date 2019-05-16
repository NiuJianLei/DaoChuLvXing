package com.example.lenovo.daochulvxing.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.adapter.DongTaiRecAdapter;
import com.example.lenovo.daochulvxing.base.BaseFragment;
import com.example.lenovo.daochulvxing.bean.MyPerson;
import com.example.lenovo.daochulvxing.util.SpUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import presenter.DongTaiPresenter;
import view.DongTaiView;

public class DongTaiFragment extends BaseFragment<DongTaiView, DongTaiPresenter> implements DongTaiView {
    @BindView(R.id.dongtai_recyc)
    RecyclerView dongtaiRecyc;
    private DongTaiRecAdapter adapter;

    @Override
    protected DongTaiPresenter initPresenter() {
        return new DongTaiPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.dongtai_fragment_layout;
    }


    @Override
    protected void initData() {
        super.initData();
        String token = (String) SpUtil.getParam("token", "");
        mPresenter.initDonTai(1, token);
    }

    @Override
    public void initSuccess(MyPerson.ResultEntity myperson) {
        adapter.setList((ArrayList<MyPerson.ResultEntity.RoutesEntity>) myperson.getRoutes());
    }

    @Override
    public void initFina(String msg) {

    }

    @Override
    protected void initView() {
        super.initView();
        dongtaiRecyc.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            //解决ScrollView里存在多个RecyclerView时滑动卡顿的问题
            //如果你的RecyclerView是水平滑动的话可以重写canScrollHorizontally方法
            public boolean canScrollVertically() {
                return false;
            }
        });
        adapter = new DongTaiRecAdapter(getContext());
        dongtaiRecyc.setAdapter(adapter);
    }
}
