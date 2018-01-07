package com.example.app3

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

/**
 * Created by PVer on 2018/1/6.
 */
class App : Application() {

    val TAG: String = "App"

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
    }



}