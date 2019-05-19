package com.example.lenovo.daochulvxing.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.activity.APersonActivity;
import com.example.lenovo.daochulvxing.activity.MainActivity;
import com.example.lenovo.daochulvxing.base.BaseFragment;
import com.example.lenovo.daochulvxing.bean.VersionInfo;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.example.lenovo.daochulvxing.util.UpdateManager;

import java.io.File;

import butterknife.BindView;
import presenter.EmptyPresenter;
import presenter.ToolsPresenter;
import view.EmptyView;
import view.ToolsView;

public class MyFragment extends BaseFragment<ToolsView, ToolsPresenter> implements ToolsView {


    @BindView(R.id.head_touxiang)
    ImageView mHeadTouxiang;
    @BindView(R.id.head_name)
    TextView mHeadName;
    @BindView(R.id.head_desc)
    TextView mHeadDesc;
    @BindView(R.id.home_headLinear)
    LinearLayout mHomeHeadLinear;
    @BindView(R.id.head_price)
    TextView mHeadPrice;
    @BindView(R.id.image_kaquan)
    ImageView mImageKaquan;
    @BindView(R.id.image_shoucang)
    ImageView mImageShoucang;
    @BindView(R.id.image_xingcheng)
    ImageView mImageXingcheng;
    @BindView(R.id.image_guanzhu)
    ImageView mImageGuanzhu;
    @BindView(R.id.navig_guanzhu)
    TextView mNavigGuanzhu;
    @BindView(R.id.head_banben)
    TextView mHeadBanben;
    private VersionInfo.ResultEntity.InfoEntity info;
    private String fileName;



    @Override
    protected void initView() {
        super.initView();

        //点击整个头像布局跳到个人信息页面
        mHomeHeadLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), APersonActivity.class);
                startActivity(intent);
            }
        });

        mHeadBanben.setOnClickListener(new View.OnClickListener() {
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
    protected int LayoutId() {
        return R.layout.navig_head;
    }

    @Override
    public void onResume() {
        super.onResume();
        String photo = (String) SpUtil.getParam("photo", "");
        String sex = (String) SpUtil.getParam("sex", "");
        String name = (String) SpUtil.getParam("name", "");
        String desc = (String) SpUtil.getParam("desc", "");

        mHeadName.setText(name);
        mHeadDesc.setText(desc);
        String photourl = (String) SpUtil.getParam("photourl", "");
        RequestOptions options = RequestOptions.circleCropTransform();
       Glide.with(this)
                .load(photourl)
                .apply(options)
                .into(mHeadTouxiang);

    }

    //版本更新
    @Override
    public void Success(VersionInfo versionInfo) {
        UpdateManager instance = UpdateManager.getInstance();
        info = versionInfo.getResult().getInfo();
        if (instance.updateApp(instance.getVersionName(getContext()), info.getVersion())){
            int type = 0;
            if(luo.library.base.utils.UpdateManager.getInstance().isWifi(getContext())) {
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
                fileName = getContext().getPackageName() + ".apk";
            }
            File file = new File(downLoadPath + fileName);
            UpdateManager.getInstance().setType(type).setUrl(info.getDownload_url()).setUpdateMessage("更新了UI\n添加图片缩放功能").setFileName(fileName).setIsDownload(file.exists());
            if(type == 1 && !file.exists()) {
                UpdateManager.getInstance().downloadFile(getContext());
            } else {
                UpdateManager.getInstance().showDialog(getContext());
            }
        }
    }
    @Override
    public void fain(String msg) {
    }
}
