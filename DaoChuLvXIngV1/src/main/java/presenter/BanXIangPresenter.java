package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;
import com.example.lenovo.daochulvxing.bean.BanXiangBean;

import model.BanXiangModel;
import model.ICallBack;
import view.BanXiangView;

public class BanXIangPresenter extends BasePresenter<BanXiangView> {
    private BanXiangModel model;
    @Override
    public void initModel() {
        this.model=new BanXiangModel();
        mModels.add(model);
    }
    public void initBanXiang(int id,int page,String token){
        model.initBanXiang(id, page, token, new ICallBack<BanXiangBean.ResultEntity>() {
            @Override
            public void onSuccess(BanXiangBean.ResultEntity bean) {
                mMvpView.Success(bean);
            }

            @Override
            public void onFail(String msg) {
            mMvpView.fain(msg);
            }
        });
    }
}
