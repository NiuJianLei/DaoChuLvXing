package com.example.lenovo.daochulvxing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.adapter.HomeVpAdapter;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.example.lenovo.daochulvxing.bean.VersionInfo;
import com.example.lenovo.daochulvxing.fragment.BanMiFragment;
import com.example.lenovo.daochulvxing.fragment.MainFragment;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.example.lenovo.daochulvxing.util.UpdateManager;
import com.jaeger.library.StatusBarUtil;

import java.io.File;
import java.util.ArrayList;

import presenter.EmptyPresenter;
import presenter.ToolsPresenter;
import retrofit2.http.Headers;
import view.EmptyView;
import view.ToolsView;

public class HomeActivity extends BaseActivity<ToolsView, ToolsPresenter> implements ToolsView,View.OnClickListener {

    private static boolean isExit=false;
    private Handler handlerExit=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            isExit=false;
        }
    };

    private ViewPager mHomeVp;
    private TabLayout mHomeTab;
    private ArrayList<Fragment> fraglist;
    private String[] title = {"首页", "伴米"};
    private ImageView mTouxiang;
    private NavigationView mHomepageNavig;
    private DrawerLayout mHomepageDrawer;
    private Toolbar mHomeToolbar;
    private ImageView head_touxiang;
    private TextView mdesc;
    private TextView mname;
    private TextView guanzhu;
    private ImageView touxiang;
    private VersionInfo.ResultEntity.InfoEntity info;
    private String fileName;


    public void initView() {
        StatusBarUtil.setLightMode(HomeActivity.this);

        mHomeVp = (ViewPager) findViewById(R.id.home_vp);
        mHomeTab = (TabLayout) findViewById(R.id.home_tab);
        mTouxiang = (ImageView) findViewById(R.id.touxiang);
        mHomepageNavig = (NavigationView) findViewById(R.id.homepage_navig);
        mHomepageDrawer = (DrawerLayout) findViewById(R.id.homepage_drawer);
        mHomeToolbar = (Toolbar) findViewById(R.id.home_toolbar);
        fraglist = new ArrayList<>();
        fraglist.add(new MainFragment());
        fraglist.add(new BanMiFragment());
        HomeVpAdapter adapter = new HomeVpAdapter(getSupportFragmentManager(), fraglist, title);
        mHomeVp.setAdapter(adapter);
        mHomeTab.setupWithViewPager(mHomeVp);
        //给Tablayout设置图片选择器
        for (int i = 0; i < fraglist.size(); i++) {
            if (mHomeTab.getTabAt(i) != null) {
                if (i == 0) {
                    mHomeTab.getTabAt(i).setIcon(R.drawable.tab_home_selected);
                } else {
                    mHomeTab.getTabAt(1).setIcon(R.drawable.tab_banmi_selected);
                }
            }
        }
        mTouxiang.setOnClickListener(this);


        //获取侧滑中的头布局
        View headerView = mHomepageNavig.getHeaderView(0);
        LinearLayout headlinear = headerView.findViewById(R.id.home_headLinear);
        headlinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, APersonActivity.class);
                startActivity(intent);
            }
        });
        //从服务器中获取数据给侧滑中的信息赋值
        //但是这样如果不退出App从新进入的话，信息是不会更新的，所以需要将修改的信息发送过来
        mdesc = headerView.findViewById(R.id.head_desc);
        mname = headerView.findViewById(R.id.head_name);
        String param = (String) SpUtil.getParam("name", "");
        String param1 = (String) SpUtil.getParam("desc", "");
        mdesc.setText(param1);
        mname.setText(param);

        guanzhu = headerView.findViewById(R.id.navig_guanzhu);
        guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, GuanZhuActivity.class);
                startActivity(intent);
            }
        });
        touxiang = headerView.findViewById(R.id.head_touxiang);
        TextView banben = headerView.findViewById(R.id.head_banben);
        banben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = (String) SpUtil.getParam("token", "");
                mPresenter.initVersionInfo(token);
            }
        });

    }

    @Override
    protected ToolsPresenter initPresenter() {
        return new ToolsPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_home;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.touxiang:
                mHomepageDrawer.openDrawer(Gravity.LEFT);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        String photo = (String) SpUtil.getParam("photo", "");
        String sex = (String) SpUtil.getParam("sex", "");
        String name = (String) SpUtil.getParam("name", "");
        String desc = (String) SpUtil.getParam("desc", "");
        mname.setText(name);
        mdesc.setText(desc);

        String photourl = (String) SpUtil.getParam("photourl", "");
        RequestOptions options = RequestOptions.circleCropTransform();
        Glide.with(this)
                .load(photourl)
                .apply(options)
                .into(touxiang);

        RequestOptions options2 = RequestOptions.circleCropTransform();
        Glide.with(this)
                .load(photourl)
                .apply(options)
                .into(mTouxiang);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            initExit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void initExit() {
        if(!isExit){
            isExit=true;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            //利用handler延迟发送更改状态信息
            handlerExit.sendEmptyMessageDelayed(0,2000);
        }
        else{
            finish();
            System.exit(0);
        }
    }

    @Override
    public void Success(VersionInfo versionInfo) {
        UpdateManager instance = UpdateManager.getInstance();
        info = versionInfo.getResult().getInfo();
        if (instance.updateApp(instance.getVersionName(this), info.getVersion())){
            int type = 0;
            if(luo.library.base.utils.UpdateManager.getInstance().isWifi(this)) {
                type = 1;
            }
            if(false) {
                type = 2;
            }
            String downLoadPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/downloads/";
            File dir = new File(downLoadPath);
            if(!dir.exists()) {
                dir.mkdir();
            }
                                                             //getDownload_url()为接口中的下载路径
            fileName = info.getDownload_url().substring(info.getDownload_url().lastIndexOf("/") + 1, info.getDownload_url().length());
            if(fileName == null && TextUtils.isEmpty(fileName) && !fileName.contains(".apk")) {
                fileName = this.getPackageName() + ".apk";
            }
            File file = new File(downLoadPath + fileName);
            UpdateManager.getInstance().setType(type).setUrl(info.getDownload_url()).setUpdateMessage("更新了UI\n添加图片缩放功能").setFileName(fileName).setIsDownload(file.exists());
            if(type == 1 && !file.exists()) {
                UpdateManager.getInstance().downloadFile(this);
            } else {
                UpdateManager.getInstance().showDialog(this);
            }
        }
    }
    @Override
    public void fain(String msg) {
    }
}
