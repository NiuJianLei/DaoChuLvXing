package com.example.lenovo.daochulvxing.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.adapter.SubjectRecAdapter;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.example.lenovo.daochulvxing.bean.ZhuanTiBean;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import presenter.SubJectPresenter;
import view.SubJectView;

public class SubjectActivity extends BaseActivity<SubJectView, SubJectPresenter> implements SubJectView {

    private RecyclerView mSubRecview;
    private SmartRefreshLayout mSmart;
    private SubjectRecAdapter adapter;

    @Override
    protected SubJectPresenter initPresenter() {
        return new SubJectPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_subject;
    }

    @Override
    protected void initData() {
        super.initData();
        String token = (String) SpUtil.getParam("token", "");
        mPresenter.initSubject(token);
    }


    @Override
    protected void initView() {
        super.initView();
        mSubRecview = (RecyclerView) findViewById(R.id.sub_recview);
        mSmart = (SmartRefreshLayout) findViewById(R.id.smart);
        mSubRecview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SubjectRecAdapter(this);
        mSubRecview.setAdapter(adapter);

    }

    @Override
    public void Success(ArrayList<ZhuanTiBean.ResultEntity.BundlesEntity> list) {
        adapter.setList(list);
    }

    @Override
    public void fina(String msg) {

    }
}
