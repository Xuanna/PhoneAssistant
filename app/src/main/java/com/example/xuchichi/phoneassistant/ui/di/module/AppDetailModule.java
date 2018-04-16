package com.example.xuchichi.phoneassistant.ui.di.module;

import com.example.xuchichi.phoneassistant.ui.net.OkhttpApiService;
import com.example.xuchichi.phoneassistant.ui.presenter.AppDetailPresenter;
import com.example.xuchichi.phoneassistant.ui.presenter.contract.AppDetailContract;

import dagger.Module;

/**
 * Created by xuchichi on 2018/4/15.
 */

@Module
public class AppDetailModule {

    AppDetailContract.View mView;

    public AppDetailModule(AppDetailContract.View mView) {
        this.mView = mView;
    }

    public AppDetailContract.View provideView() {

        return mView;
    }

    public AppDetailContract.Presenter providePresenter(AppDetailContract.View mView, OkhttpApiService service) {

        return new AppDetailPresenter(mView, service);
    }


}
