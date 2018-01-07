package com.example.app2.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public interface BaseFragmentView extends UIView {

    Bundle getBundle();

    FragmentManager getFragmentManager();

    Fragment getFragment();
}