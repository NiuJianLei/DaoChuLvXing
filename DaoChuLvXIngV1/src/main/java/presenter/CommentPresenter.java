package presenter;

import com.example.lenovo.daochulvxing.base.BasePresenter;
import com.example.lenovo.daochulvxing.bean.CommentBean;

import java.util.ArrayList;

import model.CommentModel;
import model.ICallBack;
import view.CommentView;

public class CommentPresenter extends BasePresenter<CommentView> {
    CommentModel model;
    @Override
    public void initModel() {
        this.model=new CommentModel();
        mModels.add(model);
    }
    public void initComment(int id,int page,String token) {
        model.initComment(id, page, token, new ICallBack<CommentBean.ResultEntity>() {
            @Override
            public void onSuccess(CommentBean.ResultEntity bean) {
                mMvpView.Success(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.fail(msg);
            }
        });

    }

}
