package com.example.app3.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app3.iview.MainView

/**
 * Created by PVer on 2018/1/7.
 */
abstract class BaseFragment<T : BasePresenter>:Fragment() {
    protected var mPresenter: T? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(getContentViewId(), container, false)
    }

    protected abstract fun getContentViewId(): Int

    protected abstract fun initView(mainView: MainView)

    protected abstract fun getTitleResId(): Int

    protected abstract fun getPresenterInstance(): T

    protected abstract fun onFragmentFirstVisible()

}