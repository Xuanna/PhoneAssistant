package com.example.xuchichi.phoneassistant.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by xuchichi on 2018/4/5.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    SparseArray<View> views = new SparseArray<>();
    BaseRecycleAdapter.OnItemClickListener onItemClickListener;


    public BaseViewHolder(View itemView, BaseRecycleAdapter.OnItemClickListener onItemClickListener) {
        super(itemView);
        this.onItemClickListener = onItemClickListener;
        itemView.setOnClickListener(this);
        this.views = new SparseArray<>();
    }

    public View getViewId(int viewId) {
        return findViewId(viewId);

    }

    protected <T extends View> T findViewId(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick(v, getLayoutPosition());
    }
}
