package com.example.room.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;

import com.example.room.entity.User;
import com.example.room.entity.Users;

import java.util.List;

/**
 * Activity销毁时，该框架将调用ViewModel的onCleared()方法，用来清理资源。
 * 注意：由于ViewMode已经超脱于当前Activity/Fragment的生命周期，
 * 那么它不能应用View或者任何持有Activity的Contex。
 * 如果ViewHold需要应用程序的Context，那么可以继承自AndroidViewModel类，
 * 并创建一个将Application（Application继承自Context）实例作为参数的构造函数
 * ViewModel用来存储和管理生命周期过程敏感的界面数据的一个类!!!
 *
 * 注意ViewModel对象绝不能持有View，LifeCycle或者任何持有Activity 引用的对象
 *
 * ViewModel可以持有LifeCycleObservers比如说LiveData，如果ViewModel需要使用Application的引用，
 * 例如说去获取一个系统服务，此时可以继承自AndroidViewModel，该类有一个构造函数，可以接受Application的引用。
 *
 * ViewModel的提出只是为了处理UI相关数据的缓存问题，并不代表它能完全替代onSavedInstanceState()的作用
 *
 * ViewModel对象会常驻在内存中直到与其对应的LifeCycle被销毁！！！！！
 * （对于Activity而言，就是当其被finish时，对于Fragment而言就是当它被detach的时候）
 */

public class MyViewModel extends ViewModel {

//    ViewModel的生命周期
//    ViewModel的生命周期，将于获取ViewModelProvider时传递的Lifecycle的生命周期相关联。
//    ViewHolder存储在内存中。
//    如果Lifecycle是Activity，那么就是在Activity被销毁时，ViewModel调用onCleared()，释放资源；
//    Lifecycle是Fragment，那么就是在Fragment被分离时，ViewModel调用onCleared()，释放资源；

        //数据的访问
//    MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);
//        model.getUsers().observe(this, users -> {
//        // update UI
//    });

    private MutableLiveData<List<User>> users;

    public LiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<List<User>>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        // do async operation to fetch users
    }



}
