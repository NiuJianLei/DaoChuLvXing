package com.example.lenovo.daochulvxing.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
   protected V mMvpView;
  public ArrayList<BaseModel> mModels=new ArrayList<>();

   public void bind(V view){
       this.mMvpView=view;
   }

    public BasePresenter() {
       initModel();
    }

    public abstract void initModel() ;

    public void onDestory() {
        //打断P层和V层的联系,
        mMvpView = null;
        //掐断网络请求
        if (mModels.size()>0){
            for (BaseModel model :mModels) {
                model.onDestory();
            }
            mModels.clear();
        }
    }
}
