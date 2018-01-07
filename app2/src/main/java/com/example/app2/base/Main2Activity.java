package com.example.app2.base;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.app2.R;

public class Main2Activity extends BaseActivity<MainActivityPresenterImpl> implements MainActivityContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected MainActivityPresenterImpl initPresenter() {
        return null;
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {

    }


    @Override
    public <V extends View> V findView(int viewId) {
        return null;
    }

    @Override
    public void onBack() {

    }

    @Override
    public void startFragment(Fragment tofragment) {

    }

    @Override
    public void startFragment(Fragment tofragment, String tag) {

    }


}
