package com.mate.ad.demo.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mate.ad.demo.R;
import com.mate.ad.demo.bean.FamilyBean;

/**
 * @author danielwang
 * @Description:
 * @date 2018/7/13 17:04
 */
public class ShareViewHolder extends BaseViewHolder<FamilyBean> {

    private ImageView appicon;

    private TextView name, content;

    public ShareViewHolder(View itemView) {
        super(itemView);
        appicon = itemView.findViewById(R.id.iv_icon);
        name = itemView.findViewById(R.id.tv_title);
        content = itemView.findViewById(R.id.tv_date);
    }

    @Override
    public void onBind(int position, FamilyBean guidesBean) {
        name.setText(guidesBean.appName);
        content.setText(guidesBean.desc);
        Glide.with(itemView.getContext()).load(guidesBean.iconUrl).into(appicon);
    }
}
