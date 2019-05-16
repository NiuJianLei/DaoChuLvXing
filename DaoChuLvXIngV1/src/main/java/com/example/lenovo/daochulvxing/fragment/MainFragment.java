package com.example.lenovo.daochulvxing.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.GetChars;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.activity.AgentWebActivity;
import com.example.lenovo.daochulvxing.activity.XiangQingActivity;
import com.example.lenovo.daochulvxing.adapter.MianRecAdapter;
import com.example.lenovo.daochulvxing.base.BaseFragment;
import com.example.lenovo.daochulvxing.bean.MyPerson;
import com.example.lenovo.daochulvxing.util.SpUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;
import jp.wasabeef.glide.transformations.BitmapTransformation;
import presenter.HomeFragmentPresenter;
import view.HomeFragmentView;

public class MainFragment extends BaseFragment<HomeFragmentView, HomeFragmentPresenter> implements HomeFragmentView {
    private static final String TAG = "MainFragment";
    @BindView(R.id.main_recycler)
    RecyclerView mainRecycler;
    Unbinder unbinder;
    private int page = 1;
    private View view;
    private MianRecAdapter adapter;
    private MyPerson.ResultEntity mystudent;

    @Override
    protected HomeFragmentPresenter initPresenter() {
        return new HomeFragmentPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.mainfragment;
    }

    @Override
    public void initSuccess(MyPerson.ResultEntity myperson) {
        if (myperson.getBanners() != null) {
            adapter.setBannlist((ArrayList<MyPerson.ResultEntity.BannersEntity>) myperson.getBanners());
        }
        if (myperson.getRoutes() != null) {
        adapter.setList((ArrayList<MyPerson.ResultEntity.RoutesEntity>) myperson.getRoutes());
        }
    }

    @Override
    public void initFina(String msg) {

    }

    @Override
    protected void initView() {
        super.initView();
        String token = (String) SpUtil.getParam("token", "");
        mPresenter.getHome(page, token);

        mainRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new MianRecAdapter(getContext());
        mainRecycler.setAdapter(adapter);
        adapter.setListener(new MianRecAdapter.OnitenClickListener() {
            @Override
            public void listener(int position, int id) {
                Intent intent = new Intent(getContext(), XiangQingActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        adapter.setOnBundleClickListener(new MianRecAdapter.OnBundleClickListener() {
            @Override
            public void onClick(String url, String title) {
                Intent intent = new Intent(getContext(), AgentWebActivity.class);
                intent.putExtra("url",url+"?os=android");
                intent.putExtra("title",title);
                startActivity(intent);
            }
        });
    }
}
