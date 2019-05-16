package com.example.lenovo.daochulvxing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.bean.ZhuanTiBean;
import com.example.lenovo.daochulvxing.util.ImageLoader;

import java.util.ArrayList;

public class SubjectRecAdapter extends RecyclerView.Adapter<SubjectRecAdapter.ViewHolder> {
    private ArrayList<ZhuanTiBean.ResultEntity.BundlesEntity> list=new ArrayList<>();
    private Context context;

    public void setList(ArrayList<ZhuanTiBean.ResultEntity.BundlesEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public SubjectRecAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.subject_item,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textview.setText(list.get(position).getTitle());
        ImageLoader.setImage(context,list.get(position).getCardURL(),holder.image,R.mipmap.zhanweitu_home_kapian_hdpi);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textview;
        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.subject_title);
            image = itemView.findViewById(R.id.subject_image);
        }
    }
}
