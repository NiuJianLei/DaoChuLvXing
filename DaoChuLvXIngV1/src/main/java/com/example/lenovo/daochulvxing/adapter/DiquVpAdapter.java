package com.example.lenovo.daochulvxing.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class DiquVpAdapter extends FragmentStatePagerAdapter {
   private ArrayList<Fragment> list=new ArrayList<>();
   private String[] title={"国内","国际"};

    public DiquVpAdapter(FragmentManager fm,ArrayList<Fragment> list,String[] title) {
        super(fm);
        this.list=list;
        this.title=title;
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
        return title[position];

    }
}
