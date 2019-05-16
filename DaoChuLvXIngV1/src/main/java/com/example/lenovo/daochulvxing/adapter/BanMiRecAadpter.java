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
import com.example.lenovo.daochulvxing.bean.BanMiBean;
import com.example.lenovo.daochulvxing.util.SpUtil;

import java.util.ArrayList;

public class BanMiRecAadpter extends RecyclerView.Adapter<BanMiRecAadpter.ViewHolder> {
    private ArrayList<BanMiBean.ResultEntity.BanmiEntity> list=new ArrayList<>();
    private Context context;
    private OnItenClickListener like;
    private OnItenClick listener;

    public void setListener(OnItenClick listener) {
        this.listener = listener;
    }

    public void setLike(OnItenClickListener like) {
        this.like = like;
    }

    public void setList(ArrayList<BanMiBean.ResultEntity.BanmiEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public BanMiRecAadpter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.banmi_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Glide.with(context)
                .load(list.get(position).getPhoto())
                .into(holder.touxian);
        holder.name.setText(list.get(position).getName());
        holder.dizhi.setText(list.get(position).getLocation());
        holder.zuozhe.setText(list.get(position).getOccupation());
        holder.guanzhu.setText(list.get(position).getId()+"个人关注");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.listener(position,list.get(position).getId());
            }
        });
        holder.follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).isIsFollowed()){
                    like.remove(list.get(position).getId());
                    Glide.with(context)
                            .load(R.mipmap.follow_unselected)
                            .into(holder.follow);
                    list.get(position).setIsFollowed(false);

                }else {
                    like.like(list.get(position).getId());
                    Glide.with(context)
                            .load(R.mipmap.follow)
                            .into(holder.follow);
                    list.get(position).setIsFollowed(true);
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }else {
            return 0;
        }
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

    public interface OnItenClickListener{
        void like(int id);
        void remove(int id);
    }

    public interface OnItenClick{
        void listener(int position,int id);
    }



}
