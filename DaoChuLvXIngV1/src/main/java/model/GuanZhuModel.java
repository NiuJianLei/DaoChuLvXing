package model;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.GuanZhu;
import com.example.lenovo.daochulvxing.util.BaseObserver;
import com.example.lenovo.daochulvxing.util.HttpUtils;
import com.example.lenovo.daochulvxing.util.RxUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GuanZhuModel extends BaseModel {
    public void initGuanZhu(String token, int page, final ICallBack<ArrayList<GuanZhu.ResultEntity.BanmiEntity>>iCallBack){
        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
        Observable<GuanZhu> guanZhu1 = apiserver.getGuanZhu(token, page);
        guanZhu1.compose(RxUtils.<GuanZhu>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<GuanZhu>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(GuanZhu guanZhu) {
                        List<GuanZhu.ResultEntity.BanmiEntity> banmi = guanZhu.getResult().getBanmi();
                        iCallBack.onSuccess((ArrayList<GuanZhu.ResultEntity.BanmiEntity>) banmi);
                    }
                });
    }
}
