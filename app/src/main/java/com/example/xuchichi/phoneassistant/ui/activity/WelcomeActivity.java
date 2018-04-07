package com.example.xuchichi.phoneassistant.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.xuchichi.phoneassistant.R;
import com.example.xuchichi.phoneassistant.ui.common.ACache;
import com.example.xuchichi.phoneassistant.ui.common.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 欢迎页
 */
public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    public int layoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {
    }


    private void jump() {


        String isShowGuide = ACache.get(this).getAsString(Constant.IS_SHOW_GUIDE);

        // 第一次启动进入引导页面
        if (null == isShowGuide) {
            startActivity(new Intent(this, GuideActivity.class));

        } else {
            startActivity(new Intent(this, MainActivity.class));
        }


        this.finish();
    }
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
    }
}
