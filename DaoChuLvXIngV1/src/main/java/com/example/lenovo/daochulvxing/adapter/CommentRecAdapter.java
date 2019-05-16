package com.example.lenovo.daochulvxing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.bean.XiangBean;
import com.example.lenovo.daochulvxing.util.ImageLoader;

import java.util.ArrayList;

public class CommentRecAdapter extends RecyclerView.Adapter<CommentRecAdapter.ViewHolder> {
    private XiangBean.ResultEntity list;
    private Context context;

    public CommentRecAdapter(XiangBean.ResultEntity list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.comment_image_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (list.getReviews().get(position).getImages()!=null){
            Glide.with(context)
                    .load(list.getReviews().get(position).getImages())
                    .into(holder.image);
        }

    }

    @Override
    public int getItemCount() {
        return list.getReviews().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.comment_image);
        }
    }
}
