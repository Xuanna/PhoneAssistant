package com.example.xuchichi.phoneassistant.ui.di.component;

import com.example.xuchichi.phoneassistant.ui.di.FragmentScope;
import com.example.xuchichi.phoneassistant.ui.di.module.CategotyModule;
import com.example.xuchichi.phoneassistant.ui.fragment.CategoryFragment;
import com.example.xuchichi.phoneassistant.ui.net.HttpModule;

import dagger.Component;

/**
 * Created by xuchichi on 2018/4/15.
 */
@FragmentScope
@Component(modules = CategotyModule.class,dependencies = AppComponent.class)
public interface CategoryComponent {

    void inject(CategoryFragment fragment);
}
