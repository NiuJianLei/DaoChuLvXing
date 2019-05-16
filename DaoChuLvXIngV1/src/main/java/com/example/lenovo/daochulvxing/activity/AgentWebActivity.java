package com.example.lenovo.daochulvxing.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.jaeger.library.StatusBarUtil;
import com.just.agentweb.AgentWeb;

import butterknife.BindView;
import presenter.EmptyPresenter;
import view.EmptyView;

public class AgentWebActivity extends BaseActivity<EmptyView, EmptyPresenter> {


    @BindView(R.id.prent_ll)
    LinearLayout mPrentLl;
    private AgentWeb mAgentWeb;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_agent_web;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(AgentWebActivity.this);
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent((LinearLayout) mPrentLl, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(getIntent().getStringExtra("url"));
        mAgentWeb.getJsInterfaceHolder().addJavaObject("android",new AndroidJS(this));
    }
}
