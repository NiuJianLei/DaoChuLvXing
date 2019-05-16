package com.example.lenovo.daochulvxing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.daochulvxing.R;

import java.util.ArrayList;

public class XianLuImageRecAdapter extends RecyclerView.Adapter<XianLuImageRecAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> list=new ArrayList<>();


    public XianLuImageRecAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.xianglu_image_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        RequestOptions placeholder = new RequestOptions()
                .placeholder(R.mipmap.zhanweitu_home_kapian_hdpi);
        Glide.with(context)
                .load(list.get(position))
                .apply(placeholder)
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.listener(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.xianglu_image);
        }
    }

    private OnitenClickListener listener;

    public void setListener(OnitenClickListener listener) {
        this.listener = listener;
    }

    public interface OnitenClickListener{
        void listener(String url);
    }

}
