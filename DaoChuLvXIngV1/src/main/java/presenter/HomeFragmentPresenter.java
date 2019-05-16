package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;
import com.example.lenovo.daochulvxing.bean.MyPerson;

import model.HomeFragmentModel;
import model.ICallBack;
import view.HomeFragmentView;

public class HomeFragmentPresenter extends BasePresenter<HomeFragmentView> {
    private HomeFragmentModel model;

    @Override
    public void initModel() {

        this.model=new HomeFragmentModel();
        mModels.add(model);
    }

    public void getHome(int page,String token){
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
