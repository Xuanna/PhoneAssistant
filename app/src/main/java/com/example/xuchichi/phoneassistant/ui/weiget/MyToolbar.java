package com.example.xuchichi.phoneassistant.ui.weiget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.xuchichi.phoneassistant.R;

/**
 * Created by xuchichi on 2018/4/3.
 */

public class MyToolbar extends Toolbar {

    public MyToolbar(Context context) {
        super(context, null);
    }

    public MyToolbar(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }

    private LayoutInflater inflater;
    private View mView;
    TextView mTextTitle;

    public void initView() {

        if (mView == null) {
            inflater = LayoutInflater.from(getContext());
            mView = inflater.inflate(R.layout.layout_toolbar, null);
            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
            addView(mView, lp);
        }
        setNavigationIcon(R.mipmap.back);


    }

}
