package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;
import com.example.lenovo.daochulvxing.bean.VersionInfo;

import model.ICallBack;
import model.ToolsModel;
import view.ToolsView;

public class ToolsPresenter extends BasePresenter<ToolsView> {
    ToolsModel model;

    @Override
    public void initModel() {
    this.model=new ToolsModel();
    mModels.add(model);
    }
    public void initVersionInfo(String token){
        model.initVersionInfo(token, new ICallBack<VersionInfo>() {
            @Override
            public void onSuccess(VersionInfo bean) {
                mMvpView.Success(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.fain(msg);
            }
        });
    }
}
