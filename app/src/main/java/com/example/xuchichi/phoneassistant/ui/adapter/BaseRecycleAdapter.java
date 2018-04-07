package com.example.xuchichi.phoneassistant.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuchichi on 2018/4/1.
 */

public abstract class BaseRecycleAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private List<T> datas;
    private int layoutResId;
    private Context context;

    private OnItemClickListener mOnItemClickListener = null;


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;

    }

    public BaseRecycleAdapter(Context context, int layoutResId) {
        this(context, layoutResId, null);
    }


    public BaseRecycleAdapter(Context context, int layoutResId, List<T> datas) {
        this.datas = datas == null ? new ArrayList<T>() : datas;
        this.context = context;
        this.layoutResId = layoutResId;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId, null);
        return new BaseViewHolder(view, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        T data = datas.get(position);
        bindData(holder, data);
    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }

    public abstract void bindData(BaseViewHolder holder, T data);

    public void removeItem(T t) {
        int position = datas.indexOf(t);
        datas.remove(position);
        notifyItemRemoved(position);
    }


    public void addData(List<T> datas) {

        addData(0, datas);
    }

    public void addData(int position, List<T> list) {

        if (list != null && list.size() > 0) {
            for (T t : list) {
                datas.add(position, t);
                notifyItemInserted(position);
            }

        }


    }

    public void loadMore(List<T> list) {
        int start = datas.size();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                datas.add(list.get(i));
                notifyItemInserted(start + i);
            }

        }

    }

    public void clearData() {
        int itemCount = datas.size();
        datas.clear();
        this.notifyItemRangeRemoved(0, itemCount);

    }

    public void refreshData(List<T> list) {
        clearData();
        if (list != null && list.size() > 0) {

            int size = list.size();
            for (int i = 0; i < size; i++) {
                datas.add(i, list.get(i));
                notifyItemInserted(i);
            }
        }


    }
}
