package com.example.room.lifecycle;

import android.content.Context;

import javax.security.auth.callback.Callback;

public class MyLocationListener {

    public MyLocationListener(Context context, Callback callback) {
        // ...
    }

    void start() {
        // connect to system location service
    }

    void stop() {
        // disconnect from system location service
    }
}