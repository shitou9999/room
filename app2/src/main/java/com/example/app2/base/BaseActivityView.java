package com.example.app2.base;

import android.content.Intent;
import android.support.v4.app.FragmentManager;

public interface BaseActivityView extends UIView {
    Intent getIntent();


   FragmentManager getSupportFragmentManager();
}