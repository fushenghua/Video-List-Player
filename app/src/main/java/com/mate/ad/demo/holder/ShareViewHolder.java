package com.mate.ad.demo.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mate.ad.demo.R;
import com.mate.ad.demo.VideoBean;

/**
 * @author danielwang
 * @Description:
 * @date 2018/7/13 17:04
 */
public class ShareViewHolder extends BaseViewHolder<VideoBean> {

    private ImageView imageView;
    private TextView name, content;

    public ShareViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.iv_icon);
        name = itemView.findViewById(R.id.tv_title);
        content = itemView.findViewById(R.id.tv_date);
    }

    @Override
    public void onBind(int position, VideoBean guidesBean) {
        name.setText(guidesBean.videoTitle);
//        content.setText(guidesBean.getDate());
    }
}
