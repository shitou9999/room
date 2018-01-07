package com.example.app3.iview

/**
 * Created by PVer on 2018/1/7.
 */
interface InTheaterView : RefreshView,OnRefreshListener {

    fun onError(throwable: Throwable?)


}