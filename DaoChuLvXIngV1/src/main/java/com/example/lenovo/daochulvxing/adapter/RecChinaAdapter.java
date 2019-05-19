package com.example.lenovo.daochulvxing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.bean.DiquBean;
import com.example.lenovo.daochulvxing.util.SpUtil;
import com.example.lenovo.daochulvxing.weight.MyListView;
import com.example.lenovo.daochulvxing.weight.SideBar;

/**
 * Created by 灵风 on 2019/5/19.
 */

public class RecChinaAdapter extends RecyclerView.Adapter {

    private Context context;
    private DiquBean.ResultEntity.ChinaEntity chinaEntity;
    private SideBar mSideBar;
    private final int LOCATION_TYPE = 0;
    private final int HOT_CITY_TYPE = 1;
    private final int CITY_LIST_TYPE = 2;
    private RecHotCityAdapter recHotCityAdapter;

    public RecChinaAdapter(Context context, DiquBean.ResultEntity.ChinaEntity chinaEntity,SideBar mSideBar) {
        this.context = context;
        this.chinaEntity = chinaEntity;
        this.mSideBar = mSideBar;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == LOCATION_TYPE){
            return new LocationHolder(View.inflate(context,R.layout.item_location,null));
        }else if (viewType == HOT_CITY_TYPE){
            return new HotCityHolder(View.inflate(context,R.layout.item_hotcity,null));
        }else {
            return new CityListHolder(View.inflate(context,R.layout.item_city_list,null));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == LOCATION_TYPE){
            LocationHolder locationHolder = (LocationHolder) holder;
            locationHolder.tvCity.setText((String) SpUtil.getParam("cityName","北京"));
        }else if (getItemViewType(position) == HOT_CITY_TYPE){
            HotCityHolder hotCityHolder = (HotCityHolder) holder;
            hotCityHolder.mRecHotCity.setLayoutManager(new GridLayoutManager(context,3));
            recHotCityAdapter = new RecHotCityAdapter(context, chinaEntity.getTopCities());
            hotCityHolder.mRecHotCity.setAdapter(recHotCityAdapter);
            recHotCityAdapter.setOnItemClickListener(new RecHotCityAdapter.OnItemClickListener() {
                @Override
                public void onClick(int id,String name,LatLng latLng) {
                    if (onCityClickListener != null){
                        onCityClickListener.onCityClick(id,name,latLng);
                    }
                }
            });
        }else {
            CityListHolder cityListHolder = (CityListHolder) holder;
            LvChinaAdapter lvChinaAdapter = new LvChinaAdapter(chinaEntity.getCities(), context);
            lvChinaAdapter.setSideBar(mSideBar);
            lvChinaAdapter.setListView(cityListHolder.mLocationListview);
            cityListHolder.mLocationListview.setAdapter(lvChinaAdapter);
            lvChinaAdapter.setOnItemClickListener(new LvChinaAdapter.OnItemClickListener() {
                @Override
                public void onClick(int id, String name, LatLng latLng) {
                    if (onCityClickListener != null){
                        onCityClickListener.onCityClick(id, name,latLng);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return LOCATION_TYPE;
        }else if (position == 1){
            return HOT_CITY_TYPE;
        }else {
            return CITY_LIST_TYPE;
        }
    }

    class LocationHolder extends RecyclerView.ViewHolder {
        TextView tvCity;
        public LocationHolder(View itemView) {
            super(itemView);
            tvCity = itemView.findViewById(R.id.tv_city);
        }
    }

    class HotCityHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecHotCity;
        public HotCityHolder(View itemView) {
            super(itemView);
            mRecHotCity = itemView.findViewById(R.id.rec_hot_city);
        }
    }

    class CityListHolder extends RecyclerView.ViewHolder {
        MyListView mLocationListview;
        public CityListHolder(View itemView) {
            super(itemView);
            mLocationListview = itemView.findViewById(R.id.location_listview);
        }
    }
    private OnCityClickListener onCityClickListener;

    public void setOnCityClickListener(OnCityClickListener onCityClickListener) {
        this.onCityClickListener = onCityClickListener;
    }

    public interface OnCityClickListener{
        void onCityClick(int id, String name, LatLng latLng);
    }
}
