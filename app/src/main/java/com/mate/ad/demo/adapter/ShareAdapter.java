package com.mate.ad.demo.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mate.ad.demo.bean.FamilyBean;
import com.mate.ad.demo.bean.VideoBean;
import com.mate.ad.demo.holder.BaseViewHolder;
import com.mate.ad.demo.holder.ShareViewHolder;

import java.util.List;

/**
 * @author danielwang
 * @Description:
 * @date 2018/7/13 17:07
 */
public class ShareAdapter extends CommonAdapter<FamilyBean> {

    public ShareAdapter(int layoutId, List<FamilyBean> datas) {
        super(layoutId, datas);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShareViewHolder(inflateItemView(parent, viewType));
    }
}
