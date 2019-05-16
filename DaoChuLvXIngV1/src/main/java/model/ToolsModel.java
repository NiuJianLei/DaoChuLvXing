package model;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.VersionInfo;
import com.example.lenovo.daochulvxing.util.BaseObserver;
import com.example.lenovo.daochulvxing.util.HttpUtils;
import com.example.lenovo.daochulvxing.util.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ToolsModel extends BaseModel {
    public void initVersionInfo(String token, final ICallBack<VersionInfo> iCallBack){
        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
        Observable<VersionInfo> versionInfo = apiserver.getVersionInfo(token);
        versionInfo.compose(RxUtils.<VersionInfo>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<VersionInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }
                    @Override
                    public void onNext(VersionInfo versionInfo) {
                        iCallBack.onSuccess(versionInfo);
                    }
                });
    }
}
