package model;

import android.util.Log;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.XiangBean;
import com.example.lenovo.daochulvxing.util.BaseObserver;
import com.example.lenovo.daochulvxing.util.HttpUtils;
import com.example.lenovo.daochulvxing.util.RxUtils;

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

        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
        Observable<XiangBean> xiang1 = apiserver.getXiang(id, token);
        xiang1.compose(RxUtils.<XiangBean>rxObserableSchedulerHelper())
        .subscribe(new BaseObserver<XiangBean>() {

            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void onNext(XiangBean xiangBean) {
                XiangBean.ResultEntity result = xiangBean.getResult();
                iCallBack.onSuccess(result);
                Log.d(TAG, "onNext: "+xiangBean+".............");
            }
        });
    }
}
