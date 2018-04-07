package com.example.xuchichi.phoneassistant.ui.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xuchichi on 2018/4/7.
 */

public class HttpManager {

    public OkHttpClient getOkhttpClient() {

        //log用拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        //开发模式记录整个bodu，否则只记录基本信息如返回200，协议版本等如app版本，token信息
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                //HeadInterceptor 实现Interceptor，用来往Request head中添加相关信息
//              .addInterceptor(new HeadInterceptor())
                .addInterceptor(logging)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public Retrofit getRetrofit(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient);//配置okHttpClient，不设置则使用默认的配置
        return builder.build();
    }
}
