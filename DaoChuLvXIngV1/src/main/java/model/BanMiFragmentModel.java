package model;

import android.util.Log;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.BanMiBean;

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
    public void getBanMi(int page, String token, final ICallBack<ArrayList<BanMiBean.ResultEntity.BanmiEntity>> iCallBack){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ServiceList.singUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceList serviceList = build.create(ServiceList.class);
        final Observable<BanMiBean> banMi = serviceList.getBanMi(page, token);
        banMi.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<BanMiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(BanMiBean banMiBean) {
                        List<BanMiBean.ResultEntity.BanmiEntity> banmi = banMiBean.getResult().getBanmi();
                        iCallBack.onSuccess((ArrayList<BanMiBean.ResultEntity.BanmiEntity>) banmi);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private static final String TAG = "BanMiFragmentModel";
    public void initLike(int id, String token, final ICallBack<String> iCallBack){
                        Retrofit build = new Retrofit.Builder()
                                .baseUrl(ServiceList.singUrl)
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        ServiceList serviceList = build.create(ServiceList.class);
                        Observable<ResponseBody> like = serviceList.getLike(id, token);
                        like.observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.newThread())
                                .subscribe(new Observer<ResponseBody>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(ResponseBody responseBody) {
                                        String s = responseBody.toString();
                                        try {
                                            JSONObject jsonObject = new JSONObject(s);
                                            int code = jsonObject.getInt("code");
                                            Log.e(TAG, "onNext: e="+jsonObject.toString());
                                            if (code==0){
                                                Log.e(TAG, "onNext: e="+"Success ");
                                                iCallBack.onSuccess(s);
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        iCallBack.onFail(e.getMessage());
                                        Log.e(TAG, "onNext: e="+e.getMessage());
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });
                    }

                    public void initRemove(int id, String token, final ICallBack<String> iCallBack){
                        Retrofit build = new Retrofit.Builder()
                                .baseUrl(ServiceList.singUrl)
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .build();
                        ServiceList serviceList = build.create(ServiceList.class);
                        Observable<ResponseBody> remove = serviceList.getRemove(id, token);
                        remove.observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.newThread())
                                .subscribe(new Observer<ResponseBody>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

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

                    @Override
                    public void onError(Throwable e) {
                            iCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
