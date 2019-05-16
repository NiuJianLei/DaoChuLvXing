package model;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.MyPerson;
import com.example.lenovo.daochulvxing.util.BaseObserver;
import com.example.lenovo.daochulvxing.util.HttpUtils;
import com.example.lenovo.daochulvxing.util.RxUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DongTaiModel extends BaseModel {
    public void getHome(int page, String token, final ICallBack<MyPerson.ResultEntity> iCallBack){
        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
        Observable<MyPerson> gethome = apiserver.gethome(page, token);
        gethome.compose(RxUtils.<MyPerson>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<MyPerson>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyPerson myPerson) {
                        iCallBack.onSuccess(myPerson.getResult());
                    }
                });
    }
}
