package com.mate.ad.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mate.ad.demo.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * create by fushenghua
 */
public abstract class CommonAdapter<D> extends RecyclerView.Adapter<BaseViewHolder> {

    protected final List<D> mDataSet = new ArrayList<>();
    protected OnItemClickListener mOnItemClickListener;
    private int mItemLayoutId;

    public CommonAdapter(int layoutId) {
        mItemLayoutId = layoutId;
    }

    public CommonAdapter(int layoutId, List<D> datas) {
        mItemLayoutId = layoutId;
        addItems(datas);
    }

    public void addItem(D item) {
        mDataSet.add(item);
        notifyDataSetChanged();
    }


    public void addItems(List<D> items) {
        mDataSet.addAll(items);
        notifyDataSetChanged();
    }

    public void addItemToHead(D item) {
        mDataSet.add(0, item);
        notifyDataSetChanged();
    }

    public void addItemsToHead(List<D> items) {
        mDataSet.addAll(0, items);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        mDataSet.remove(position);
        notifyDataSetChanged();
    }

    public void remove(D item) {
        mDataSet.remove(item);
        notifyDataSetChanged();
    }

    /**
     * clear all data
     */
    public void clear() {
        mDataSet.clear();
        notifyDataSetChanged();
    }

    public D getItem(int position) {
        return mDataSet.get(position);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        final D item = getItem(position);
        // 绑定数据
//        onBindData(holder, position, item);
        holder.onBind(position, item);
        // 设置单击事件
        setupItemClickListener(holder, position);
    }

    protected View inflateItemView(ViewGroup viewGroup, int viewType) {
        int itemLayout = getItemLayout(viewType);
        Context context = viewGroup.getContext();
        return LayoutInflater.from(context).inflate(itemLayout,
                viewGroup, false);
    }

//    @Override
//    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new BaseViewHolder<D>(inflateItemView(parent, viewType));
//    }

    protected int getItemLayout(int type) {
        return mItemLayoutId;
    }


//    protected abstract void onBindData(BaseViewHolder viewHolder, int position, D item);

    protected void setupItemClickListener(BaseViewHolder viewHolder, final int position) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position);
                }
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public static interface OnItemClickListener {
        void onItemClick(int position);
    }
}
