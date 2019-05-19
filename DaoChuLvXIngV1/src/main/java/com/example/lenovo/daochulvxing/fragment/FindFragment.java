package com.example.lenovo.daochulvxing.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.adapter.MapVpAdapter;
import com.example.lenovo.daochulvxing.base.BaseFragment;
import com.example.lenovo.daochulvxing.bean.Map_TabBean;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.OnClick;
import presenter.EmptyPresenter;
import presenter.MapTabPresenter;
import view.EmptyView;
import view.MapTabView;

public class FindFragment extends BaseFragment<MapTabView, MapTabPresenter> implements MapTabView{
    @BindView(R.id.bmapView)
    MapView mMapView;
    @BindView(R.id.map_goto)
    ImageView mapGoto;
    @BindView(R.id.map_dingwei)
    ImageView mapDingwei;
    @BindView(R.id.map_tab)
    TabLayout mapTab;
    @BindView(R.id.map_vp)
    ViewPager mapVp;
    private BaiduMap baiduMap;
    private LocationClient mLocationClient;
    private LatLng latLng;
    private ArrayList<Fragment> fraglist;
    private ArrayList<Map_TabBean.ResultEntity.AllTagsEntity> titlelist;
    private List<OverlayOptions> options;

    @Override
    protected void initView() {
        super.initView();
        baiduMap = mMapView.getMap();
        baiduMap.setMyLocationEnabled(true);


        //创建OverlayOptions的集合
        options = new ArrayList<>();

        mLocationClient = new LocationClient(getContext());
        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        //设置locationClientOption
        mLocationClient.setLocOption(option);
        //注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
        //开启地图定位图层
        mLocationClient.start();

    }

    @Override
    protected void initListener() {
        super.initListener();
        mapGoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Intent(getContext(),)
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        String token = (String) SpUtil.getParam("token", "");
        mPresenter.initMapTab(token,"","10");
    }

    @Override
    protected MapTabPresenter initPresenter() {
        return new MapTabPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.find_layout;
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @OnClick({R.id.map_goto, R.id.map_dingwei})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.map_goto:

                break;
            case R.id.map_dingwei:
                MapStatusUpdate status2 = MapStatusUpdateFactory.newLatLng(latLng);
                baiduMap.setMapStatus(status2);
                break;
        }
    }

    @Override
    public void initMapTabSuccess(Map_TabBean.ResultEntity tabbean) {
        fraglist = new ArrayList<>();
        titlelist = new ArrayList<>();
        for (int i = 0; i < tabbean.getAllTags().size(); i++) {
            MapTabFragment mapTabFragment = new MapTabFragment();
            fraglist.add(mapTabFragment);
            titlelist.add(tabbean.getAllTags().get(i));
            MapVpAdapter mapVpAdapter = new MapVpAdapter(getChildFragmentManager(), fraglist, titlelist);
            mapVp.setAdapter(mapVpAdapter);
            mapTab.setupWithViewPager(mapVp);
        }
        //地图加大头针
        for (Map_TabBean.ResultEntity.DisplaySpotsEntity spotsEntity : tabbean.getDisplaySpots()) {
            LatLng point = new LatLng(spotsEntity.getLatitude(), spotsEntity.getLongitude());
            OverlayOptions option = null;
            try {
                option = new MarkerOptions()
                        .title(spotsEntity.getTitle())
                        .position(point)
                        .icon(BitmapDescriptorFactory.fromBitmap(Ion.with(getContext()).load(spotsEntity.getDefaultMapIcon()).asBitmap().get()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            options.add(option);
        }
        baiduMap.addOverlays(options);
    }

    @Override
    public void initMapTabFain(String msg) {

    }


    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mMapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            baiduMap.setMyLocationData(locData);
            latLng = new LatLng(location.getLatitude(), location.getLongitude());
        }
    }

}
