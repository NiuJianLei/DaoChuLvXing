package com.example.lenovo.daochulvxing.fragment;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.base.BaseFragment;

import presenter.EmptyPresenter;
import view.EmptyView;

public class MapTabFragment extends BaseFragment<EmptyView, EmptyPresenter>  {
    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.tabfragment_layout;
    }
}
