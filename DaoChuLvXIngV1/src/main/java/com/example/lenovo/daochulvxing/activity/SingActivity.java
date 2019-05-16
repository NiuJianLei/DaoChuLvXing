package com.example.lenovo.daochulvxing.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.example.lenovo.daochulvxing.util.SpUtil;

import presenter.APersonFragmentPresenter;
import view.APersonFragmentView;

public class SingActivity extends BaseActivity<APersonFragmentView, APersonFragmentPresenter> implements APersonFragmentView, View.OnClickListener {

    private ImageView mSettingSingBack;
    /**
     * 完成
     */
    private TextView mSettingSingOk;
    private EditText mSettingSingText;
    private TextView mSettingSingXiangzhi;

    @Override
    protected APersonFragmentPresenter initPresenter() {
        return new APersonFragmentPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_sing;
    }

    @Override
    public void initSuccess() {

    }

    @Override
    public void initfina(String msg) {

    }



    public void initView() {
        mSettingSingBack = (ImageView) findViewById(R.id.setting_sing_back);
        mSettingSingBack.setOnClickListener(this);
        mSettingSingOk = (TextView) findViewById(R.id.setting_sing_ok);
        mSettingSingOk.setOnClickListener(this);
        mSettingSingText = (EditText) findViewById(R.id.setting_sing_text);
        mSettingSingXiangzhi = (TextView) findViewById(R.id.setting_sing_xiangzhi);

        mSettingSingText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = s.length();
                mSettingSingXiangzhi.setText(30-length+"/30");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        String text1 = getIntent().getStringExtra("text1");
        if (text1.isEmpty()){
            mSettingSingText.setHint(text1);
            mSettingSingText.setSelection(text1.length());
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.setting_sing_back:
                finish();
                break;
            case R.id.setting_sing_ok:
                String trim = mSettingSingText.getText().toString().trim();
                SpUtil.setParam("desc",trim);
                String token = (String) SpUtil.getParam("token", "");
                mPresenter.initSetting(token,trim,ServiceList.SING);
                finish();
                break;
        }
    }
}
