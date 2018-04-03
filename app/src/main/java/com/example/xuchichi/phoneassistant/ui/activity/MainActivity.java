package com.example.xuchichi.phoneassistant.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;

import com.example.xuchichi.phoneassistant.R;
import com.example.xuchichi.phoneassistant.ui.adapter.ViewPagerAdapter;
import com.example.xuchichi.phoneassistant.ui.entity.FragmentInfo;
import com.example.xuchichi.phoneassistant.ui.fragment.BaseFragment;
import com.example.xuchichi.phoneassistant.ui.fragment.CategoryFragment;
import com.example.xuchichi.phoneassistant.ui.fragment.GamesFragment;
import com.example.xuchichi.phoneassistant.ui.fragment.RecommendFragment;
import com.example.xuchichi.phoneassistant.ui.fragment.TopListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.navigationView)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    View headView;

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initToolbar();
        initTab();

    }

    public void initToolbar() {
        headView = navigationView.getHeaderView(0);
        headView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        startActivity(AppDetailActivity.class);
                        break;

                }
                return false;
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_app_update:
                        break;
                    case R.id.menu_download_manager:
                        break;
                    case R.id.menu_app_uninstall:
                        break;
                    case R.id.menu_setting:
                        break;
                    case R.id.menu_logout:
                        break;

                }
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.toolbar_menu);
        //toolbar和navigation结合
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
    }

    private List<FragmentInfo> initFragments() {

        List<FragmentInfo> mFragments = new ArrayList<>(4);

        mFragments.add(new FragmentInfo("推荐", CategoryFragment.class));
        mFragments.add(new FragmentInfo("排行", TopListFragment.class));


        mFragments.add(new FragmentInfo("游戏", GamesFragment.class));
        mFragments.add(new FragmentInfo("分类", CategoryFragment.class));

        return mFragments;

    }

    public void initTab() {

        PagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), initFragments());
        viewpager.setOffscreenPageLimit(adapter.getCount());
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
