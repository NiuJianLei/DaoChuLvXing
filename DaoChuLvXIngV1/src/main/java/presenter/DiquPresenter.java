package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;
import com.example.lenovo.daochulvxing.bean.DiquBean;

import model.DiquModel;
import model.ICallBack;
import view.DiquView;

public class DiquPresenter extends BasePresenter<DiquView> {
    DiquModel model;

    @Override
    public void initModel() {
        this.model=new DiquModel();
        mModels.add(model);
    }
    public void initDiqu(String token){
        model.initDiqu(token, new ICallBack<DiquBean.ResultEntity>() {
            @Override
            public void onSuccess(DiquBean.ResultEntity bean) {
                mMvpView.initDiquSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.initDiquFain(msg);
            }
        });
    }
}
