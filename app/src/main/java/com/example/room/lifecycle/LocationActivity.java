package com.example.room.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v7.app.AppCompatActivity;

/**
 * LifeCyle类持有Activity或者Fragment的生命周期相关信息，并且支持其他对象监听这些状态。
 * LifeCyle有两个枚举用于追踪生命周期中的状态
 * Event --->这是生命周期的事件类，会在Framework和LifeCycle间传递，这些事件映射到Activity和Fragment的回调事件中。
 * State----->LifeCycle所持有Activity或Fragment的当前状态。
 * 允许多个组件共用一个LifecycleOwner。
 * 任何一个自定义的Android组件类都可以实现LifecycleOwner接口。
 */
public class LocationActivity extends AppCompatActivity {
    private MyLocationListener myLocationListener;

    public void onCreate() {
//        myLocationListener = new MyLocationListener(this, (location) -> {
//            // update UI
//        });
  }

    @Override
    protected void onStart() {
        super.onStart();
        myLocationListener.start();
//        Util.checkUserStatus(result -> {
//            // what if this callback is invoked AFTER activity is stopped?
//            if (result) {
//                myLocationListener.start();
//            }
//        });
          getLifecycle().addObserver(new LocationListener());
    }

    @Override
    protected void onStop() {
        super.onStop();
        myLocationListener.stop();
    }

//    LifeCycleOwner是一个只有一个方法的接口用于表明其有一个LifeCycle对象。这个方法为getLifecycle()。
//    这个对象给Acitivity，Fragment和LifeCycle提供了一个很好的抽象关系，Activity和Fragment只要实现这个
//    接口就能配合LifeCycle实现生命周期监听。



}
