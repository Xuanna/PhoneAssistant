package com.example.xuchichi.phoneassistant.ui.di.module;

import com.example.xuchichi.phoneassistant.ui.adapter.CategoaryAdapter;
import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.fragment.CategoryFragment;
import com.example.xuchichi.phoneassistant.ui.model.CategoaryModel;
import com.example.xuchichi.phoneassistant.ui.net.OkhttpApiService;
import com.example.xuchichi.phoneassistant.ui.presenter.CategoaryPresenter;
import com.example.xuchichi.phoneassistant.ui.presenter.contract.CategoryContract;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;

/**
 * Created by xuchichi on 2018/4/7.依赖对象
 */

@Module
public class CategotyModule {//new d对象

    CategoryContract.View mView;

    public CategotyModule(CategoryContract.View view) {
        this.mView = view;
    }

    @Provides
    public CategoaryModel privodeModel(OkhttpApiService okhttpApiService) {
        return new CategoaryModel(okhttpApiService);
    }

    @Provides
    public CategoryContract.Presenter getPresenter(CategoryContract.View view,CategoaryModel model) {
        return new CategoaryPresenter(view,model);
    }

    @Provides
    public CategoryContract.View provideView() {
        return mView;
    }



}
