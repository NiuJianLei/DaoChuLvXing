package view;

import com.example.lenovo.daochulvxing.base.BaseView;
import com.example.lenovo.daochulvxing.bean.CommentBean;

import java.util.ArrayList;

public interface CommentView extends BaseView {
    void Success(CommentBean.ResultEntity comment);
    void fail(String msg);
}
