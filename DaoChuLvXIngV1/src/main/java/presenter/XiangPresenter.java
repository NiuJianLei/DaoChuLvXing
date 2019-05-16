package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;
import com.example.lenovo.daochulvxing.bean.XiangBean;

import model.ICallBack;
import model.XiangModel;
import view.XiangView;

public class XiangPresenter extends BasePresenter<XiangView> {
    XiangModel model;
    @Override
    public void initModel() {
        this.model=new XiangModel();
        mModels.add(model);
    }
    public void initXiangQing(int id,String token){
        model.initXiangQing(id, token, new ICallBack<XiangBean.ResultEntity>() {
            @Override
            public void onSuccess(XiangBean.ResultEntity bean) {
                mMvpView.Success(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.fain(msg);
            }
        });
    }
}
