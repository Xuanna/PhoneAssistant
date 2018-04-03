package com.example.xuchichi.phoneassistant.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuchichi on 2018/4/1.
 */

public class MyApplication extends Application {
    public List<Activity> activityList=new LinkedList<>();
    public static MyApplication myApplication;
    @Override
    public void onCreate() {
        super.onCreate();

        myApplication=this;

        OkGo.getInstance().init(this);
    }
    public static MyApplication getInstance(){
        if (myApplication==null){
            myApplication=new MyApplication();
        }
        return myApplication;
    }

    /**
     * 添加Activity
     * @param activity
     */
    public void addActivity(Activity activity){
      if (activityList==null){
          activityList=new LinkedList<>();
      }
        activityList.add(activity);
    }

    /**
     * 移除Activity
     * @param activity
     */
    public void removeActivity(Activity activity){
       if (activity!=null){
           activityList.remove(activity);
       }

    }

    /**
     * 关闭所有Activity
     */
    public void finishAll(){
        for (Activity activity:activityList) {
           if (activity!=null){
               activity.finish();
           }
        }
    }
    /**
     * 获得指定Activity
     */
    public Activity getActivity(Class classz){
        if (activityList!=null&&activityList.size()>0){
            for (int i=0;i<activityList.size();i++){
                if (activityList.get(i).getClass()==classz)
                    return activityList.get(i);
            }
        }
        return null;
    }
    /**
     * 由于65k限制，采用分包
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
