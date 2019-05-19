package model;

import android.util.Log;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.BanMiBean;
import com.example.lenovo.daochulvxing.util.BaseObserver;
import com.example.lenovo.daochulvxing.util.HttpUtils;
import com.example.lenovo.daochulvxing.util.RxUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BanMiFragmentModel extends BaseModel {
    public void getBanMi(int page, String token, final ICallBack<ArrayList<BanMiBean.ResultEntity.BanmiEntity>> iCallBack) {

        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
        Observable<BanMiBean> banMi1 = apiserver.getBanMi(page, token);
        banMi1.compose(RxUtils.<BanMiBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<BanMiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(BanMiBean banMiBean) {
                        List<BanMiBean.ResultEntity.BanmiEntity> banmi = banMiBean.getResult().getBanmi();
                        iCallBack.onSuccess((ArrayList<BanMiBean.ResultEntity.BanmiEntity>) banmi);
                    }
                });
    }

    private static final String TAG = "BanMiFragmentModel";

    public void initLike(int id, String token, final ICallBack<String> iCallBack) {

        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);

        Observable<ResponseBody> like1 = apiserver.getLike(id, token);
        like1.compose(RxUtils.<ResponseBody>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        String s = responseBody.toString();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            int code = jsonObject.getInt("code");
                            Log.e(TAG, "onNext: e=" + jsonObject.toString());
                            if (code == 0) {
                                Log.e(TAG, "onNext: e=" + "Success ");
                                iCallBack.onSuccess(s);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    public void initRemove(int id, String token, final ICallBack<String> iCallBack) {
        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
        Observable<ResponseBody> remove1 = apiserver.getRemove(id, token);
        remove1.subscribe(new BaseObserver<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                String str = responseBody.toString();

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    int code = jsonObject.getInt("code");
                    iCallBack.onSuccess(str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
