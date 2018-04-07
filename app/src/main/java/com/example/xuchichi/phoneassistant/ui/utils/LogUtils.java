package com.example.xuchichi.phoneassistant.ui.utils;

import android.text.TextUtils;
import android.util.Log;

import com.example.xuchichi.phoneassistant.BuildConfig;

/**
 * Created by xuchichi on 2018/4/6.
 */

public class LogUtils {
    private static final String TAG = "debug";

    //规定每段显示的长度
    private static final int LOG_MAX_LENGTH = 1000;

    public static void v(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (TextUtils.isEmpty(msg)) {
                Log.v(tag, "内容是空的");
            } else {
                while (true) {
                    if (msg.length() > LOG_MAX_LENGTH) {
                        Log.v(tag, msg.substring(0, LOG_MAX_LENGTH));
                        msg = msg.substring(LOG_MAX_LENGTH);
                    } else {
                        Log.v(tag, msg);
                        break;
                    }
                }

            }

        }
    }

    public static void d(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (TextUtils.isEmpty(msg)) {
                Log.d(tag, "内容是空的");
            } else {
                while (true) {
                    if (msg.length() > LOG_MAX_LENGTH) {
                        Log.d(tag, msg.substring(0, LOG_MAX_LENGTH));
                        msg = msg.substring(LOG_MAX_LENGTH);
                    } else {
                        Log.d(tag, msg);
                        break;
                    }
                }
            }

        }
    }

    public static void i(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (TextUtils.isEmpty(msg)) {
                Log.i(tag, "内容是空的");
            } else {
                while (true) {
                    if (msg.length() > LOG_MAX_LENGTH) {
                        Log.i(tag, msg.substring(0, LOG_MAX_LENGTH));
                        msg = msg.substring(LOG_MAX_LENGTH);
                    } else {
                        Log.i(tag, msg);
                        break;
                    }
                }
            }

        }
    }


    public static void w(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (TextUtils.isEmpty(msg)) {
                Log.w(tag, "内容是空的");
            } else {
                while (true) {
                    if (msg.length() > LOG_MAX_LENGTH) {
                        Log.w(tag, msg.substring(0, LOG_MAX_LENGTH));
                        msg = msg.substring(LOG_MAX_LENGTH);
                    } else {
                        Log.w(tag, msg);
                        break;
                    }
                }
            }

        }
    }

    public static void e(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (TextUtils.isEmpty(msg)) {
                Log.e(tag, "内容是空的");
            } else {
                while (true) {
                    if (msg.length() > LOG_MAX_LENGTH) {
                        Log.e(tag, msg.substring(0, LOG_MAX_LENGTH));
                        msg = msg.substring(LOG_MAX_LENGTH);
                    } else {
                        Log.e(tag, msg);
                        break;
                    }
                }
            }

        }
    }

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void w(String msg) {
        w(TAG, msg);
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void zhangx(String msg) {
        i("zhangXin", msg);
    }
}
