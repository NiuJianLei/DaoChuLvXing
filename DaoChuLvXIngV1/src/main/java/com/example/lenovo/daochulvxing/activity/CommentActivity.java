package com.example.lenovo.daochulvxing.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.adapter.MainCommentRecAdapter;
import com.example.lenovo.daochulvxing.base.BaseActivity;
import com.example.lenovo.daochulvxing.bean.CommentBean;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.jaeger.library.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import presenter.CommentPresenter;
import view.CommentView;

public class CommentActivity extends BaseActivity<CommentView, CommentPresenter> implements CommentView {

    private RecyclerView mCommentRecycler;
    private SmartRefreshLayout mCommmentSmart;
    private MainCommentRecAdapter adapter;
    private int page = 1;
    private int id;
    private String token;

    @Override
    protected void initView() {
        super.initView();
        StatusBarUtil.setLightMode(CommentActivity.this);

        mCommentRecycler = (RecyclerView) findViewById(R.id.comment_recycler);
        mCommmentSmart = (SmartRefreshLayout) findViewById(R.id.commment_smart);

        mCommentRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainCommentRecAdapter(this);
        mCommentRecycler.setAdapter(adapter);


        mCommmentSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

                page ++;
                mPresenter.initComment(id, page, token);

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                adapter.clear();
                mPresenter.initComment(id, page, token);
            }
        });
    }

    @Override
    protected CommentPresenter initPresenter() {
        return new CommentPresenter();
    }

    @Override
    protected int Layoutid() {
        return R.layout.activity_comment;
    }

    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getIntExtra("id", 201);
        token = (String) SpUtil.getParam("token", "");
        mPresenter.initComment(id, page, token);
    }

    @Override
    public void Success(CommentBean.ResultEntity comment) {
        adapter.setList((ArrayList<CommentBean.ResultEntity.ReviewsEntity>) comment.getReviews());
        mCommmentSmart.finishLoadMore();
        mCommmentSmart.finishRefresh();
    }

    @Override
    public void fail(String msg) {

    }

}
