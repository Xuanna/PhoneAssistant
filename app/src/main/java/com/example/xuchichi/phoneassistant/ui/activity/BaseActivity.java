package com.example.xuchichi.phoneassistant.ui.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.xuchichi.phoneassistant.R;
import com.example.xuchichi.phoneassistant.ui.MyApplication;
import com.example.xuchichi.phoneassistant.ui.utils.CommonUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by xuchichi on 2018/4/1.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public Context context;
    public BaseActivity baseActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("UiClassName:", getClass().getSimpleName());
        setFitsSystemWindows(true);
        setContentView(layoutId());
        context = getApplicationContext();
        ButterKnife.bind(this);
        initView();

    }


    public abstract int layoutId();

    public abstract void initView();

    /**
     * 收起软键盘
     */
    public void hideKeyboard() {
    }

    /**
     * 获取android设备id
     *
     * @describe 获取android设备id @method getDeviceId @return @return
     * String @throws
     */
    public static String getDeviceId() {
        try {
            TelephonyManager tm = (TelephonyManager) MyApplication.myApplication.getSystemService(Context.TELEPHONY_SERVICE);
            return tm.getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 透明状态栏
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void adaptTheme(final boolean isTranslucentStatusFitSystemWindowTrue) {
        if (isTranslucentStatusFitSystemWindowTrue) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //状态栏设置为全透明//目标版本在26的时候，22以上版本的手机需要如下代码才能全透明
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                        | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
                window.setNavigationBarColor(CommonUtil.getColor(R.color.grey_c8c9cc));
            }
        }
    }

    /**
     * 设置布局内容和状态栏不重合
     *
     * @param fitsSystemWindows
     */
    public void setFitsSystemWindows(boolean fitsSystemWindows) {
        ViewGroup contentFrameLayout = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        View parentView = contentFrameLayout.getChildAt(0);

        if (parentView != null && Build.VERSION.SDK_INT >= 14) {
            parentView.setFitsSystemWindows(fitsSystemWindows);
        }
    }
    public void startActivity(Class<? extends Activity> activity){
        Intent intent=new Intent();
        intent.setClass(MyApplication.getInstance(),activity);
        this.startActivity(intent);
    }

    public void startActivityForResult(Class<? extends Activity> activity,int request){
        Intent intent=new Intent();
        intent.setClass(MyApplication.getInstance(),activity);
        this.startActivityForResult(intent,request);
    }


}
