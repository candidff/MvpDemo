package com.example.azheng.rxjavamvpdemo.contract;

import com.example.azheng.rxjavamvpdemo.base.BaseView;
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.LoginBean;

import io.reactivex.rxjava3.core.Observable;


/**
 * 描述：添加类的描述
 *
 * @author lifan
 * @e-mail lifan@hztianque.com
 * @time 2020/6/8
 */
public interface MainContract {
    interface Model {
        Observable<BaseObjectBean<LoginBean>> login(String username, String password);
    }

    interface View extends BaseView {
    }

    interface Presenter {
        /**
         * 登陆
         *
         * @param username
         * @param password
         */
        void login(String username, String password);
    }
}
