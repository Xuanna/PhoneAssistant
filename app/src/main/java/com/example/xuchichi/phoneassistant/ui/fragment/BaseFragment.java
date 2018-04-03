package com.example.xuchichi.phoneassistant.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xuchichi.phoneassistant.ui.activity.BaseActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xuchichi on 2018/4/1.
 */

public abstract class BaseFragment extends Fragment {
    View view;
    public Context context;
    public BaseActivity mActivity;
    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) getActivity();
        context = mActivity.getApplicationContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayId(), container, false);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }

        unbinder= ButterKnife.bind(view);
        initView();

        return view;
    }

    public abstract int getLayId();

    public abstract void initView();


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            loadData();
        }
    }

    public void loadData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    //    static T  categoryFragment;
//
//    public static CategoryFragment getInstance() {
//        if (categoryFragment == null) {
//            categoryFragment = new CategoryFragment();
//        }
//        return categoryFragment;
//    }
}
