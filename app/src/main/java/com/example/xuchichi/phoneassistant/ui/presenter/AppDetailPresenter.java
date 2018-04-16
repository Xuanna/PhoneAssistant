package com.example.xuchichi.phoneassistant.ui.presenter;


import com.example.xuchichi.phoneassistant.ui.model.AppDetailModel;
import com.example.xuchichi.phoneassistant.ui.net.OkhttpApiService;
import com.example.xuchichi.phoneassistant.ui.presenter.contract.AppDetailContract;

/**
 * Created by xuchichi on 2018/4/14.
 */

public class AppDetailPresenter implements AppDetailContract.Presenter {

    AppDetailContract.View mView;

    AppDetailModel model;

    public AppDetailPresenter(AppDetailContract.View mView, OkhttpApiService service) {
        this.mView = mView;
        model = new AppDetailModel(service);
    }


    @Override
    public void getAppDetail(int page) {
        mView.showLoading();
    }
}
