package com.example.xuchichi.phoneassistant.ui.di;

import com.example.xuchichi.phoneassistant.ui.adapter.CategoaryAdapter;
import com.example.xuchichi.phoneassistant.ui.presenter.CategoaryPresenter;
import com.example.xuchichi.phoneassistant.ui.presenter.contract.CategoryContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xuchichi on 2018/4/7.依赖对象
 */

@Module
public class CategotyModel {//new d对象

    CategoryContract.View mView;

    public CategotyModel(CategoryContract.View view) {
        this.mView = view;
    }

    @Provides
    public CategoryContract.Presenter getPresenter(CategoryContract.View view) {//方法提供
        return new CategoaryPresenter(view);
    }

    @Provides
    public CategoryContract.View provideView() {
        return mView;
    }

    @Provides
    public CategoaryAdapter getAdapter() {
        return null;
    }

}
