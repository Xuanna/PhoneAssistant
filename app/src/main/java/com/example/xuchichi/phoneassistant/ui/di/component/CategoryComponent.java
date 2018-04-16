package com.example.xuchichi.phoneassistant.ui.di.component;

import com.example.xuchichi.phoneassistant.ui.di.module.CategotyModule;
import com.example.xuchichi.phoneassistant.ui.fragment.CategoryFragment;

import dagger.Component;

/**
 * Created by xuchichi on 2018/4/15.
 */
@Component(modules = CategotyModule.class)
public interface CategoryComponent {

    void inject(CategoryFragment fragment);
}
