package view;

import com.example.lenovo.daochulvxing.base.BaseView;
import com.example.lenovo.daochulvxing.bean.ZhuanTiBean;

import java.util.ArrayList;

public interface SubJectView extends BaseView {
    void Success(ArrayList<ZhuanTiBean.ResultEntity.BundlesEntity> list);
    void fina(String msg);
}
