package com.example.lenovo.daochulvxing.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.jaeger.library.StatusBarUtil;

import java.sql.Time;

import presenter.VirifyPresenter;
import view.VirifyView;


public class VirifyActivity extends BaseActivity<VirifyView, VirifyPresenter> implements View.OnClickListener {

    private int time=0;
    private ImageView mIvBack;
    /**
     * 重新发送
     */
    private TextView mTvSendAgain;
    private IdentifyingCodeView mIcv;
    /**
     * 请稍等...
     */
    private TextView mTvWait;
    private String data;

    @Override
    protected VirifyPresenter initPresenter() {

        return new VirifyPresenter();
    }



    @Override
    protected int Layoutid() {
        return R.layout.activity_virify;
    }

    @Override
    protected void initView() {
        super.initView();
        StatusBarUtil.setLightMode(VirifyActivity.this);

        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mIvBack.setOnClickListener(this);
        mTvSendAgain = (TextView) findViewById(R.id.tv_send_again);
        mTvSendAgain.setOnClickListener(this);
        mIcv = (IdentifyingCodeView) findViewById(R.id.icv);
        mTvWait = (TextView) findViewById(R.id.tv_wait);
        mTvWait.setOnClickListener(this);
        data = getIntent().getStringExtra("data");
        mTvWait.setText(data);
    }

    @Override
    protected void initListener() {
        mIcv.setInputCompleteListener(new IdentifyingCodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {
                if (mIcv.getTextContent().equals(data)){
                    Intent intent = new Intent(VirifyActivity.this, HomeActivity.class);
                    mTvWait.setText("正在登陆");
                    startActivity(intent);
                    Toast.makeText(VirifyActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(VirifyActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void deleteContent() {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_send_again:

                break;
            case R.id.tv_wait:

                break;
        }
    }


    public void settimeAndColor(int time,int color) {
        if (mTvSendAgain != null){
            if (time<=0){
                mTvSendAgain.setText("重新发送");
                mTvSendAgain.setTextColor(color);
            }else {
                mTvSendAgain.setText("重新发送("+time+"s)");
                mTvSendAgain.setTextColor(color);
            }
        }
    }
}
