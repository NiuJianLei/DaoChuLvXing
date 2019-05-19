package model;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.LoginInfo;
import com.example.lenovo.daochulvxing.util.BaseObserver;
import com.example.lenovo.daochulvxing.util.HttpUtils;
import com.example.lenovo.daochulvxing.util.RxUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {
    public void initLogin (String uid, final ICallBack<LoginInfo> iCallBack){
        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
        Observable<LoginInfo> login1 = apiserver.getLogin(uid);
        login1.compose(RxUtils.<LoginInfo>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<LoginInfo>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(LoginInfo loginInfo) {
                        iCallBack.onSuccess(loginInfo);
                    }
                });
    }
}
