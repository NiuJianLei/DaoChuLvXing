package model;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.DiquBean;
import com.example.lenovo.daochulvxing.util.BaseObserver;
import com.example.lenovo.daochulvxing.util.HttpUtils;
import com.example.lenovo.daochulvxing.util.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class DiquModel extends BaseModel {
    public void initDiqu(String token, final ICallBack<DiquBean.ResultEntity> iCallBack){
        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
        final Observable<DiquBean> diqu = apiserver.getDiqu(token);
        diqu.compose(RxUtils.<DiquBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DiquBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(DiquBean diquBean) {
                        DiquBean.ResultEntity result = diquBean.getResult();
                        iCallBack.onSuccess(result);
                    }
                });
    }
}
