package com.example.xuchichi.phoneassistant.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xuchichi.phoneassistant.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xuchichi on 2018/4/3.
 */

public class GuideFragment extends BaseFragment {


    public static final String IMG_ID = "IMG_ID";
    public static final String COLOR_ID = "COLOR_ID";
    public static final String TEXT_ID = "TEXT_ID";

    @BindView(R.id.imgView)
    ImageView mImgView;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.rootView)
    LinearLayout mRootView;
    Unbinder unbinder;

    @Override
    public int getLayId() {
        return R.layout.fragment_guide;
    }

    @Override
    public void initView() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        initData();
        return rootView;
    }


    public static GuideFragment newInstance(int imgResId, int bgColorResId, int textResId) {


        GuideFragment fragment = new GuideFragment();


        Bundle bundle = new Bundle();

        bundle.putInt(IMG_ID, imgResId);
        bundle.putInt(COLOR_ID, bgColorResId);
        bundle.putInt(TEXT_ID, textResId);
        fragment.setArguments(bundle);


        return fragment;


    }

    private void initData() {

        Bundle  args = getArguments();

        int colorId = args.getInt(COLOR_ID);
        int imgId = args.getInt(IMG_ID);
        int textId = args.getInt(TEXT_ID);


        mRootView.setBackgroundColor(getResources().getColor(colorId));
        mImgView.setImageResource(imgId);
        mText.setText(textId);



    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
