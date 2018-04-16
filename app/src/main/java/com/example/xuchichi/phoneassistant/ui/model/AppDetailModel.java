package com.example.xuchichi.phoneassistant.ui.model;

import com.example.xuchichi.phoneassistant.ui.MyApplication;
import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.net.OkhttpApiService;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by xuchichi on 2018/4/14.
 */

public class AppDetailModel {

    OkhttpApiService service;

    public AppDetailModel(OkhttpApiService service) {
        this.service = service;
    }

    public Call<MyAppInfo> getAppDetail(int page) {

        return service.topList(page);

    }
}
