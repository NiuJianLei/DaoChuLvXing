package model;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.util.BaseObserver;
import com.example.lenovo.daochulvxing.util.HttpUtils;
import com.example.lenovo.daochulvxing.util.RxUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APresenterFragmentModel extends BaseModel {
    public void initSetting(String token, String info, int type, final ICallBack<String> iCallBack){
        HashMap<String, String> map = new HashMap<>();
        if (type == ServiceList.NAME){
            map.put("username",info);
        }else if(type==ServiceList.SEX){
            map.put("gender",info);
        }else if (type==ServiceList.SING){
            map.put("description",info);
        }
        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
        Observable<ResponseBody> setting1 = apiserver.getSetting(token, map);
       setting1.compose(RxUtils.<ResponseBody>rxObserableSchedulerHelper())
               .subscribe(new BaseObserver<ResponseBody>() {
                   @Override
                   public void onSubscribe(Disposable d) {
                       addDisposable(d);
                   }
                   @Override
                   public void onNext(ResponseBody responseBody) {
                       try {
                           String string = responseBody.string();
                           JSONObject jsonObject = new JSONObject(string);
                           int code = jsonObject.getInt("code");
                           if (code==0){
                               iCallBack.onSuccess(string);
                           }else{
                               iCallBack.onFail(string);
                           }
                       } catch (IOException e) {
                           e.printStackTrace();
                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
                   }
               });
    }
}
