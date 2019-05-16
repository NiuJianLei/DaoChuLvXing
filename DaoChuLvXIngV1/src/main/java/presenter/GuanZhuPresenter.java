package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;
import com.example.lenovo.daochulvxing.bean.GuanZhu;

import java.util.ArrayList;

import model.GuanZhuModel;
import model.ICallBack;
import view.GuanZhuView;

public class GuanZhuPresenter extends BasePresenter<GuanZhuView> {
    GuanZhuModel model;
    @Override
    public void initModel() {
        this.model=new GuanZhuModel();
        mModels.add(model);
    }

    public void initGuanzhu(String token,int page){
        model.initGuanZhu(token, page, new ICallBack<ArrayList<GuanZhu.ResultEntity.BanmiEntity>>() {
            @Override
            public void onSuccess(ArrayList<GuanZhu.ResultEntity.BanmiEntity> bean) {
                mMvpView.Success(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.Erroor(msg);
            }
        });
    }
}
