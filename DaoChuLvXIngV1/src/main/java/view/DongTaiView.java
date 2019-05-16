package view;

import com.example.lenovo.daochulvxing.base.BaseView;
import com.example.lenovo.daochulvxing.bean.MyPerson;

public interface DongTaiView extends BaseView {
    void initSuccess(MyPerson.ResultEntity myperson);
    void initFina(String msg);
}
