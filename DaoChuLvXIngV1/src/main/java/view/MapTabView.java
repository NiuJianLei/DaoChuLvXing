package view;

import com.example.lenovo.daochulvxing.base.BaseView;
import com.example.lenovo.daochulvxing.bean.Map_TabBean;

import java.util.ArrayList;

public interface MapTabView extends BaseView {
    void initMapTabSuccess(Map_TabBean.ResultEntity tabbean);
    void initMapTabFain(String msg);
}
