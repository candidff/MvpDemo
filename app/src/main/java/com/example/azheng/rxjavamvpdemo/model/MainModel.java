package com.example.azheng.rxjavamvpdemo.model;


import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.LoginBean;
import com.example.azheng.rxjavamvpdemo.contract.MainContract;
import com.example.azheng.rxjavamvpdemo.net.RetrofitClient;

import io.reactivex.rxjava3.core.Observable;


/**
 * 描述：添加类的描述
 * @author lifan 
 * @e-mail lifan@hztianque.com
 * @time 2020/6/8
 */
public class MainModel  implements MainContract.Model {
    @Override
    public Observable<BaseObjectBean<LoginBean>> login(String username, String password) {
        return RetrofitClient.getInstance().getApi().login(username,password);
    }
}
