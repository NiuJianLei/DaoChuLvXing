package com.example.lenovo.daochulvxing.base;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.util.Constants;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.example.lenovo.daochulvxing.util.UIModeUtil;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import org.xutils.x;

import luo.library.base.base.BaseAndroid;
import luo.library.base.base.BaseConfig;

public class
BaseApp extends Application {
    private static BaseApp sBaseApp;
    //默认不是夜间模式
    public static int mMode = AppCompatDelegate.MODE_NIGHT_NO;
    public static int mWidthPixels;
    public static int mHeightPixels;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
        getScreenWH();
        initVersion();//版本更新
        setDayNightMode();
        UMConfigure.init(this,"5cce581f0cafb238380003b2"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("1172778299", "632b1da480eb371c10b69bd01c719354","http://sns.whalecloud.com");
    }

    private void initVersion() {
        x.Ext.init(this);
        x.Ext.setDebug(true);

        BaseAndroid.init(new BaseConfig()
                .setAppColor(R.color.c_fa6a13)//app主调颜色，用于标题栏等背景颜色
                .setAppLogo(R.mipmap.ic_launcher)//app图标
                .setFailPicture(R.mipmap.zhanweitu_home_kapian_hdpi)//加载加载失败和加载中显示的图
                .setCode(0)//网络请求成功返回的code数字，默认为1
                .setHttpCode("code")//网络请求返回的code字段名称，默认为code
                .setHttpMessage("msg")//网络请求返回的message字段名称，默认为message
                .setHttpResult("resp"));//网络请求返回的result字段名称，默认为result
    }

    private void setDayNightMode() {
        //设置以前用户的模式选项
        mMode = (int) SpUtil.getParam(Constants.MODE,AppCompatDelegate.MODE_NIGHT_NO);
        UIModeUtil.setAppMode(mMode);
    }

    //计算屏幕宽高
    private void getScreenWH() {
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display defaultDisplay = manager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        defaultDisplay.getMetrics(metrics);
        mWidthPixels = metrics.widthPixels;
        mHeightPixels = metrics.heightPixels;
    }

    public static BaseApp getInstance(){
        return sBaseApp;
    }

}
