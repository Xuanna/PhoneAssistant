package com.example.xuchichi.phoneassistant.ui.di.module;

import com.example.xuchichi.phoneassistant.ui.model.TopListModel;
import com.example.xuchichi.phoneassistant.ui.net.OkhttpApiService;
import com.example.xuchichi.phoneassistant.ui.presenter.TopListPresenter;
import com.example.xuchichi.phoneassistant.ui.presenter.contract.TopListContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xuchichi on 2018/4/15.
 */
@Module
public class TopListModule {


    TopListContract.View mView;

    public TopListModule(TopListContract.View mView) {
        this.mView = mView;
    }


    @Provides
    public TopListContract.View provideView() {
        return mView;
    }

    @Provides
    public TopListContract.Presenter providePresenter(TopListContract.View view, TopListModel model) {

        return new TopListPresenter(view, model);
    }

    @Provides
    public TopListModel provideModel(OkhttpApiService service) {

        return new TopListModel(service);
    }


}
