package com.example.lenovo.daochulvxing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.bean.DiquBean;

import java.util.List;

/**
 * Created by 灵风 on 2019/5/19.
 */

public class RecHotCityAdapter extends RecyclerView.Adapter<RecHotCityAdapter.ViewHolder> {

    private Context context;
    private List<DiquBean.ResultEntity.ChinaEntity.TopCitiesEntity> list;

    public RecHotCityAdapter(Context context, List<DiquBean.ResultEntity.ChinaEntity.TopCitiesEntity> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.item_hot_city,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvCity.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null){
                    onItemClickListener.onClick(list.get(position).getId(),list.get(position).getName(),
                            new LatLng(list.get(position).getLatitude(),list.get(position).getLongitude()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCity;
        public ViewHolder(View itemView) {
            super(itemView);
            tvCity = itemView.findViewById(R.id.tv_city);
        }
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClick(int id, String name, LatLng latLng);
    }
}
