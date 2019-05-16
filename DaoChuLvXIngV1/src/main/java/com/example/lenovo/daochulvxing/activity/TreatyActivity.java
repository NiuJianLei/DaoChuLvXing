package com.example.lenovo.daochulvxing.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.jaeger.library.StatusBarUtil;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;

import presenter.EmptyPresenter;
import view.EmptyView;

public class TreatyActivity extends BaseActivity<EmptyView, EmptyPresenter> {

    private TextView mTvTitle;
    private Toolbar mToolBar;
    private AgentWeb mAgentWeb;
    private LinearLayout mContainer;

    protected void initView() {
        //亮色的模式,会将状态栏文字修改为黑色的
        StatusBarUtil.setLightMode(this);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mContainer = (LinearLayout) findViewById(R.id.container);
        mToolBar.setTitle("");
        mToolBar.setNavigationIcon(R.mipmap.back_white);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mAgentWeb.back()) {
                    finish();
                }
            }
        });
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mContainer, new LinearLayout.LayoutParams(-1, -1))
                .closeIndicator()
                .createAgentWeb()
                .ready()
                .go("https://api.banmi.com/app2017/agreement.html");


        mAgentWeb.getWebCreator().getWebView().setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                if (!TextUtils.isEmpty(title)){
                    mTvTitle.setText(title);
                }
                super.onReceivedTitle(view, title);
            }
        });

    }

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_treaty;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
