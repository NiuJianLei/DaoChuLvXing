package com.example.lenovo.daochulvxing.activity;

import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.util.SpUtil;

public class WhiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white);

            if (!TextUtils.isEmpty((String) SpUtil.getParam("token",""))){
            startActivity(new Intent(this,HomeActivity.class));
            }else if ((boolean)SpUtil.getParam("isselected",false)){
            startActivity(new Intent(this,MainActivity.class));
            }else{
                Intent intent = new Intent(WhiteActivity.this, WelComeActivity.class);
                startActivity(intent);
            }
    }
}
