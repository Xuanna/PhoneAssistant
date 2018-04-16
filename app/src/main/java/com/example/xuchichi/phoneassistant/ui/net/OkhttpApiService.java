package com.example.xuchichi.phoneassistant.ui.net;


import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ivan on 2016/12/30.
 */

public interface OkhttpApiService {

    public static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";


    @GET("featured")
    public Call<MyAppInfo> getApps(@Query("p") String params);

    @GET("toplist")
    public Call<MyAppInfo> topList(@Query("page") int page);
}
