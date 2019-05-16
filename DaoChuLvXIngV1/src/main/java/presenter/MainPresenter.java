package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;
import com.example.lenovo.daochulvxing.bean.LoginInfo;

import model.ICallBack;
import model.MainModel;
import view.MainView;

public class MainPresenter extends BasePresenter<MainView> {
    private MainModel model;
    @Override
    public void initModel() {
        model = new MainModel();
        mModels.add(model);
    }

    public void getLogin(String uid){
        model.initLogin(uid, new ICallBack<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo bean) {
                mMvpView.initSuccess(bean.getResult());
            }

            @Override
            public void onFail(String msg) {
                mMvpView.initEroor(msg);
            }
        });
    }
}
