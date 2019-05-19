package view;

import com.example.lenovo.daochulvxing.base.BaseView;
import com.example.lenovo.daochulvxing.bean.DiquBean;

public interface DiquView extends BaseView {
    void initDiquSuccess(DiquBean.ResultEntity bean);
    void initDiquFain(String msg);
}
