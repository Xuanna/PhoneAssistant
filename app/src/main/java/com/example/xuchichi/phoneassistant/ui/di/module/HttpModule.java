package com.example.xuchichi.phoneassistant.ui.di.module;

import android.app.Application;

import com.example.xuchichi.phoneassistant.ui.MyApplication;
import com.example.xuchichi.phoneassistant.ui.fragment.CategoryFragment;
import com.example.xuchichi.phoneassistant.ui.net.ApiService;
import com.example.xuchichi.phoneassistant.ui.net.CommonParamsInterceptor;
import com.example.xuchichi.phoneassistant.ui.net.OkhttpApiService;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xuchichi on 2018/4/8.
 */
@Module
public class HttpModule {


    @Provides
    @Singleton
    public OkHttpClient getOkhttpClient(Application application, Gson gson) {

//        //log用拦截器
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//
//        //开发模式记录整个bodu，否则只记录基本信息如返回200，协议版本等如app版本，token信息
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                //HeadInterceptor 实现Interceptor，用来往Request head中添加相关信息
//              .addInterceptor(new HeadInterceptor())
                .addInterceptor(new CommonParamsInterceptor(application, gson))
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient);//配置okHttpClient，不设置则使用默认的配置
        return builder.build();
    }

    @Provides
    @Singleton
    public OkhttpApiService getMyApiService(Retrofit retrofit) {

        return retrofit.create(OkhttpApiService.class);
    }
}
