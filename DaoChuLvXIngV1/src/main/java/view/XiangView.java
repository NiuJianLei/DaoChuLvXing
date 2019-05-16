package view;

import com.example.lenovo.daochulvxing.base.BaseView;
import com.example.lenovo.daochulvxing.bean.XiangBean;

import java.util.ArrayList;

public interface XiangView extends BaseView {
void Success(XiangBean.ResultEntity list);
void fain(String msg);
}
