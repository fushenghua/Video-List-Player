package com.mate.ad.demo.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mate.ad.demo.VideoBean;
import com.mate.ad.demo.holder.BaseViewHolder;
import com.mate.ad.demo.holder.ShareViewHolder;

import java.util.List;

/**
 * @author danielwang
 * @Description:
 * @date 2018/7/13 17:07
 */
public class ShareAdapter extends CommonAdapter<VideoBean> {

    public ShareAdapter(int layoutId, List<VideoBean> datas) {
        super(layoutId, datas);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShareViewHolder(inflateItemView(parent, viewType));
    }
}
