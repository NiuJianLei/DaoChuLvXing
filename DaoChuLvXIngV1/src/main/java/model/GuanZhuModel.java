package model;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.GuanZhu;

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
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ServiceList.singUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceList serviceList = build.create(ServiceList.class);
        Observable<GuanZhu> guanZhu = serviceList.getGuanZhu(token, page);
        guanZhu.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<GuanZhu>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GuanZhu guanZhu) {
                        List<GuanZhu.ResultEntity.BanmiEntity> banmi = guanZhu.getResult().getBanmi();
                        iCallBack.onSuccess((ArrayList<GuanZhu.ResultEntity.BanmiEntity>) banmi);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
