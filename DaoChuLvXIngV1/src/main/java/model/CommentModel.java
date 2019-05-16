package model;

import com.example.lenovo.daochulvxing.ServiceList;
import com.example.lenovo.daochulvxing.base.BaseModel;
import com.example.lenovo.daochulvxing.bean.CommentBean;
import com.example.lenovo.daochulvxing.util.BaseObserver;
import com.example.lenovo.daochulvxing.util.HttpUtils;
import com.example.lenovo.daochulvxing.util.RxUtils;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class CommentModel extends BaseModel {
    public void initComment(int id, int page, String token, final ICallBack<CommentBean.ResultEntity> iCallBack){
        ServiceList apiserver = HttpUtils.getInstance().getApiserver(ServiceList.singUrl, ServiceList.class);
        final Observable<CommentBean> comment = apiserver.getComment(id, page, token);
        comment.compose(RxUtils.<CommentBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<CommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(CommentBean commentBean) {
                        CommentBean.ResultEntity result = commentBean.getResult();
                        iCallBack.onSuccess(result);
                    }
                });

    }
}
