package model;

import android.util.Log;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.BanXiangBean;
import com.example.lenovo.daochulvxing.util.BaseObserver;
import com.example.lenovo.daochulvxing.util.HttpUtils;
import com.example.lenovo.daochulvxing.util.RxUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;

public class BanXiangModel extends BaseModel {

    private static final String TAG = "BanXiangModel";
        public void initBanXiang(int id, int page, String token, final ICallBack<BanXiangBean.ResultEntity> iCallBack ){
            ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
            final Observable<BanXiangBean> banXiang = apiserver.getBanXiang(id, page, token);
            banXiang.compose(RxUtils.<BanXiangBean>rxObserableSchedulerHelper())
                    .subscribe(new BaseObserver<BanXiangBean>() {
                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: "+e.getMessage()+"....");
                        }

                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(BanXiangBean banXiangBean) {
                            Log.d(TAG, "onNext: "+banXiangBean.toString()+"???");
                            BanXiangBean.ResultEntity result = banXiangBean.getResult();
                            iCallBack.onSuccess(result);
                        }
                    });
        }



}
