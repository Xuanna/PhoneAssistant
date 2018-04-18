package com.example.xuchichi.phoneassistant.ui.presenter;

import android.support.v7.view.menu.MenuView;

import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.model.CategoaryModel;
import com.example.xuchichi.phoneassistant.ui.presenter.contract.CategoryContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xuchichi on 2018/4/6.
 * Model和view进行交互
 */

public class CategoaryPresenter implements CategoryContract.Presenter {

    public CategoryContract.View mView;

    public CategoaryModel mModel;

    public CategoaryPresenter(CategoryContract.View mView,CategoaryModel mModel) {
        this.mView = mView;
        this.mModel=mModel;
    }

    @Override
    public void requestDatas() {
        mView.showLoading();
        mModel.getCategoryList(new Callback<MyAppInfo>() {
            @Override
            public void onResponse(Call<MyAppInfo> call, Response<MyAppInfo> response) {
                mView.dismissLoading();
                if (response != null) {
                    mView.showResult(response.body().datas);
                } else {
                    mView.showNoData();
                }
            }

            @Override
            public void onFailure(Call<MyAppInfo> call, Throwable t) {
                mView.dismissLoading();
                mView.showError(t.getMessage());
            }
        });
    }
}
