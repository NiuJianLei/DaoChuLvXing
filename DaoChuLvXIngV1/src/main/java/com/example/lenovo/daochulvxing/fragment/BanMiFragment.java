package com.example.lenovo.daochulvxing.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.activity.BanMiXiangActivity;
import com.example.lenovo.daochulvxing.adapter.BanMiRecAadpter;
import com.example.lenovo.daochulvxing.base.BaseFragment;
import com.example.lenovo.daochulvxing.bean.BanMiBean;
import com.example.lenovo.daochulvxing.util.SpUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import presenter.BanMiFragmentPresenter;
import view.BanMiFragmentView;

public class BanMiFragment extends BaseFragment<BanMiFragmentView, BanMiFragmentPresenter> implements BanMiFragmentView {


    @BindView(R.id.banmi_recycler)
    RecyclerView banmiRecycler;
    private BanMiRecAadpter adapter;
    private int page = 1;
    private View view;

    @Override
    protected BanMiFragmentPresenter initPresenter() {
        return new BanMiFragmentPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.banmifragment_layout;
    }


    @Override
    protected void initData() {
        super.initData();
        String token = (String) SpUtil.getParam("token", "");
        mPresenter.getBanMi(page, token);
    }

    @Override
    protected void initView() {
        super.initView();

        banmiRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new BanMiRecAadpter(getContext());
        banmiRecycler.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        adapter.setLike(new BanMiRecAadpter.OnItenClickListener() {
            @Override
            public void like(int id) {
                Toast.makeText(getContext(), "关注成功", Toast.LENGTH_SHORT).show();
                String token = (String) SpUtil.getParam("token", "");
                mPresenter.initLike(id,token);
            }

            @Override
            public void remove(int id) {
                Toast.makeText(getContext(), "取消成功", Toast.LENGTH_SHORT).show();
                String token = (String) SpUtil.getParam("token", "");
                mPresenter.initOutFollow(id,token);
            }
        });

        adapter.setListener(new BanMiRecAadpter.OnItenClick() {
            @Override
            public void listener(int position, int id) {
                Intent intent = new Intent(getContext(), BanMiXiangActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }

    @Override
    public void Success(ArrayList<BanMiBean.ResultEntity.BanmiEntity> list) {
        adapter.setList(list);
    }

    @Override
    public void fain(String mas) {

    }

    @Override
    public void followSuccess(String mas) {

    }

    @Override
    public void followFain(String msg) {

    }

}
