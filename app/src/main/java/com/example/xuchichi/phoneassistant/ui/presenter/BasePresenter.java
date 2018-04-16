package com.example.xuchichi.phoneassistant.ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.xuchichi.phoneassistant.ui.BaseView;

/**
 * Created by xuchichi on 2018/4/16.
 */

public class BasePresenter<M, V extends BaseView> {

    protected M mModel;

    protected V mView;


    protected Context mContext;


    public BasePresenter(M m, V v) {

        this.mModel = m;
        this.mView = v;

        initContext();

    }


    private void initContext() {


        if (mView instanceof Fragment) {
            mContext = ((Fragment) mView).getActivity();
        } else {
            mContext = (Activity) mView;
        }
    }


}
