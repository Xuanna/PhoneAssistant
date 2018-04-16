package com.example.xuchichi.phoneassistant.ui.model;

import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.net.OkhttpApiService;

import retrofit2.Call;

/**
 * Created by xuchichi on 2018/4/15.
 */

public class AppInfoModel {

    OkhttpApiService apiService;

    public AppInfoModel(OkhttpApiService apiService) {
        this.apiService = apiService;
    }

    public Call<MyAppInfo> getTopList(int page) {

        return apiService.topList(page);
    }

}
