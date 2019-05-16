package view;

import com.example.lenovo.daochulvxing.base.BaseView;
import com.example.lenovo.daochulvxing.bean.LoginInfo;

import java.util.ArrayList;

public interface MainView extends BaseView {
    void initSuccess(LoginInfo.ResultBean logininfo);
    void initEroor(String msg);
}
