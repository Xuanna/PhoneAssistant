package com.example.xuchichi.phoneassistant.ui.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.xuchichi.phoneassistant.ui.MyApplication;

/**
 * Created by xuchichi on 2018/4/6.
 */

public class ImageLoader {
    public static ImageLoader mImageLoader;
    private Context context = MyApplication.getInstance();

    public static ImageLoader getInstance() {
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader();
        }
        return mImageLoader;
    }

    public void loadImage(String url, ImageView iv) {
        Glide.with(context).load(url).into(iv);
    }

}
