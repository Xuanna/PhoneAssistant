package com.example.xuchichi.phoneassistant.ui.activity;

import android.util.Log;

import com.example.xuchichi.phoneassistant.R;
import com.example.xuchichi.phoneassistant.ui.bean.BaseBean;
import com.example.xuchichi.phoneassistant.ui.bean.Category;
import com.example.xuchichi.phoneassistant.ui.bean.IndexBean;
import com.example.xuchichi.phoneassistant.ui.net.ApiService;
import com.example.xuchichi.phoneassistant.ui.utils.LogUtils;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class AppDetailActivity extends BaseActivity {

    @Override
    public int layoutId() {
        return R.layout.activity_app_detail;
    }

    @Override
    public void initView() {
        getListData();
    }

    public void getListData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        RecommendService service = retrofit.create(RecommendService.class);

         service.getCategories()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<RequestBody>() {
           @Override
           public void onSubscribe(Disposable d) {
               LogUtils.e("onSubscribe");
           }

           @Override
           public void onNext(RequestBody requestBody) {

             LogUtils.e(requestBody.toString());
           }

           @Override
           public void onError(Throwable e) {
               LogUtils.e("onError:"+e.toString());
           }

           @Override
           public void onComplete() {
               LogUtils.e("onComplete");
           }
       });


    }

    public interface RecommendService {

        @GET("index")
        Observable<RequestBody> getCategories();
    }
}
