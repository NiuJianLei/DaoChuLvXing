package view;

import com.example.lenovo.daochulvxing.base.BaseView;
import com.example.lenovo.daochulvxing.bean.MyPerson;

import java.util.ArrayList;

public interface HomeFragmentView extends BaseView {
    void initSuccess(MyPerson.ResultEntity myperson);
    void initFina(String msg);
}
