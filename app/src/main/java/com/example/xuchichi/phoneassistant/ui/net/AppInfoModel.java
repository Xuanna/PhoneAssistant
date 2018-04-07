package com.example.xuchichi.phoneassistant.ui.net;

import com.example.xuchichi.phoneassistant.ui.bean.AppInfo;
import com.example.xuchichi.phoneassistant.ui.bean.BaseBean;
import com.example.xuchichi.phoneassistant.ui.bean.IndexBean;
import com.example.xuchichi.phoneassistant.ui.bean.PageBean;

import io.reactivex.Observable;

/**
 * Created by xuchichi on 2018/4/6.
 */

public class AppInfoModel {

    private ApiService mApiService;

    public AppInfoModel(ApiService apiService) {

        this.mApiService = apiService;
    }

    public Observable<BaseBean<IndexBean>> index() {

        return mApiService.index();
    }

    public Observable<BaseBean<PageBean<AppInfo>>> topList(int page) {

        return mApiService.topList(page);
    }

    public Observable<BaseBean<PageBean<AppInfo>>> games(int page) {

        return mApiService.games(page);
    }


    public Observable<BaseBean<PageBean<AppInfo>>> getFeaturedAppsByCategory(int categoryid, int page) {

        return mApiService.getFeaturedAppsByCategory(categoryid, page);
    }

    public Observable<BaseBean<PageBean<AppInfo>>> getTopListAppsByCategory(int categoryid, int page) {

        return mApiService.getTopListAppsByCategory(categoryid, page);
    }

    public Observable<BaseBean<PageBean<AppInfo>>> getNewListAppsByCategory(int categoryid, int page) {

        return mApiService.getNewListAppsByCategory(categoryid, page);
    }

    public Observable<BaseBean<AppInfo>> getAppDetail(int id) {

        return mApiService.getAppDetail(id);
    }


    public Observable<BaseBean<PageBean<AppInfo>>> getHotApps(int page) {

        return mApiService.getHotApps(page);
    }

}
