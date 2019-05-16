package com.example.lenovo.daochulvxing.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.example.lenovo.daochulvxing.bean.LoginInfo;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.jaeger.library.StatusBarUtil;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import presenter.MainPresenter;
import view.MainView;
public class MainActivity extends BaseActivity<MainView, MainPresenter> implements View.OnClickListener,MainView {

    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==66){
                if (activity!=null){
                    activity.settimeAndColor(time,R.color.c_cecece);
                }
                time--;
            }else{
                if (activity!=null){
                    activity.settimeAndColor(time,R.color.c_fa6a13);
                }
            }
        }
    };

    private static final String TAG = "MainActivity";
    /**
     * 请输入手机号
     */
    private EditText mEtPhone;
    private ImageView mPhone;
    /**
     * +86
     */
    private TextView mBaliu;
    /**
     * 发送验证码
     */
    private int time = 0;
    private String data;
    private Button mYanzheng;
    private ImageView mUmengQq;
    private TextView mTvTreaty;
    private ImageView mUmengWeibo;
    private String virifyurl="http://yun918.cn/study/public/index.php/verify";
    private VirifyActivity activity;

    //5cce581f0cafb238380003b2
    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_main;
    }

    //友盟qq授权
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void initView() {
        activity = new VirifyActivity();
        //设置状态栏为全透明状态
        StatusBarUtil.setLightMode(MainActivity.this);
        String token = (String) SpUtil.getParam("token", "");
        if (!token.isEmpty()){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        super.initView();
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mPhone = (ImageView) findViewById(R.id.phone);
        mBaliu = (TextView) findViewById(R.id.baliu);
        mYanzheng = (Button) findViewById(R.id.yanzheng);
        mYanzheng.setOnClickListener(this);
        mUmengQq = (ImageView) findViewById(R.id.umeng_qq);
        mTvTreaty = (TextView) findViewById(R.id.tv_treaty);
        mUmengWeibo = (ImageView) findViewById(R.id.umeng_weibo);
        mUmengWeibo.setOnClickListener(this);
        mUmengQq.setOnClickListener(this);

        mEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = s.toString().length();
                if (length == 11) {
                    mYanzheng.setBackground(getResources().getDrawable(R.mipmap.button_highlight));
                } else {
                    mYanzheng.setBackground(getResources().getDrawable(R.mipmap.button_unavailable));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }


        });
        //图文并排
        SpannableStringBuilder builder = new SpannableStringBuilder("登陆或注册即同意用户协议");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //跳转页面,webview展示协议
                //webView有很多坑,所以我们不直接用webView
                Intent intent = new Intent(MainActivity.this, TreatyActivity.class);
                startActivity(intent);
            }
        };
        //需要设置这个ClickableSpan才会有效果
        builder.setSpan(clickableSpan, 8, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.orange)), 8, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //需要设置这个ClickableSpan才会有效果
        mTvTreaty.setMovementMethod(LinkMovementMethod.getInstance());
        mTvTreaty.setText(builder);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.yanzheng:
                String s = mEtPhone.getText().toString();
                String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
                if (s.matches(REGEX_MOBILE)) {
                    if (time<=0){
                        SendVirify();
                        return;
                    }else {
                        Intent intent = new Intent(MainActivity.this, activity.getClass());
                        intent.putExtra("data",data);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(this, "手机号有误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.umeng_qq:
                UMShareAPI.get(this).getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.umeng_weibo:
               /* Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);*/
               UMShareAPI.get(this).getPlatformInfo(MainActivity.this, SHARE_MEDIA.SINA, umAuthListener);

                break;
        }
    }

    public void SendVirify(){
        if (time<=0){
            initVirifyCode();
            time = 10;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(66);
                if (time>0){
                    handler.postDelayed(this,1000);
                }else{
                    handler.sendEmptyMessage(1);
                }
            }
        },0);

    }

    private void initVirifyCode() {
        OkHttpClient ok = new OkHttpClient();
        Request build = new Request.Builder()
                .url(virifyurl)
                .get()
                .build();
        ok.newCall(build).enqueue(new Callback() {



            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: "+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(string);
                    data = jsonObject.getString("data");
                    Intent intent = new Intent(MainActivity.this, VirifyActivity.class);
                    intent.putExtra("data",data);
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }
        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            String uid = data.get("uid");

            Toast.makeText(MainActivity.this, "成功了", Toast.LENGTH_LONG).show();
            String photo = data.get("photo");
            mPresenter.getLogin(uid);
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(MainActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void initSuccess(LoginInfo.ResultBean logininfo) {
        SpUtil.setParam("token",logininfo.getToken());
        SpUtil.setParam("photo",logininfo.getPhoto());
        SpUtil.setParam("phone",logininfo.getPhone());
        SpUtil.setParam("desc",logininfo.getDescription());
        SpUtil.setParam("sex",logininfo.getGender());
        SpUtil.setParam("name",logininfo.getUserName());
        SpUtil.setParam("email",logininfo.getEmail());
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void initEroor(String msg) {

    }


}
