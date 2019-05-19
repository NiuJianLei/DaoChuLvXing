package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;
import com.example.lenovo.daochulvxing.bean.Map_TabBean;

import model.ICallBack;
import model.MapTabModel;
import view.MapTabView;
import view.MapView;

public class MapTabPresenter extends BasePresenter<MapTabView> {
    MapTabModel model;
    @Override
    public void initModel() {
        this.model=new MapTabModel();
        mModels.add(model);
    }
    public void initMapTab(String token,String id,String csid){
        model.initMapTab(token, id, csid, new ICallBack<Map_TabBean.ResultEntity>() {
            @Override
            public void onSuccess(Map_TabBean.ResultEntity bean) {
                mMvpView.initMapTabSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
            mMvpView.initMapTabFain(msg);
            }
        });
    }
}
