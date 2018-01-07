package com.example.room.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * 具体的ViewModel
 */
public class DemoViewHolder extends ViewModel {

    private MutableLiveData<UserEntity> mUserEntityLiveData = new MutableLiveData<>();

    public LiveData<UserEntity> getUserInfo() {
        return mUserEntityLiveData;
    }

    public void requestUserInfo() {
        // add your owner business logic
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername("user001");
                userEntity.setAddress("user001Address100");
                mUserEntityLiveData.postValue(userEntity);
            }
        }).start();
    }

}