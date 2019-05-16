package com.example.lenovo.daochulvxing.adapter;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.bean.XiangBean;
import com.example.lenovo.daochulvxing.util.ImageLoader;

import org.w3c.dom.Comment;
import org.w3c.dom.Text;

import java.util.ArrayList;


public class XiangRecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int HOME=0;
    private int AUTHOR=1;
    private int COMMENT=2;
    private int FENXIANG=3;
    private XiangBean.ResultEntity bean;
    private Context context;
    private OnitenclickListener listener;
    private OnItemFenXiangListener fenXiangListener;
    private OnItemShouCangListener shouCangListener;
    private OnItemJiaZaiListener jiaZaiListener;

    public void setFenXiangListener(OnItemFenXiangListener fenXiangListener) {
        this.fenXiangListener = fenXiangListener;
    }

    public void setShouCangListener(OnItemShouCangListener shouCangListener) {
        this.shouCangListener = shouCangListener;
    }

    public void setJiaZaiListener(OnItemJiaZaiListener jiaZaiListener) {
        this.jiaZaiListener = jiaZaiListener;
    }

    public void setListener(OnitenclickListener listener) {
        this.listener = listener;
    }


    public XiangRecAdapter(XiangBean.ResultEntity bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==HOME){
            View view=View.inflate(context,R.layout.xiang_author_item,null);
            return new HomeVP(view);
        }else if (viewType==AUTHOR){
            View view=View.inflate(context,R.layout.comment_itme2_layout,null);
            return new AuthorVH(view);
        }else if (viewType==COMMENT){
            View view=View.inflate(context,R.layout.comment_itme_layout,null);
            return new CommentVH(view);
        }else{
            View view=View.inflate(context,R.layout.fenxiang_item,null);
            return new FenXiangVH(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position)==HOME){
            HomeVP holder1 = (HomeVP) holder;
            holder1.home_desc.setText(bean.getRoute().getIntro());
            holder1.home_dizhi.setText(bean.getRoute().getCity());
            holder1.home_title.setText(bean.getRoute().getTitle());
            ImageLoader.setImage(context,bean.getRoute().getCardURL(),holder1.home_image,R.mipmap.zhanweitu_home_kapian_hdpi);
           holder1.home_back.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   listener.listener(position);
               }
           });
        }else if (getItemViewType(position)==AUTHOR){
            AuthorVH holder1 = (AuthorVH) holder;
            holder1.author_desc.setText(bean.getBanmi().getIntroduction());
            holder1.author_dizhi.setText(bean.getBanmi().getLocation());
            holder1.author_name.setText(bean.getBanmi().getName());
            holder1.author_zhiye.setText(bean.getBanmi().getOccupation());
            ImageLoader.setImage(context,bean.getBanmi().getPhoto(),holder1.author_photo,R.mipmap.zhanweitu_home_kapian_hdpi);
        }else if (getItemViewType(position)==COMMENT){
            CommentVH holder1 = (CommentVH) holder;
            holder1.comment_name.setText(bean.getReviews().get(position-2).getUserName());
            holder1.comment_neirong.setText(bean.getReviews().get(position-2).getContent());
            holder1.comment_shijian.setText(bean.getReviews().get(position-2).getCreatedAt());
            ImageLoader.setCircleImage(context,bean.getReviews().get(position-2).getUserPhoto(),holder1.comment_photo,R.mipmap.zhanweitu_home_kapian_hdpi);
        }else{
            final FenXiangVH holder1 = (FenXiangVH) holder;
            holder1.fenxiang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fenXiangListener.FenXiangListener(position);
                }
            });
            holder1.jiazai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    jiaZaiListener.JiaZaiListener(position,bean.getRoute().getId());
                }
            });
            holder1.shoucang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    shouCangListener.ShouCangListener(position,bean.getRoute().getId());
                    if (bean.getRoute().isIsCollected()){
                        Glide.with(context).load(R.mipmap.collect_default).into(holder1.shoucangimage);
                        bean.getRoute().setIsCollected(false);
                    }else{
                        Glide.with(context).load(R.mipmap.collect_highlight).into(holder1.shoucangimage);
                        bean.getRoute().setIsCollected(true);
                    }
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return bean.getReviews().size()+3;
    }
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HOME;
        } else if (position == 1) {
            return AUTHOR;
        } else if (position==getItemCount()-1){
            return FENXIANG;
        }else{
            return COMMENT;
        }
    }

    class HomeVP extends RecyclerView.ViewHolder {
        private final View home_back;
        private TextView home_dizhi;
        private TextView home_title;
        private TextView home_desc;
        private ImageView home_image;
        public HomeVP(View itemView) {
            super(itemView);
            home_dizhi = itemView.findViewById(R.id.xiang_dizhi);
            home_title = itemView.findViewById(R.id.xiang_title);
            home_desc = itemView.findViewById(R.id.xiang_desc);
            home_image = itemView.findViewById(R.id.xiang_image);
            home_back = itemView.findViewById(R.id.xiang_back);
        }
    }
    class AuthorVH extends RecyclerView.ViewHolder {
        private ImageView author_photo;
        private TextView author_name;
        private TextView author_zhiye;
        private TextView author_dizhi;
        private TextView author_desc;
        public AuthorVH(View itemView) {
            super(itemView);
            author_photo = itemView.findViewById(R.id.author_photo);
            author_name = itemView.findViewById(R.id.author_name);
            author_zhiye = itemView.findViewById(R.id.author_zhiye);
            author_dizhi = itemView.findViewById(R.id.author_dizhi);
            author_desc = itemView.findViewById(R.id.author_desc);
        }
    }
    class CommentVH extends RecyclerView.ViewHolder {
        private ImageView comment_photo;
        private TextView comment_name;
        private TextView comment_shijian;
        private TextView comment_neirong;
        private RecyclerView comment_recycler;

        public CommentVH(View itemView) {
            super(itemView);
            comment_photo = itemView.findViewById(R.id.comment_photo);
            comment_name = itemView.findViewById(R.id.comment_name);
            comment_shijian = itemView.findViewById(R.id.comment_shijian);
            comment_neirong = itemView.findViewById(R.id.comment_neirong);
            comment_recycler = itemView.findViewById(R.id.comment_recycler);
        }
    }
    class FenXiangVH extends RecyclerView.ViewHolder {

        private ImageView shoucangimage;
        private TextView jiazai;
        private TextView fenxiang;
        private TextView shoucang;

        public FenXiangVH(View itemView) {
            super(itemView);
            shoucang = itemView.findViewById(R.id.shoucang);
            fenxiang = itemView.findViewById(R.id.fenxiang);
            jiazai = itemView.findViewById(R.id.jiazai);
            shoucangimage = itemView.findViewById(R.id.shoucang_image);
        }
    }

    public interface OnitenclickListener{
        void listener(int position);
    }

    public interface OnItemFenXiangListener{
        void FenXiangListener(int position);
    }
    public interface OnItemShouCangListener{
        void ShouCangListener(int position,int id);
    }
    public interface OnItemJiaZaiListener{
        void JiaZaiListener(int position,int id);
    }
}
