package com.example.lenovo.daochulvxing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.bean.GuanZhu;

import java.util.ArrayList;

public class GuanZhuRecAdapter extends RecyclerView.Adapter<GuanZhuRecAdapter.ViewHolder> {
    private ArrayList<GuanZhu.ResultEntity.BanmiEntity> list=new ArrayList<>();
    private Context context;

    public void setList(ArrayList<GuanZhu.ResultEntity.BanmiEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public GuanZhuRecAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.banmi_item,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).getPhoto())
                .into(holder.touxian);
        holder.name.setText(list.get(position).getName());
        holder.dizhi.setText(list.get(position).getLocation());
        holder.zuozhe.setText(list.get(position).getOccupation());
        holder.guanzhu.setText(list.get(position).getId()+"个人关注");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView follow;
        private TextView dizhi;
        private TextView zuozhe;
        private TextView guanzhu;
        private TextView name;
        private ImageView touxian;
        public ViewHolder(View itemView) {
            super(itemView);
            touxian = itemView.findViewById(R.id.banmi_touxiang);
            name = itemView.findViewById(R.id.banmi_name);
            guanzhu = itemView.findViewById(R.id.banmi_guanzhu);
            dizhi = itemView.findViewById(R.id.banmi_dizhi);
            zuozhe = itemView.findViewById(R.id.banmi_zuozhe);
            follow = itemView.findViewById(R.id.banmi_follow);
        }
    }
}
