package com.example.lenovo.daochulvxing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.daochulvxing.bean.DiquBean;

import java.util.ArrayList;

public class DiquRecAdapter extends RecyclerView.Adapter<DiquRecAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DiquBean.ResultEntity> list=new ArrayList<>();

    public void setList(ArrayList<DiquBean.ResultEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public DiquRecAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
