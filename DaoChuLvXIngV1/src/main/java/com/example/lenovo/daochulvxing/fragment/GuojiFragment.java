package com.example.lenovo.daochulvxing.fragment;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.base.BaseFragment;
import com.example.lenovo.daochulvxing.bean.DiquBean;

import presenter.DiquPresenter;
import view.DiquView;

public class GuojiFragment extends BaseFragment<DiquView, DiquPresenter> implements DiquView {

    @Override
    protected DiquPresenter initPresenter(){
        return new DiquPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.guojifragment_layout;
    }

    @Override
    public void initDiquSuccess(DiquBean.ResultEntity bean) {

    }

    @Override
    public void initDiquFain(String msg) {

    }
}
