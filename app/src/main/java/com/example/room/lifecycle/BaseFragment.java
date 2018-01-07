package com.example.room.lifecycle;


import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.room.R;

/**
 * 在自定义的Activity或Fragment中实现LifeCycleOwner，
 * 可以实现LifecycleRegistryOwner这个接口。而不是继承（LifeCycleFragment和LifeCycleActivity）
 */
public class BaseFragment extends Fragment {
    /**
     * 如果你要在自定义的类中实现LifeCycleOwner，可以使用LifecycleRegistry,但是你需要主动向其转发生命周期的事件。
     * 但如果你自定义类是Fragment和Activity的话并且它们实现的是LifecycleRegistryOwner，那么事件转发都是自动完成的。
     */

    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

}
