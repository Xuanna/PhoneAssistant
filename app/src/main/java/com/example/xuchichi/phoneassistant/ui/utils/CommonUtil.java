package com.example.xuchichi.phoneassistant.ui.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import com.example.xuchichi.phoneassistant.ui.MyApplication;

import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xuchichi on 2018/4/1.
 */

public class CommonUtil {


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = MyApplication.myApplication.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    public static  int getColor(int colorId){
        if (Build.VERSION.SDK_INT >= 23)
            return MyApplication.myApplication.getResources().getColor(colorId, null);
        else
            return MyApplication.myApplication.getResources().getColor(colorId);

    }
    /**
     * 数字格式化
     *
     */
    public static String numFormat(double numDouble,String formatString, RoundingMode mode){
        return "";
    }
    /**
     * List去除重复数据
     *
     * @param array
     * @return
     */
    public static List clearRepeat(List array) {
        List arr = new ArrayList();
        Iterator it = array.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (!arr.contains(obj))
                arr.add(obj);
        }
        return arr;
    }

    /**
     * 复制文本
     */
    public static void copyText(String content) {
        ClipboardManager clip = (ClipboardManager) MyApplication.myApplication.getSystemService(Context.CLIPBOARD_SERVICE);
        //创建普通字符型ClipData
        ClipData mClipDate = ClipData.newPlainText("Lable", content);
        //将ClipData内容放到系统剪贴板里
        clip.setPrimaryClip(mClipDate);

    }
    /**
     * 防止图片oom
     */
    public static Bitmap getBitmapForImgResources(Context mContext, int imgId) {
        Bitmap bitmap = null;
        InputStream is = null;
        try {
            is = mContext.getResources().openRawResource(imgId);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inSampleSize = 1;
            bitmap = BitmapFactory.decodeStream(is, null, options);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }
    /**
     * 是否联网
     */
    public static boolean isNetConnected(Context context){
        try{
            ConnectivityManager conn= (ConnectivityManager) MyApplication.myApplication.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info=conn.getActiveNetworkInfo();
            return (info!=null&&info.isConnected());

        }catch (Exception e){

                  e.printStackTrace();
            }
       return false;

    }
    /**
     * 获取应用的版本名称
     *
     * @return
     */
    public static String getLocalVersionName() {
        String localVersionName = "1.0.0";
        Context context = MyApplication.myApplication;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            localVersionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersionName;
    }

}
