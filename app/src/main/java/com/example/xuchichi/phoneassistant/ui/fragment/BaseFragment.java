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
 * <p>
 * setUserVisibleHint(boolean isVisibleToUser)方法会多次回调,
 * 而且可能会在onCreateView()方法执行完毕之前回调.如果isVisibleToUser==true,
 * 然后进行数据加载和控件数据填充,但是onCreateView()方法并未执行完毕,此时就会出现NullPointerException空指针异常.
 * <p>
 * 懒加载条件1。oncreate执行完毕 2。setUserVisibleHint返回true
 */

public abstract class BaseFragment extends Fragment {
    View view;
    public Context context;
    public BaseActivity mActivity;
    private Unbinder unbinder;

    private boolean isViewCreated;
    private boolean isUiVisible;


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
        isViewCreated = true;
        lazyLoad();
        unbinder = ButterKnife.bind(this, view);

        initView();

        return view;
    }

    public abstract int getLayId();

    public abstract void initView();


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isUiVisible = true;
            lazyLoad();
        } else {
            isUiVisible = false;
        }
    }

    public void lazyLoad() {
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,
        // 并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isUiVisible && isViewCreated) {
            loadData();
            isUiVisible = false;
            isViewCreated = false;
        }

    }

    public void loadData() {
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
