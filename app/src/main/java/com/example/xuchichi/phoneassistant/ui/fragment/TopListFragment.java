package com.example.xuchichi.phoneassistant.ui.fragment;

import com.example.xuchichi.phoneassistant.R;
import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.net.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xuchichi on 2018/4/3.
 */

public class TopListFragment extends BaseFragment {
    @Override
    public int getLayId() {
        return R.layout.fragment_games;
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadData() {
        super.loadData();

    }

}
