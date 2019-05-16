package com.example.lenovo.daochulvxing.activity;

import android.content.Intent;
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

public class NameActivity extends BaseActivity<APersonFragmentView, APersonFragmentPresenter> implements APersonFragmentView, View.OnClickListener {


    private ImageView mSettingNameBack;
    /**
     * 完成
     */
    private TextView mSettingNameOk;
    private EditText mSettingNameName;
    private TextView mSettingNameXiangzhi;

    @Override
    protected APersonFragmentPresenter initPresenter() {
        return new APersonFragmentPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_name;
    }


    @Override
    public void initSuccess() {

    }

    @Override
    public void initfina(String msg) {

    }


    @Override
    protected void initView() {
        super.initView();


        mSettingNameBack = (ImageView) findViewById(R.id.setting_name_back);
        mSettingNameBack.setOnClickListener(this);
        mSettingNameOk = (TextView) findViewById(R.id.setting_name_ok);
        mSettingNameOk.setOnClickListener(this);
        mSettingNameName = (EditText) findViewById(R.id.setting_name_name);
        mSettingNameXiangzhi = (TextView) findViewById(R.id.setting_name_xiangzhi);



        mSettingNameName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = s.length();
                mSettingNameXiangzhi.setText(length+"/30");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        String nick = getIntent().getStringExtra("nick");
        if (!nick.isEmpty()){
            mSettingNameName.setText(nick);

            mSettingNameName.setSelection(mSettingNameName.getText().toString().length());
        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.setting_name_back:
                finish();
                break;
            case R.id.setting_name_ok:
                String name = mSettingNameName.getText().toString().trim();
                SpUtil.setParam("name",name);
                String token = (String) SpUtil.getParam("token", "");
                mPresenter.initSetting(token,name,ServiceList.NAME);
                finish();
                break;
        }
    }


}
