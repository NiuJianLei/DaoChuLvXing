package com.example.lenovo.daochulvxing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.bean.CommentBean;
import com.example.lenovo.daochulvxing.util.ImageLoader;

import java.util.ArrayList;

public class MainCommentRecAdapter extends RecyclerView.Adapter<MainCommentRecAdapter.ViewHolder> {
    private ArrayList<CommentBean.ResultEntity.ReviewsEntity> list=new ArrayList<>();
    private Context context;

    public void setList(ArrayList<CommentBean.ResultEntity.ReviewsEntity> list) {
        this.list .addAll(list);
        notifyDataSetChanged();
    }

    public MainCommentRecAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.maincomment_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getUserName());
        holder.text.setText(list.get(position).getContent());
        holder.data.setText(list.get(position).getCreatedAt());
        ImageLoader.setCircleImage(context,list.get(position).getUserPhoto(),holder.photo,R.mipmap.zhanweitu_home_kapian_hdpi);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView data;
        private TextView text;
        private TextView name;
        private ImageView photo;

        public ViewHolder(View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.pinglun_photo);
            name = itemView.findViewById(R.id.name);
            text = itemView.findViewById(R.id.text);
            data = itemView.findViewById(R.id.data);
        }
    }
}
