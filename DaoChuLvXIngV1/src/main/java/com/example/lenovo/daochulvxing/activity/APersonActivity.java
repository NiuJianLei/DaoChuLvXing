package com.example.lenovo.daochulvxing.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.jaeger.library.StatusBarUtil;

import presenter.APersonFragmentPresenter;
import view.APersonFragmentView;

/**
 * The type A person activity.
 */
public class APersonActivity extends BaseActivity<APersonFragmentView, APersonFragmentPresenter> implements APersonFragmentView, View.OnClickListener {


    private ImageView mApersonBack;
    private RelativeLayout mApersonTouxiang;
    /**
     * 伴小米
     */
    private TextView mTvNick;
    private RelativeLayout mApersonName;
    /**
     * 保密
     */
    private TextView mTvGender;
    private RelativeLayout mApersonSex;
    /**
     * 四肢不全五体不勤
     */
    private TextView mTvSignature;
    private RelativeLayout mApersonSing;
    private RelativeLayout mRlUpdatePsw;
    private RelativeLayout mRlBindPhone;
    private LinearLayout mApersonLl;
    private ImageView mApersonPhoto;


    @Override
    protected int Layoutid() {
        return R.layout.activity_aperson;
    }

    public void initView() {
        StatusBarUtil.setLightMode(APersonActivity.this);

        mApersonBack = (ImageView) findViewById(R.id.aperson_back);
        mApersonBack.setOnClickListener(this);
        mApersonTouxiang = (RelativeLayout) findViewById(R.id.aperson_touxiang);
        mApersonTouxiang.setOnClickListener(this);
        mTvNick = (TextView) findViewById(R.id.tv_nick);
        mTvNick.setOnClickListener(this);
        mApersonName = (RelativeLayout) findViewById(R.id.aperson_name);
        mApersonName.setOnClickListener(this);
        mTvGender = (TextView) findViewById(R.id.tv_gender);
        mTvGender.setOnClickListener(this);
        mApersonSex = (RelativeLayout) findViewById(R.id.aperson_sex);
        mApersonSex.setOnClickListener(this);
        mTvSignature = (TextView) findViewById(R.id.tv_signature);
        mTvSignature.setOnClickListener(this);
        mApersonSing = (RelativeLayout) findViewById(R.id.aperson_sing);
        mApersonSing.setOnClickListener(this);
        mRlUpdatePsw = (RelativeLayout) findViewById(R.id.rl_updatePsw);
        mRlUpdatePsw.setOnClickListener(this);
        mRlBindPhone = (RelativeLayout) findViewById(R.id.rl_bindPhone);
        mRlBindPhone.setOnClickListener(this);
        mApersonLl = (LinearLayout) findViewById(R.id.aperson_ll);
        mApersonPhoto = (ImageView) findViewById(R.id.aperson_photo);
        registerForContextMenu(mApersonLl);


    }

    @Override
    protected APersonFragmentPresenter initPresenter() {
        return new APersonFragmentPresenter();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.aperson_back:
                finish();
                break;
            case R.id.aperson_touxiang:
                //更换头像
                Intent intent = new Intent(APersonActivity.this, PhotoActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_nick:
                break;
            case R.id.aperson_name:
                //更换网名
                String text = (String) mTvNick.getText();
                if (!text.isEmpty()) {
                    Intent intent1 = new Intent(APersonActivity.this, NameActivity.class);
                    intent1.putExtra("nick", text);
                    startActivity(intent1);
                }
                break;
            case R.id.tv_gender:
                break;
            case R.id.aperson_sex:
                //更换性别
                settingSex();
                break;
            case R.id.tv_signature:

                break;
            case R.id.aperson_sing:
                //更换签名
                String text1 = (String) mTvSignature.getText().toString();
                if (text1 != null) {
                    Intent singintent = new Intent(APersonActivity.this, SingActivity.class);
                    singintent.putExtra("text1", text1);
                    startActivity(singintent);
                }

                break;
            case R.id.rl_updatePsw:
                break;
            case R.id.rl_bindPhone:
                break;
        }
    }

    private void settingSex() {
        View view = View.inflate(this, R.layout.popup_setting_sex_layout, null);
        final PopupWindow popupWindow = new PopupWindow(view, 1000, 700);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(mApersonLl, Gravity.BOTTOM, 0, 0);

        Button baomi = view.findViewById(R.id.setting_sex_baomi);
        Button nan = view.findViewById(R.id.setting_sex_nan);
        Button nv = view.findViewById(R.id.setting_sex_nv);
        Button quxiao = view.findViewById(R.id.setting_sex_quxiao);

        baomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvGender.setText("保密");
                SpUtil.setParam("sex", "");
                String token = (String) SpUtil.getParam("token", "");
                mPresenter.initSetting(token, "U", ServiceList.SEX);
                popupWindow.dismiss();
            }
        });
        nan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvGender.setText("男");
                SpUtil.setParam("sex", "M");
                String token = (String) SpUtil.getParam("token", "");
                mPresenter.initSetting(token, "M", ServiceList.SEX);
                popupWindow.dismiss();
            }
        });
        nv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvGender.setText("女");
                SpUtil.setParam("sex", "F");
                String token = (String) SpUtil.getParam("token", "");
                mPresenter.initSetting(token, "F", ServiceList.SEX);
                popupWindow.dismiss();
            }
        });
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }

    @Override
    public void initSuccess() {

    }

    @Override
    public void initfina(String msg) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        String photo = (String) SpUtil.getParam("photo", "");
        String sex = (String) SpUtil.getParam("sex", "");
        String name = (String) SpUtil.getParam("name", "");
        String desc = (String) SpUtil.getParam("desc", "");


        if (sex.equals("F")) {
            mTvGender.setText("女");
        } else if (sex.equals("U")) {
            mTvGender.setText("保密");
        } else if (sex.equals("M")) {
            mTvGender.setText("男");
        }
        String photourl = (String) SpUtil.getParam("photourl", "");
        mTvNick.setText(name);
        mTvSignature.setText(desc);
        Glide.with(this)
                .load(photourl)
                .into(mApersonPhoto);
    }


}
