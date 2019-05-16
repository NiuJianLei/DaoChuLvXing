package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;

import model.APresenterFragmentModel;
import model.ICallBack;
import view.APersonFragmentView;

public class APersonFragmentPresenter extends BasePresenter<APersonFragmentView> {
    APresenterFragmentModel model;
    @Override
    public void initModel() {
        this.model=new APresenterFragmentModel();
        mModels.add(model);
    }
    public void initSetting(String token,String info,int type){
        model.initSetting(token, info, type, new ICallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                mMvpView.initSuccess();
            }

            @Override
            public void onFail(String msg) {
            mMvpView.initfina(msg);
            }
        });
    }
}
