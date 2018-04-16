package com.example.xuchichi.phoneassistant.ui.di.component;

import com.example.xuchichi.phoneassistant.ui.di.FragmentScope;
import com.example.xuchichi.phoneassistant.ui.di.module.TopListModule;
import com.example.xuchichi.phoneassistant.ui.fragment.TopListFragment;

import dagger.Component;

/**
 * Created by xuchichi on 2018/4/15.
 */
@FragmentScope
@Component(modules = TopListModule.class, dependencies = AppComponent.class)
public interface TopListComponent {


    void inject(TopListFragment fragment);
}

