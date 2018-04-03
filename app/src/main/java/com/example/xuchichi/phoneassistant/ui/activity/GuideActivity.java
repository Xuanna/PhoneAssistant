package com.example.xuchichi.phoneassistant.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.xuchichi.phoneassistant.R;
import com.example.xuchichi.phoneassistant.ui.adapter.GuildPagerAdapter;
import com.example.xuchichi.phoneassistant.ui.common.ACache;
import com.example.xuchichi.phoneassistant.ui.common.Constant;
import com.example.xuchichi.phoneassistant.ui.fragment.GuideFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 引导页
 */
public class GuideActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    public int layoutId() {
        return R.layout.activity_guild;
    }

    @Override
    public void initView() {
        initData();
    }

    GuildPagerAdapter pagerAdapter;
    private List<Fragment> fragments = new ArrayList<>();

    public void initData() {
        fragments.add(GuideFragment.newInstance(R.drawable.guide_1, R.color.color_bg_guide1, R.string.guide_1));
        fragments.add(GuideFragment.newInstance(R.drawable.guide_2, R.color.color_bg_guide2, R.string.guide_2));
        fragments.add(GuideFragment.newInstance(R.drawable.guide_3, R.color.color_bg_guide3, R.string.guide_3));

        pagerAdapter = new GuildPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setCurrentItem(0);
        viewpager.setOffscreenPageLimit(pagerAdapter.getCount());
        viewpager.addOnPageChangeListener(this);

        viewpager.setAdapter(pagerAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == fragments.size() - 1) {
            ACache.get(this).put(Constant.IS_SHOW_GUIDE,"0");
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
