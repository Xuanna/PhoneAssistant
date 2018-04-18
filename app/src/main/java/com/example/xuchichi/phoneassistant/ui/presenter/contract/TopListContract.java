package com.example.xuchichi.phoneassistant.ui.presenter.contract;

import com.example.xuchichi.phoneassistant.ui.BaseView;
import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.presenter.BasePresenterInterface;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by xuchichi on 2018/4/15.
 */

public interface TopListContract {

    interface View extends BaseView {

        void showDetailData(List<MyAppInfo.DatasBean> datas);
    }

    interface Presenter extends BasePresenterInterface {

        void getTopList(int page);
    }
}
