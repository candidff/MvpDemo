package com.example.azheng.rxjavamvpdemo.base;

import android.os.Bundle;

import com.example.azheng.rxjavamvpdemo.contract.MainContract;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import autodispose2.AutoDispose;
import autodispose2.AutoDisposeConverter;
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider;

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements MainContract.View {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }

        super.onDestroy();
    }


    @Override
    public void onError(String errMessage) {

    }

    /**
     * 绑定生命周期 防止MVP内存泄漏
     *
     * @param <T>
     * @return
     */
    @Override
    public <T> AutoDisposeConverter<T> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY));
    }


}
