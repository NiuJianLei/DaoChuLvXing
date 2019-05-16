package com.example.lenovo.daochulvxing.activity;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

public class AndroidJS extends Object {
    private Context context;

    public AndroidJS(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void callAndroid(String type,int id){
        Intent intent = new Intent(context, XiangQingActivity.class);
        intent.putExtra("id",id);
        context.startActivity(intent);
    }
    @JavascriptInterface
    public void callAndroid(String type){
        Intent intent = new Intent(context, SubjectActivity.class);
        context.startActivity(intent);
    }
}
