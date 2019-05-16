package com.example.lenovo.daochulvxing.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.bean.MyPerson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MianRecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<MyPerson.ResultEntity.BannersEntity> bannlist = new ArrayList<>();
    private ArrayList<MyPerson.ResultEntity.RoutesEntity> list = new ArrayList<>();
    private OnitenClickListener listener;

    public void setListener(OnitenClickListener listener) {
        this.listener = listener;
    }

    public MianRecAdapter(Context context) {
        this.context = context;
    }

    public void setBannlist(ArrayList<MyPerson.ResultEntity.BannersEntity> bannlist) {
        this.bannlist = bannlist;
        notifyDataSetChanged();
    }

    public void setList(ArrayList<MyPerson.ResultEntity.RoutesEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    private int BANNER = 0;
    private int TEXT = 1;
    private int Bundle=2;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            View view = View.inflate(context, R.layout.home_rec_banner_item, null);
            return new BannerVH(view);
        } else if (viewType==TEXT){
            View view = View.inflate(context, R.layout.home_rec_text_item, null);
            return new TextVH(view);
        }else {
            View view=View.inflate(context,R.layout.home_itme3_layout,null);
            return new BundleVH(view);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == BANNER) {
            BannerVH holder1 = (BannerVH) holder;
            Banner banner = holder1.banner;
            banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
            banner.setImages(bannlist)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            MyPerson.ResultEntity.BannersEntity path1 = (MyPerson.ResultEntity.BannersEntity) path;
                            Glide.with(context)
                                    .load(path1.getImageURL())
                                    .into(imageView);
                        }
                    }).start();
        } else if (getItemViewType(position) == TEXT){
            TextVH holder2 = (TextVH) holder;
            int index = position;
            if (bannlist.size()>0){
                index=position-1;
            }
            holder2.weizhi.setText(list.get(index).getCity());
            holder2.title.setText(list.get(index).getTitle());
            holder2.maimai.setText(list.get(index).getIntro());
            holder2.price.setText("¥"+list.get(index).getPrice());

            Glide.with(context)
                    .load(list.get(index).getCardURL())
                    .into(holder2.image);
            final int finalIndex = index;
            holder2.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        listener.listener(finalIndex,list.get(finalIndex).getId());
                    }
                }
            });
        }else{
            int index = position;
            if (bannlist.size() > 0) {
                index -= 1;
            }
            BundleVH holder3 = (BundleVH) holder;
            com.example.lenovo.daochulvxing.util.ImageLoader.setImage(context,list.get(index).getCardURL(),holder3.image3,R.mipmap.zhanweitu_home_kapian_hdpi);
            final int finalIndex = index;
            holder3.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onBundleClickListener != null){
                        onBundleClickListener.onClick(list.get(finalIndex).getContentURL(),list.get(finalIndex).getTitle());
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {

        if (bannlist.size()>0){
            return list.size()+1;
        }else{
            return list.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0 && bannlist.size()>0){
            return 0;
        }else {
            int index = position;
            if (bannlist.size() > 0) {
                index -=1;
            }
            if (list.get(index).getType().equals("route")) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    class BannerVH extends RecyclerView.ViewHolder {

        private Banner banner;

        public BannerVH(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.home_banner);
        }
    }

    class TextVH extends RecyclerView.ViewHolder {
        private TextView goumai;
        private ImageView image;
        private TextView maimai;
        private Button price;
        private TextView title;
        private TextView weizhi;

        public TextVH(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.rec_image);
            maimai = itemView.findViewById(R.id.rec_maimaimai);
            price = itemView.findViewById(R.id.rec_price);
            title = itemView.findViewById(R.id.rec_title);
            weizhi = itemView.findViewById(R.id.rec_weizhi);
        }
    }

    class BundleVH extends RecyclerView.ViewHolder {

        private ImageView image3;

        public BundleVH(View itemView) {
            super(itemView);
            image3 = itemView.findViewById(R.id.homeitem3_image);
        }
    }

    public interface OnitenClickListener{
        void listener(int position,int id);
    }

    private OnBundleClickListener onBundleClickListener;

    public void setOnBundleClickListener(OnBundleClickListener onBundleClickListener) {
        this.onBundleClickListener = onBundleClickListener;
    }

    public interface OnBundleClickListener{
        void onClick(String url,String title);
    }
}
