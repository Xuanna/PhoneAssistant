package com.example.xuchichi.phoneassistant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xuchichi.phoneassistant.R;
import com.example.xuchichi.phoneassistant.ui.activity.AppDetailActivity;
import com.example.xuchichi.phoneassistant.ui.adapter.BaseRecycleAdapter;
import com.example.xuchichi.phoneassistant.ui.adapter.CategoaryAdapter;
import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.di.component.DaggerCategoryComponent;
import com.example.xuchichi.phoneassistant.ui.di.module.CategotyModule;
import com.example.xuchichi.phoneassistant.ui.presenter.contract.CategoryContract;
import com.example.xuchichi.phoneassistant.ui.utils.ToastUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xuchichi on 2018/4/3.
 */

public class CategoryFragment extends BaseFragment implements CategoryContract.View, BaseRecycleAdapter.OnItemClickListener {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    Unbinder unbinder;

    @Inject
    CategoryContract.Presenter mPresenter;

    @Override
    public int getLayId() {
        return R.layout.fragment_games;
    }

    @Override
    public void initView() {

        initAdapter();
        init();
    }

    CategoaryAdapter adapter;

    public void initAdapter() {

        adapter = new CategoaryAdapter(context);
        recycleView.setLayoutManager(new LinearLayoutManager(context));
        recycleView.setAdapter(adapter);

        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        mActivity.startActivity(AppDetailActivity.class);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showNoData() {
        ToastUtil.showText(getString(R.string.empty_data));
    }

    @Override
    public void showError(String msg) {
        ToastUtil.showText(msg);
    }

    @Override
    public void showResult(List<MyAppInfo.DatasBean> datas) {
        adapter.addData(datas);
    }

    public void init() {
        //.appComponent(MyApplication.getInstance().getAppComponent())
        DaggerCategoryComponent.builder().categotyModule(new CategotyModule(this)).build().inject(this);

        mPresenter.requestDatas();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void loadData() {
        super.loadData();

    }


    public interface MyApiService {

        @GET("featured")
        Call<MyAppInfo> getApps(@Query("p") String params);
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
