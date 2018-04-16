package com.example.xuchichi.phoneassistant.ui.model;

import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.fragment.CategoryFragment;
import com.example.xuchichi.phoneassistant.ui.net.HttpManager;

import retrofit2.Callback;

/**
 * Created by xuchichi on 2018/4/6.
 */

public class CategoaryModel {

//    private CategoryFragment.MyApiService myApiService;
//
//    public CategoaryModel(CategoryFragment.MyApiService myApiService) {
//        this.myApiService = myApiService;
//    }

    public void getCategoryList(Callback<MyAppInfo> callback) {
        HttpManager manager = new HttpManager();
        CategoryFragment.MyApiService service = manager.getRetrofit(manager.getOkhttpClient()).create(CategoryFragment.MyApiService.class);

        service.getApps("{'page':0}").enqueue(callback);
    }
}
