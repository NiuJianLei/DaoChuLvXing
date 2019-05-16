package com.example.lenovo.daochulvxing.activity;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.adapter.GuanZhuRecAdapter;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.example.lenovo.daochulvxing.bean.GuanZhu;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import presenter.GuanZhuPresenter;
import view.GuanZhuView;

public class GuanZhuActivity extends BaseActivity<GuanZhuView, GuanZhuPresenter> implements GuanZhuView, View.OnClickListener {

    private RecyclerView mGuanzhuRecycle;
    private GuanZhuRecAdapter adapter;
    private ImageView mSettingNameBack;
    /**
     * 完成
     */
    private TextView mSettingNameOk;
    private Toolbar mSettingPhotoToolbar;


    @Override
    protected void initView() {
        super.initView();
        StatusBarUtil.setLightMode(GuanZhuActivity.this);
        mGuanzhuRecycle = (RecyclerView) findViewById(R.id.guanzhu_recycle);
        mGuanzhuRecycle.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GuanZhuRecAdapter(this);
        mGuanzhuRecycle.setAdapter(adapter);
        mSettingNameBack = (ImageView) findViewById(R.id.setting_name_back);
        mSettingNameBack.setOnClickListener(this);
        mSettingNameOk = (TextView) findViewById(R.id.setting_name_ok);
        mSettingPhotoToolbar = (Toolbar) findViewById(R.id.setting_photo_toolbar);
    }

    @Override
    protected GuanZhuPresenter initPresenter() {
        return new GuanZhuPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_guan_zhu;
    }

    @Override
    public void Success(ArrayList<GuanZhu.ResultEntity.BanmiEntity> list) {
        adapter.setList(list);
    }

    @Override
    public void Erroor(String msg) {
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.setting_name_back:
                finish();
                break;
        }
    }
    @Override
    protected void initData() {
        String token = (String) SpUtil.getParam("token", "");
        mPresenter.initGuanzhu(token,1);
    }
}