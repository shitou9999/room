package com.example.room.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.util.Log;

class MyLifeCycleObserver implements LifecycleObserver {
    private Context context;
    private CallBack callBack;

    //执行完Observer内部事件的回调
    interface CallBack {
        void start();

        void stop();
    }

    MyLifeCycleObserver(Context context, CallBack callBack) {
        this.context = context;
        this.callBack = callBack;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start() {
        Log.e("LifeCycleObserverDemo", "Activity started,do init things");
        callBack.start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() {
        Log.e("LifeCycleObserverDemo", "Activity stoped,do stop things");
        callBack.stop();
    }


    /*
        绑定Observer到LifeCycleOwner
        使用如下方式绑定LifeCycleObserver到LifeCycleOwner
        myLifeCycleObserver = new MyLifeCycleObserver(this, new CallBack() {
                    @Override
                    public void start() {
                        Log.e("LifeCycleObserverDemo","Activity started,do init things end,update ui");
                    }
                    @Override
                    public void stop() {
                        Log.e("LifeCycleObserverDemo","Activity stoped,do stop things end,update ui");
                    }
                });
                getLifecycle().addObserver(myLifeCycleObserver);
        在LifeCycleOwner Destory时记得解绑：
        @Override
        protected void onDestroy() {
            super.onDestroy();
            getLifecycle().removeObserver(myLifeCycleObserver);
        }
     */


}