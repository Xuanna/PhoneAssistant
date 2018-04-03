package com.example.xuchichi.phoneassistant.ui.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.xuchichi.phoneassistant.ui.entity.FragmentInfo;

import java.util.List;

/**
 * Created by xuchichi on 2018/4/3.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<FragmentInfo> mFragments;

    public ViewPagerAdapter(FragmentManager fm, List<FragmentInfo> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) mFragments.get(position).getFragments().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
