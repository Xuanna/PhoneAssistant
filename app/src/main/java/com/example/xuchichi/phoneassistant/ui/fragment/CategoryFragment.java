package com.example.xuchichi.phoneassistant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xuchichi.phoneassistant.R;
import com.example.xuchichi.phoneassistant.ui.MyApplication;
import com.example.xuchichi.phoneassistant.ui.adapter.CategoaryAdapter;
import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.di.CategotyModel;
import com.example.xuchichi.phoneassistant.ui.di.DaggerCategoryComponent;
import com.example.xuchichi.phoneassistant.ui.net.ApiService;
import com.example.xuchichi.phoneassistant.ui.net.HttpManager;
import com.example.xuchichi.phoneassistant.ui.presenter.CategoaryPresenter;
import com.example.xuchichi.phoneassistant.ui.presenter.contract.CategoryContract;
import com.example.xuchichi.phoneassistant.ui.utils.LogUtils;
import com.example.xuchichi.phoneassistant.ui.utils.ToastUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xuchichi on 2018/4/3.
 */

public class CategoryFragment extends BaseFragment implements CategoryContract.View {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    Unbinder unbinder;

    @Inject
    CategoryContract.Presenter mPresenter;

    @Override
    public int getLayId() {
        return R.layout.fragment_games;
    }

    @Override
    public void initView() {

        initAdapter();
        init();
    }

    CategoaryAdapter adapter;

    public void initAdapter() {

        adapter = new CategoaryAdapter(context);
        recycleView.setLayoutManager(new LinearLayoutManager(context));
        recycleView.setAdapter(adapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showNoData() {
        ToastUtil.showText(getString(R.string.empty_data));
    }

    @Override
    public void showError(String msg) {
        ToastUtil.showText(msg);
    }

    @Override
    public void showResult(List<MyAppInfo.DatasBean> datas) {
        adapter.addData(datas);
    }

    public void init() {

        DaggerCategoryComponent.builder().categotyModel(new CategotyModel(this)).build().inject(this);

//        mPresenter = new CategoaryPresenter(this);
        mPresenter.requestDatas();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        DaggerCategoryComponent.create();

    }

    @Override
    public void loadData() {
        super.loadData();

//        initData();
//
//        ApiService service = MyApplication.retrofit.create(ApiService.class);
//        //subscribeOn指定Observal线程
//        //observerOn指定Observer线程
//        service.getCategories()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ResponseBody>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                      LogUtils.e("onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(ResponseBody requestBody) {
//                        try{
//
//                            LogUtils.e(requestBody.string());
//
//                           }catch (Exception e){
//
//                                  e.printStackTrace();
//                            }
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        LogUtils.e("onError:"+e.toString());
//                       tv.setText(e.toString());
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        LogUtils.e("onComplete:");
//
//                    }
//                });
    }

    public interface MyApiService {

        @GET("featured")
        Call<MyAppInfo> getApps(@Query("p") String params);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
