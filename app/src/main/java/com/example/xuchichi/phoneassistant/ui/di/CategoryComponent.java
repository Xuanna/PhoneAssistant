package com.example.xuchichi.phoneassistant.ui.di;

import com.example.xuchichi.phoneassistant.ui.fragment.CategoryFragment;

/**
 * Created by xuchichi on 2018/4/7.
 * 关联Activity或者Fragment
 */

@dagger.Component(modules = CategotyModel.class)
public interface CategoryComponent {

    void inject(CategoryFragment fragment);

}
