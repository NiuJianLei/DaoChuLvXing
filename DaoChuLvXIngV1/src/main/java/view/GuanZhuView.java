package view;

import com.example.lenovo.daochulvxing.base.BaseView;
import com.example.lenovo.daochulvxing.bean.GuanZhu;

import java.util.ArrayList;

public interface GuanZhuView extends BaseView {
    void Success(ArrayList<GuanZhu.ResultEntity.BanmiEntity> list);
    void Erroor(String msg);
}
