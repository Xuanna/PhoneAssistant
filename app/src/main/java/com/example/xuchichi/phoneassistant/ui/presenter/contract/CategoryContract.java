package com.example.xuchichi.phoneassistant.ui.presenter.contract;

import com.example.xuchichi.phoneassistant.ui.BaseView;
import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.presenter.BasePresenter;

import java.util.List;

/**
 * Created by xuchichi on 2018/4/6.
 */

public interface CategoryContract {

    interface View extends BaseView{



        void showNoData();

        void showError(String msg);

        void showResult(List<MyAppInfo.DatasBean> datas);

    }
    interface Presenter extends BasePresenter{

        void requestDatas();
    }


}
