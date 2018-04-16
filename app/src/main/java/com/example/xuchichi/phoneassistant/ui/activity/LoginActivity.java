package com.example.xuchichi.phoneassistant.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.xuchichi.phoneassistant.R;
import com.example.xuchichi.phoneassistant.ui.MyApplication;
import com.example.xuchichi.phoneassistant.ui.bean.requestbean.LoginRequestBean;
import com.example.xuchichi.phoneassistant.ui.net.ApiService;
import com.example.xuchichi.phoneassistant.ui.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.txt_mobi)
    EditText txtMobi;
    @BindView(R.id.view_mobi_wrapper)
    TextInputLayout viewMobiWrapper;
    @BindView(R.id.txt_password)
    EditText txtPassword;
    @BindView(R.id.view_password_wrapper)
    TextInputLayout viewPasswordWrapper;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.activity_login)
    LinearLayout activityLogin;

    @Override
    public int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        LoginRequestBean bean = new LoginRequestBean();
        bean.setEmail("18679131590");
        bean.setPassword("1131120704a");
        login(bean);
    }

    public void login(LoginRequestBean param) {
        ApiService service = MyApplication.retrofit.create(ApiService.class);
        service.login(param)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try{


                           }catch (Exception e){

                                  e.printStackTrace();
                            }

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
