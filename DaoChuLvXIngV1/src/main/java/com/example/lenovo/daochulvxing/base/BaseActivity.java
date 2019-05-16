package com.example.lenovo.daochulvxing.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<V extends BaseView,P extends BasePresenter> extends AppCompatActivity implements BaseView{
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(Layoutid());
        mPresenter=initPresenter();
        ButterKnife.bind(this);
        if (mPresenter!=null){
            mPresenter.bind(this);
        }
        initView();
        initData();
        initListener();
    }

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView() {

    }

    protected abstract P initPresenter();

    protected abstract int Layoutid();
}
