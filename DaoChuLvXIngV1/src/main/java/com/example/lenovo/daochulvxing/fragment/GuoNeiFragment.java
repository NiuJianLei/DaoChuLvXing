package com.example.lenovo.daochulvxing.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.adapter.LvChinaAdapter;
import com.example.lenovo.daochulvxing.base.BaseFragment;
import com.example.lenovo.daochulvxing.bean.DiquBean;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.example.lenovo.daochulvxing.weight.SideBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import presenter.DiquPresenter;
import view.DiquView;

public class GuoNeiFragment extends BaseFragment<DiquView, DiquPresenter> implements DiquView {
    @BindView(R.id.remena)
    TextView remena;
    @BindView(R.id.remenb)
    TextView remenb;
    @BindView(R.id.remenc)
    TextView remenc;
    @BindView(R.id.remend)
    TextView remend;
    @BindView(R.id.remene)
    TextView remene;
    Unbinder unbinder;
    @BindView(R.id.diqu_listview)
    ListView diquListview;
    @BindView(R.id.sideBar)
    SideBar sideBar;
    @BindView(R.id.donghua)
    ImageView donghua;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.mainll)
    LinearLayout mainll;
    private LvChinaAdapter chinaAdapter;

    @Override
    protected DiquPresenter initPresenter() {
        return new DiquPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.guoneifragment_layout;
    }

    @Override
    protected void initView() {
        super.initView();

        mainll.setVisibility(View.GONE);
        remena.setText("上海");
        remenb.setText("广州");
        remenc.setText("西安");
        remend.setText("成都");
        remene.setText("杭州");

    }

    @Override
    public void initDiquSuccess(DiquBean.ResultEntity bean) {
        chinaAdapter = new LvChinaAdapter(bean.getChina().getCities(), getContext());
        chinaAdapter.setSideBar(sideBar);
        chinaAdapter.setListView(diquListview);
        diquListview.setAdapter(chinaAdapter);
        if (bean!=null){
            mainll.setVisibility(View.VISIBLE);
            ll.setVisibility(View.GONE);
        }

    }

    @Override
    public void initDiquFain(String msg) {

    }

    @Override
    protected void initData() {
        super.initData();
        String token = (String) SpUtil.getParam("token", "");
        mPresenter.initDiqu(token);
    }

    @OnClick({R.id.remena, R.id.remenb, R.id.remenc, R.id.remend, R.id.remene})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.remena:
                break;
            case R.id.remenb:
                break;
            case R.id.remenc:
                break;
            case R.id.remend:
                break;
            case R.id.remene:
                break;
        }
    }

}
