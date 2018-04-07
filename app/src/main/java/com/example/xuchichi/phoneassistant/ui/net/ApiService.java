package com.example.xuchichi.phoneassistant.ui.net;


import com.example.xuchichi.phoneassistant.ui.bean.AppInfo;
import com.example.xuchichi.phoneassistant.ui.bean.BaseBean;
import com.example.xuchichi.phoneassistant.ui.bean.Category;
import com.example.xuchichi.phoneassistant.ui.bean.IndexBean;
import com.example.xuchichi.phoneassistant.ui.bean.LoginBean;
import com.example.xuchichi.phoneassistant.ui.bean.PageBean;
import com.example.xuchichi.phoneassistant.ui.bean.SearchResult;
import com.example.xuchichi.phoneassistant.ui.bean.Subject;
import com.example.xuchichi.phoneassistant.ui.bean.SubjectDetail;
import com.example.xuchichi.phoneassistant.ui.bean.requestbean.LoginRequestBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ivan on 2016/12/30.
 */

public interface ApiService {
    public static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";



//
//    @GET("featured")
//    public Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);



    @GET("featured2")
    public Observable<BaseBean<PageBean<AppInfo>>> getApps(@Query("p") String jsonParam);


    @GET("index")
    public  Observable<BaseBean<IndexBean>> index();



     @GET("toplist")
    public  Observable<BaseBean<PageBean<AppInfo>>> topList(@Query("page") int page);

     @GET("game")
    public  Observable<BaseBean<PageBean<AppInfo>>> games(@Query("page") int page);


    @POST("login")
    Observable<ResponseBody> login(@Body LoginRequestBean param);//LoginBean


    @GET("category")
    Observable<ResponseBody> getCategories();//List<Category>


    @GET("category/featured/{categoryid}")
    Observable<BaseBean<PageBean<AppInfo>>> getFeaturedAppsByCategory(@Path("categoryid") int categoryid, @Query("page") int page);

    @GET("category/toplist/{categoryid}")
    Observable<BaseBean<PageBean<AppInfo>>> getTopListAppsByCategory(@Path("categoryid") int categoryid, @Query("page") int page);

    @GET("category/newlist/{categoryid}")
    Observable<BaseBean<PageBean<AppInfo>>> getNewListAppsByCategory(@Path("categoryid") int categoryid, @Query("page") int page);

    @GET("app/hot")
    Observable<BaseBean<PageBean<AppInfo>>> getHotApps(@Query("page") int page);


    @GET("app/{id}")
    Observable<BaseBean<AppInfo>> getAppDetail(@Path("id") int id);


    @GET("apps/updateinfo")
    Observable<BaseBean<List<AppInfo>>> getAppsUpdateinfo(@Query("packageName") String packageName, @Query("versionCode") String versionCode);


    @GET("subject/hot")
    Observable<BaseBean<PageBean<Subject>>> subjects(@Query("page") int page);

    @GET("subject/{id}")
    Observable<BaseBean<SubjectDetail>> subjectDetail(@Path("id") int id);


    @GET("search/suggest")
    Observable<BaseBean<List<String>>> searchSuggest(@Query("keyword") String keyword);


    @GET("search")
    Observable<BaseBean<SearchResult>> search(@Query("keyword") String keyword);












}
