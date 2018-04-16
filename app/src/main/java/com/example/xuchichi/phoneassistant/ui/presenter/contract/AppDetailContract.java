package com.example.xuchichi.phoneassistant.ui.presenter.contract;

import com.example.xuchichi.phoneassistant.ui.BaseView;
import com.example.xuchichi.phoneassistant.ui.presenter.BasePresenterInterface;

/**
 * Created by xuchichi on 2018/4/14.
 */

public interface AppDetailContract {

    interface View extends BaseView {

        void setData();

    }

    interface Presenter extends BasePresenterInterface {

        void getAppDetail(int page);
    }
}
