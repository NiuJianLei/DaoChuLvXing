package com.example.lenovo.daochulvxing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.bean.MyPerson;

import java.util.ArrayList;

public class DongTaiRecAdapter extends RecyclerView.Adapter<DongTaiRecAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MyPerson.ResultEntity.RoutesEntity> list = new ArrayList<>();

    public void setList(ArrayList<MyPerson.ResultEntity.RoutesEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public DongTaiRecAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.home_rec_text_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.weizhi.setText(list.get(position).getCity());
        holder.title.setText(list.get(position).getTitle());
        holder.maimai.setText(list.get(position).getIntro());
        holder.price.setText("¥"+list.get(position).getPrice());
        Glide.with(context)
                .load(list.get(position).getCardURL())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView maimai;
        private Button price;
        private TextView title;
        private TextView weizhi;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.rec_image);
            maimai = itemView.findViewById(R.id.rec_maimaimai);
            price = itemView.findViewById(R.id.rec_price);
            title = itemView.findViewById(R.id.rec_title);
            weizhi = itemView.findViewById(R.id.rec_weizhi);
        }
    }
}
