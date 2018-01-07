package com.example.app3.presenter

import android.support.v4.view.ViewPager
import com.example.app3.iview.MainView
import com.example.app3.ui.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

/**
 * Created by PVer on 2018/1/7.
 */
class MainPresenter(val mView: MainView) : BasePresenter(){

    override fun onAttch(view: BaseView) {

    }

    fun initTabs(context: MainActivity, smartTabLayout: SmartTabLayout, viewPager: ViewPager) {
        val adapter = FragmentPagerItemAdapter(
                context.supportFragmentManager, FragmentPagerItems.with(context)
                .add("正在上映", InTheaterFragment::class.java)
                .add("即将上映", FutureFragment::class.java)
//                .add("Top250", TopFragment::class.java)
                .create())
        viewPager.offscreenPageLimit = 3
        viewPager.adapter = adapter

        smartTabLayout.setViewPager(viewPager)
    }

    override fun onDestroy(view: BaseView) {

    }


//    override fun onDestroy() {
//
//    }
    //class MainPresenter<T extends MainView> extends BasePresenter() {
//
////    private T mView;
////
////    public MainPresenter(T mView) {
////        this.mView = mView;
////    }
//}

}