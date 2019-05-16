package view;

import com.example.lenovo.daochulvxing.base.BaseView;
import com.example.lenovo.daochulvxing.bean.BanMiBean;

import java.util.ArrayList;

public interface BanMiFragmentView extends BaseView {
    void Success(ArrayList<BanMiBean.ResultEntity.BanmiEntity> list);
    void fain(String mas);
    void followSuccess(String mas);
    void followFain(String msg);

}
