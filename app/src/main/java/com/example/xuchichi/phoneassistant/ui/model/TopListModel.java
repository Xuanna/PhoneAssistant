package com.example.xuchichi.phoneassistant.ui.model;

import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.net.OkhttpApiService;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by xuchichi on 2018/4/15.
 */

public class TopListModel {


    OkhttpApiService service;

    public TopListModel(OkhttpApiService service) {
        this.service = service;
    }


    public Call<MyAppInfo> getTopList(int page) {

        return service.topList(page);
    }
}
