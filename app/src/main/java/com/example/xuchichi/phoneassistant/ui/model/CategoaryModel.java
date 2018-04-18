package com.example.xuchichi.phoneassistant.ui.model;

import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.net.OkhttpApiService;

import retrofit2.Callback;

/**
 * Created by xuchichi on 2018/4/6.
 */

public class CategoaryModel {

    private OkhttpApiService myApiService;

    public CategoaryModel(OkhttpApiService myApiService) {
        this.myApiService = myApiService;
    }

    public void getCategoryList(Callback<MyAppInfo> callback) {

        myApiService.getApps("{'page':0}").enqueue(callback);
    }
}
