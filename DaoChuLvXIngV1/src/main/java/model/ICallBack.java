package model;

import com.example.lenovo.daochulvxing.bean.MyPerson;

import java.util.ArrayList;

public interface ICallBack<T>{
    void onSuccess(T bean);
    void onFail(String msg);
}
