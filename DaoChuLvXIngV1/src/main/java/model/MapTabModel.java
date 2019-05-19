package model;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.Map_TabBean;
import com.example.lenovo.daochulvxing.util.BaseObserver;
import com.example.lenovo.daochulvxing.util.HttpUtils;
import com.example.lenovo.daochulvxing.util.RxUtils;

import java.security.Provider;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class MapTabModel extends BaseModel {
    public void initMapTab(String token, String id, String csid, final ICallBack<Map_TabBean.ResultEntity> iCallBack){
        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
        final Observable<Map_TabBean> mapTab = apiserver.getMapTab(token, id, csid);
        mapTab.compose(RxUtils.<Map_TabBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Map_TabBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(Map_TabBean map_tabBean) {
                        Map_TabBean.ResultEntity result = map_tabBean.getResult();
                        iCallBack.onSuccess(result);
                    }
                });
    }

}
