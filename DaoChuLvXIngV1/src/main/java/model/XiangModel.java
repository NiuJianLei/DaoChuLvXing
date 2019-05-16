package model;

import android.util.Log;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.XiangBean;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class XiangModel extends BaseModel {

    private static final String TAG = "XiangModel";
    public void initXiangQing(int id, String token, final ICallBack<XiangBean.ResultEntity> iCallBack){

        Retrofit build = new Retrofit.Builder()
                .baseUrl(ServiceList.singUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ServiceList serviceList = build.create(ServiceList.class);
        Observable<XiangBean> xiang = serviceList.getXiang(id, token);
        xiang.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<XiangBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(XiangBean xiangBean) {
                        XiangBean.ResultEntity result = xiangBean.getResult();
                        iCallBack.onSuccess(result);
                        Log.d(TAG, "onNext: "+xiangBean+".............");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage()+".............");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
