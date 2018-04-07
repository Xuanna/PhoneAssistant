package com.example.xuchichi.phoneassistant.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xuchichi.phoneassistant.R;
import com.example.xuchichi.phoneassistant.ui.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xuchichi on 2018/4/3.
 */

public class RecommendFragment extends BaseFragment {
    @BindView(R.id.tv)
    TextView tv;
    Unbinder unbinder;

    @Override
    public int getLayId() {
        return R.layout.fragment_games;
    }

    @Override
    public void initView() {
        tv.setText("推荐页");
    }

    @Override
    public void loadData() {
        super.loadData();
        LogUtils.d("loadData");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
