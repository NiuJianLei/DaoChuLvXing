package com.example.lenovo.daochulvxing.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment<V extends BaseView,P extends BasePresenter>extends Fragment implements BaseView {
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(LayoutId(), null);
        ButterKnife.bind(this,inflate);
        mPresenter=initPresenter();
        if (mPresenter!=null){
            mPresenter.bind(this);
        }
        initView();
        initData();
        initListener();
        return inflate;
    }

    protected void initListener() {
    }

    protected void initData() {

    }

    protected void initView() {

    }

    protected abstract P initPresenter();

    protected abstract int LayoutId();
}
