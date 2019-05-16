package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;
import com.example.lenovo.daochulvxing.bean.MyPerson;

import model.DongTaiModel;
import model.ICallBack;
import view.DongTaiView;

public class DongTaiPresenter extends BasePresenter<DongTaiView> {
    DongTaiModel model;

    @Override
    public void initModel() {
        this.model=new DongTaiModel();
        mModels.add(model);
    }

    public void initDonTai(int page,String token){
        model.getHome(page, token, new ICallBack<MyPerson.ResultEntity>() {
            @Override
            public void onSuccess(MyPerson.ResultEntity bean) {
                mMvpView.initSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.initFina(msg);
            }
        });
    }
}
