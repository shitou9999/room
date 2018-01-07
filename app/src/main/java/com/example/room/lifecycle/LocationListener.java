package com.example.room.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.util.Log;

import javax.security.auth.callback.Callback;


/**
 * LocationListener是完全的生命周期感知了，它可以进行自己的初始化和资源清理而不必受Activity或者Fragment的管理
 *
 * 一个类想要监听LifeCycle的状态，只需要给其方法加上注解.监听组件的生命周期
 *
 * 任何自定义的应用程序类都可以实现 LifecycleOwner 接口。
 *
 * 让各个组件存储自己的逻辑使得 activity 和 fragment 的逻辑更容易管理
 *
 * Lifecycle 类允许其他对象查询当前状态
 *
 */

public class LocationListener implements LifecycleObserver {

    private boolean enabled = false;
//    一个常见的用例是，如果现在 Lifecycle 不在一个好的状态，那么避免调用某些 callback。
//    例如，如果 callback 在 activity 状态被保存之后执行一个 fragment 事务，会触发崩溃，所以我们绝对不会调用该 callback。
//    public LocationListener(Context context, Lifecycle lifecycle, Callback callback) {
//
//    }


//    @OnLifecycleEvent(Lifecycle.Event.ON_START)
//    void start() {
//        if (enabled) {
//            // connect
//            Log.d("LifeCycleListener", "start");
//        }
//    }

    public void enable() {
        enabled = true;
        //⓵ 他可以提供主动查询生命周期状态的方法。Lifecycle 类允许其他对象查询当前状态!!!!!!!!
//        if (lifecycle.getState().isAtLeast(STARTED)) {
//            // connect if not connected
//        }
    }
    //调用onCreate方法之后 调用OnSotp方法之前
//    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)

    //onStart方法调用之后  onPause方法调用之前
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
        Log.d("LifeCycleListener", "start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
        Log.d("LifeCycleListener", "stop");
    }

    /**
     * 在每次LifecycleObserver状态变化时，Lifecycle都会分发Event.ON_ANY事件；
     * 并且Event.ON_ANY事件的分发晚于其所对应的状态事件分发；
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner owner, Lifecycle.Event event) {
        //ON_ANY：关联所有的生命周期的事件
        Log.d("LifeCycleListener", "onAny:" + event.name());
    }



}
