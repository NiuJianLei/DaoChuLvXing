package model;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.ZhuanTiBean;
import com.example.lenovo.daochulvxing.util.BaseObserver;
import com.example.lenovo.daochulvxing.util.HttpUtils;
import com.example.lenovo.daochulvxing.util.RxUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class SubJectModel extends BaseModel {
    public void initSubject(String token, final ICallBack<ArrayList<ZhuanTiBean.ResultEntity.BundlesEntity>> iCallBack){
        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
        Observable<ZhuanTiBean> zhuanTi = apiserver.getZhuanTi(token);
        zhuanTi.compose(RxUtils.<ZhuanTiBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ZhuanTiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(ZhuanTiBean zhuanTiBean) {
                        List<ZhuanTiBean.ResultEntity.BundlesEntity> bundles = zhuanTiBean.getResult().getBundles();
                        iCallBack.onSuccess((ArrayList<ZhuanTiBean.ResultEntity.BundlesEntity>) bundles);
                    }
                });

    }
}
