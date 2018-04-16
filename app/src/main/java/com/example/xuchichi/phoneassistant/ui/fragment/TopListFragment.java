package com.example.xuchichi.phoneassistant.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xuchichi.phoneassistant.R;
import com.example.xuchichi.phoneassistant.ui.MyApplication;
import com.example.xuchichi.phoneassistant.ui.adapter.TopListAdapter;
import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.di.component.DaggerTopListComponent;
import com.example.xuchichi.phoneassistant.ui.di.module.TopListModule;
import com.example.xuchichi.phoneassistant.ui.presenter.contract.TopListContract;
import com.example.xuchichi.phoneassistant.ui.utils.LogUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xuchichi on 2018/4/3.
 */

public class TopListFragment extends BaseFragment implements TopListContract.View {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    Unbinder unbinder;

    @Inject
    TopListContract.Presenter presenter;

    TopListAdapter adapter;

    @Override
    public int getLayId() {
        return R.layout.fragment_games;
    }

    @Override
    public void initView() {


        adapter = new TopListAdapter(context);
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(new LinearLayoutManager(context));

        DaggerTopListComponent.builder()
                .appComponent(MyApplication.getInstance().getAppComponent())
                .topListModule(new TopListModule(this))
                .build().inject(this);

        presenter.getTopList(0);

    }

    @Override
    public void loadData() {
        super.loadData();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);


        return rootView;
    }

    @Override
    public void showDetailData(MyAppInfo myAppInfo) {
        LogUtils.e("showDetailData");
        adapter.addData(myAppInfo.datas);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
