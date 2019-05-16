package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;
import com.example.lenovo.daochulvxing.bean.ZhuanTiBean;

import java.util.ArrayList;

import model.ICallBack;
import model.SubJectModel;
import view.SubJectView;

public class SubJectPresenter extends BasePresenter<SubJectView> {
    SubJectModel model;
    @Override
    public void initModel() {
        this.model= new SubJectModel();
        mModels.add(model);
    }
    public void initSubject(String token){
        model.initSubject(token, new ICallBack<ArrayList<ZhuanTiBean.ResultEntity.BundlesEntity>>() {
            @Override
            public void onSuccess(ArrayList<ZhuanTiBean.ResultEntity.BundlesEntity> bean) {
                mMvpView.Success(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.fina(msg);
            }
        });

    }
}
