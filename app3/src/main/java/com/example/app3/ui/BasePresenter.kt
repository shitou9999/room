package com.example.app3.ui

import android.os.Bundle

/**
 * presenter 经常用到两个东西 ： Model、View
 * 定义泛型，子类继承 BasePresenter 的时候指定 泛型 的类型即可
 */
abstract class BasePresenter {
//    <T : BaseView>
//    protected M mModel;
//    protected V mView;
//
//    //M、v 通过子类构造方法传过来
//    public BasePresenter(M m,V v){
//        this.mModel=m;
//        this.mView = v;
//    }
//    protected var mView: MainView? = null
//
//    fun onAttch(view: MainView) {
//        this.mView = view
//    }
//
//    fun onDetach() {
//        mView = null
//    }

    abstract fun onAttch(view: BaseView)

    abstract fun onDestroy(view: BaseView)

}
