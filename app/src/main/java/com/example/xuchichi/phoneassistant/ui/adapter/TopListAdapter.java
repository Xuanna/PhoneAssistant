package com.example.xuchichi.phoneassistant.ui.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xuchichi.phoneassistant.R;
import com.example.xuchichi.phoneassistant.ui.bean.requestbean.MyAppInfo;
import com.example.xuchichi.phoneassistant.ui.common.Constant;
import com.example.xuchichi.phoneassistant.ui.utils.ImageLoader;

/**
 * Created by xuchichi on 2018/4/16.
 */

public class TopListAdapter extends BaseRecycleAdapter<MyAppInfo.DatasBean> {

    public TopListAdapter(Context context) {
        super(context, R.layout.template_category);
    }

    @Override
    public void bindData(BaseViewHolder holder, MyAppInfo.DatasBean data) {
        TextView textName = holder.findViewId(R.id.text_name);
        ImageView iv = holder.findViewId(R.id.img_icon);

        ImageLoader.getInstance().loadImage(Constant.BASE_IMG_URL + data.icon, iv);
        textName.setText(data.displayName + "");
    }
}
