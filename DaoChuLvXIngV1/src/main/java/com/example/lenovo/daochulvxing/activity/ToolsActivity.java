package com.example.lenovo.daochulvxing.activity;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.example.lenovo.daochulvxing.bean.VersionInfo;

import presenter.ToolsPresenter;
import view.ToolsView;

public class ToolsActivity extends BaseActivity<ToolsView, ToolsPresenter> implements ToolsView{


    @Override
    protected ToolsPresenter initPresenter() {
        return new ToolsPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_tools;
    }

    @Override
    protected void initView() {
        super.initView();
        // 获取本版本号，是否更新

    }


    @Override
    public void Success(VersionInfo versionInfo) {

    }

    @Override
    public void fain(String msg) {

    }
}
