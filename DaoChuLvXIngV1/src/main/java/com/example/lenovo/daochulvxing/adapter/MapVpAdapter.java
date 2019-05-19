package com.example.lenovo.daochulvxing.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.lenovo.daochulvxing.bean.Map_TabBean;

import java.util.ArrayList;

public class MapVpAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> list=new ArrayList<>();
    private ArrayList<Map_TabBean.ResultEntity.AllTagsEntity> titlelist=new ArrayList<>();

    public MapVpAdapter(FragmentManager fm, ArrayList<Fragment> list,ArrayList<Map_TabBean.ResultEntity.AllTagsEntity> titlelist) {
        super(fm);
        this.list=list;
        this.titlelist=titlelist;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position).getName();
    }
}
