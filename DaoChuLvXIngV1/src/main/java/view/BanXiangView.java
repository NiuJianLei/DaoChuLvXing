package view;

import com.example.lenovo.daochulvxing.base.BaseView;
import com.example.lenovo.daochulvxing.bean.BanXiangBean;

public interface BanXiangView extends BaseView {
    void Success(BanXiangBean.ResultEntity bean);
    void fain(String msg);
}
