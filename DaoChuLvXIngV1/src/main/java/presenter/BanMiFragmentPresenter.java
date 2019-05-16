package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;
import com.example.lenovo.daochulvxing.bean.BanMiBean;

import java.util.ArrayList;

import model.BanMiFragmentModel;
import model.ICallBack;
import view.BanMiFragmentView;

public class BanMiFragmentPresenter extends BasePresenter<BanMiFragmentView> {
    BanMiFragmentModel model;

    @Override
    public void initModel() {
        this.model=new BanMiFragmentModel();
        mModels.add(model);
    }

    public void getBanMi(int page,String token) {

        model.getBanMi(page, token, new ICallBack<ArrayList<BanMiBean.ResultEntity.BanmiEntity>>() {
            @Override
            public void onSuccess(ArrayList<BanMiBean.ResultEntity.BanmiEntity> bean) {
                mMvpView.Success(bean);
            }

            @Override
            public void onFail(String msg) {

            }
        });

    }
    public void initLike(int id,String token){
        model.initLike(id, token, new ICallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                mMvpView.followSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.followFain(msg);
            }
        });

    }
    public void initOutFollow(int id,String token){
        model.initRemove(id, token, new ICallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                mMvpView.followSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.followFain(msg);
            }
        });
    }



}
