package com.example.xuchichi.phoneassistant.ui.utils;

import android.content.Context;

/**
 * Created by xuchichi on 2018/4/10.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final CrashHandler sInstance = new CrashHandler();
    private Thread.UncaughtExceptionHandler mDefaultUCrashHandler;
    private Context mContext;


    public CrashHandler() {
    }

    public CrashHandler getsInstance() {

        return sInstance;
    }

    public void init(Context context) {
        mDefaultUCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext =context.getApplicationContext();

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

    }
}
