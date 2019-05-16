package com.example.lenovo.daochulvxing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.bean.BanXiangBean;

import java.util.ArrayList;

public class XianLuRecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<BanXiangBean.ResultEntity.ActivitiesEntity> list=new ArrayList<>();

    public void setList(ArrayList<BanXiangBean.ResultEntity.ActivitiesEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public XianLuRecAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            View view= View.inflate(context,R.layout.xianglu_recitem_layout,null);
            return new XianLuVHA(view);
        }else{
            View view= View.inflate(context,R.layout.xianglu_recitem_layout2,null);
            return new XianLuVHB(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position)==0){
            XianLuVHA holder1 = (XianLuVHA) holder;
            holder1.dateA.setText(list.get(position).getDate());
            if (list.get(position).getImages() != null && list.get(position).getImages().size()==1){
                RequestOptions placeholder = new RequestOptions()
                        .placeholder(R.mipmap.zhanweitu_home_kapian_hdpi);
                Glide.with(context)
                        .load(list.get(position).getImages().get(0))
                        .apply(placeholder)
                        .into(holder1.iv_bigA);
            }
            holder1.tv_praise_countA.setText(list.get(position).getLikeCount()+"");
            holder1.tv_reply_countA.setText(list.get(position).getReplyCount()+"");
            if (list.get(position).getImages()!=null && list.size()>0){
                holder1.iv_bigA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onitenClickListener.listener(list.get(position).getImages().get(0));
                    }
                });
            }
        }else{
            XianLuVHB holder1 = (XianLuVHB) holder;
            holder1.dateB.setText(list.get(position).getDate());
            holder1.tv_reply_countB.setText(list.get(position).getReplyCount()+"");
            holder1.tv_praise_countB.setText(list.get(position).getLikeCount()+"");
            RecyclerView recycler = holder1.recViewB;
            recycler.setLayoutManager(new LinearLayoutManager(context,LinearLayout.HORIZONTAL,false));
            XianLuImageRecAdapter adapter = new XianLuImageRecAdapter(context, (ArrayList<String>) list.get(position).getImages());
            recycler.setAdapter(adapter);
            if (list.get(position).getImages()!=null&& list.size()>0){
                adapter.setListener(new XianLuImageRecAdapter.OnitenClickListener() {
                    @Override
                    public void listener(String url) {
                        onitenClickListener.listener(url);
                    }
                });
            }

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getImages().size()>1){
            return 1;
        }else{
            return 0;
        }
    }

    class XianLuVHA extends RecyclerView.ViewHolder {

        private TextView dateA;
        private ImageView iv_bigA;
        private TextView tv_reply_countA;
        private TextView tv_praise_countA;

        public XianLuVHA(View itemView) {
            super(itemView);
            dateA = itemView.findViewById(R.id.tv_date);
            iv_bigA = itemView.findViewById(R.id.iv_big);
            tv_reply_countA = itemView.findViewById(R.id.tv_reply_count);
            tv_praise_countA = itemView.findViewById(R.id.tv_praise_count);

        }
    }
    class XianLuVHB extends RecyclerView.ViewHolder {

        private TextView dateB;
        private RecyclerView recViewB;
        private TextView tv_reply_countB;
        private TextView tv_praise_countB;

        public XianLuVHB(View itemView) {
            super(itemView);
            dateB = itemView.findViewById(R.id.tv_date);
            tv_reply_countB = itemView.findViewById(R.id.tv_reply_count);
            recViewB = itemView.findViewById(R.id.recView);
            tv_praise_countB = itemView.findViewById(R.id.tv_praise_count);
        }
    }
    private OnitenClickListener onitenClickListener;

    public void setOnitenClickListener(OnitenClickListener onitenClickListener) {
        this.onitenClickListener = onitenClickListener;
    }

    public interface OnitenClickListener{
        void listener(String url);
    }
}
