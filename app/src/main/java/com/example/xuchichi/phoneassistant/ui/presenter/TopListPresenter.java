package com.example.xuchichi.phoneassistant.ui.presenter;


import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.model.TopListModel;
import com.example.xuchichi.phoneassistant.ui.presenter.contract.TopListContract;
import com.example.xuchichi.phoneassistant.ui.utils.LogUtils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by xuchichi on 2018/4/15.
 */

public class TopListPresenter implements TopListContract.Presenter {

    TopListContract.View mView;

    TopListModel model;


    public TopListPresenter(TopListContract.View mView, TopListModel model) {
        this.mView = mView;
        this.model = model;
    }


    @Override

    public void getTopList(int page) {
        mView.showLoading();
        Call<MyAppInfo> call = model.getTopList(page);
        call.enqueue(new Callback<MyAppInfo>() {
            @Override
            public void onResponse(Call<MyAppInfo> call, Response<MyAppInfo> response) {
                mView.dismissLoading();
                if (response.isSuccessful()) {
                    try {
                        LogUtils.e("reponse" + response.body().toString());
                        mView.showDetailData(response.body().datas);
                    } catch (Exception e) {

                        e.printStackTrace();
                    }

                } else {
                    mView.showError("failed");
                }
            }

            @Override
            public void onFailure(Call<MyAppInfo> call, Throwable t) {

            }
        });
    }
}
