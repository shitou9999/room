package com.example.app3.ui

import android.os.Bundle
import android.support.v4.view.ViewPager

import com.example.app3.R
import com.example.app3.iview.MainView
import com.example.app3.presenter.MainPresenter
import com.ogaclejapan.smarttablayout.SmartTabLayout

class MainActivity : BaseActivity<MainPresenter>(),MainView{

    override fun getTitleResId(): Int {
        return 0
    }

    override fun getPresenterInstance(): MainPresenter? {
        return MainPresenter(this)
    }

    override fun getContentViewId(): Int {
        return R.layout.activity_main
    }

    override fun showToast(toastIview: String) {

    }

    override fun onError(throwable: Throwable?) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val smartTabLayout: SmartTabLayout = findViewById(R.id.smart_tab_layout) //as SmartTabLayout
//        val viewPager: ViewPager = findViewById(R.id.view_pager)// as ViewPager
//
//        presenter?.initTabs(this, smartTabLayout, viewPager)

        val smartTabLayout:SmartTabLayout = findViewById(R.id.smart_tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)

        mPresenter?.initTabs(this, smartTabLayout, viewPager)

    }







}
