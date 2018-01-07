package com.example.app3.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建Presenter
//        mPresenter = initPresenter();
        //类似fragment的绑定.拿到引用
//        mPresenter.onAttch(this);
        //初始化acitivity,
//        onCreateActivity(savedInstanceState);
        //初始化Presenter
//        mPresenter.onCreate();

        getTitleResId();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        mPresenter.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
//        mPresenter.onDestroy();
//        mPresenter.onDetach();
        super.onDestroy();
    }

     protected abstract int getContentViewId();

     protected abstract int getTitleResId();

    protected abstract T getPresenterInstance();



//    protected abstract int getContentViewId();
//
//    protected abstract int getTitleResId();
//
//    protected abstract T getPresenterInstance();
//    /**
//     * 创建prensenter
//     * @return <T extends BasePresenter> 必须是BasePresenter的子类
//     */
//    protected abstract T initPresenter();

    /**
     * 子类必须实现,并初始化Activity,比如setContentView()
     */
//    protected abstract void onCreateActivity(Bundle savedInstanceState);


}