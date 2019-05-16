package view;

import com.example.lenovo.daochulvxing.base.BaseView;
import com.example.lenovo.daochulvxing.bean.VersionInfo;

public interface ToolsView extends BaseView {
    void Success(VersionInfo versionInfo);
    void fain(String msg);
}
