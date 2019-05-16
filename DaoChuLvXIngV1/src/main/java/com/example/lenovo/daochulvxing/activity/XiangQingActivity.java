package com.example.lenovo.daochulvxing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.adapter.XiangRecAdapter;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.example.lenovo.daochulvxing.bean.XiangBean;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.jaeger.library.StatusBarUtil;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import presenter.XiangPresenter;
import view.XiangView;

public class XiangQingActivity extends BaseActivity<XiangView, XiangPresenter> implements XiangView {
    private RecyclerView mXiangRecycl;
    private XiangRecAdapter adapter;

    @Override
    protected XiangPresenter initPresenter() {
        return new XiangPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_xiang_qing;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(XiangQingActivity.this);
        mXiangRecycl = (RecyclerView) findViewById(R.id.xiang_recycl);
        mXiangRecycl.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void initData() {
        super.initData();
        int id = getIntent().getIntExtra("id", 191);
        String token = (String) SpUtil.getParam("token", "");
        mPresenter.initXiangQing(id,token);
    }

    @Override
    public void Success(final XiangBean.ResultEntity list) {
        adapter = new XiangRecAdapter(list, this);
        mXiangRecycl.setAdapter(adapter);
        //点击返回箭头退出界面的回调
        adapter.setListener(new XiangRecAdapter.OnitenclickListener() {
            @Override
            public void listener(int position) {
                finish();
            }
        });
        //点击分享的回调
        adapter.setFenXiangListener(new XiangRecAdapter.OnItemFenXiangListener() {
            @Override
            public void FenXiangListener(int position) {
                UMWeb  web = new UMWeb(list.getRoute().getShareURL());
                UMImage image = new UMImage(XiangQingActivity.this, list.getRoute().getCardURL());
                web.setTitle("来自到处旅行"+list.getRoute().getTitle());//标题
                web.setThumb(image);  //缩略图
                web.setDescription(list.getRoute().getDescription());//描述

                new ShareAction(XiangQingActivity.this).withText(list.getRoute().getShareTitle()).withMedia(web).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
            }
        });
        //点击收藏的回调
        adapter.setShouCangListener(new XiangRecAdapter.OnItemShouCangListener() {
            @Override
            public void ShouCangListener(int position,int id) {

            }
        });
        //点击加载更多的回调
        adapter.setJiaZaiListener(new XiangRecAdapter.OnItemJiaZaiListener() {
            @Override
            public void JiaZaiListener(int position,int id) {
                Intent intent = new Intent(XiangQingActivity.this, CommentActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }

    @Override
    public void fain(String msg) {

    }
    //友盟分享回调
    private UMShareListener umShareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(XiangQingActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(XiangQingActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(XiangQingActivity.this,"取消了",Toast.LENGTH_LONG).show();
        }
    };

}
