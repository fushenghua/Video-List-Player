package com.mate.ad.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mate.ad.demo.R;
import com.mate.ad.demo.bean.VideoBean;
import com.mate.ad.demo.holder.BaseViewHolder;
import com.mate.ad.demo.holder.VideosHolder;
import com.mate.videolist.visibility.items.ListItem;
import com.mate.videolist.visibility.scroll.ItemsProvider;

import java.util.List;

public class VideoRecycleViewAdapter extends RecyclerView.Adapter<BaseViewHolder<VideoBean>> implements ItemsProvider {

    public static final int TYPE_DETAIL = 1;//文案详情
    public static final int TYPE_VIDEO = 2;//视频
    public static final int TYPE_SMALL = 3;//小图片
    public static final int TYPE_BIG = 4;//大图片

    private List<VideoBean> mDataList;//数据集合
    private Context mContext;
    private final RecyclerView mRecyclerView;


    public VideoRecycleViewAdapter(Context context, List<VideoBean> dataList, RecyclerView mRecyclerView) {
        this.mDataList = dataList;
        this.mContext = context;
        this.mRecyclerView = mRecyclerView;
    }

    @Override
    public BaseViewHolder<VideoBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        if (TYPE_VIDEO == viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_video, parent, false);
            VideosHolder holder = new VideosHolder(view, mContext);
            view.setTag(holder);
            return holder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<VideoBean> holder, int position) {
        VideoBean videoBean = mDataList.get(position);
        if (videoBean == null) return;
        holder.onBind(position, videoBean);
    }


    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        int tpye = 0;
        if (mDataList != null) {
            tpye = mDataList.get(position).getType();
        }
        if (1 == tpye) {
            return TYPE_DETAIL;
        } else if (2 == tpye) {
            return TYPE_VIDEO;
        } else if (3 == tpye) {
            return TYPE_SMALL;
        } else if (4 == tpye) {
            return TYPE_BIG;
        } else {
            return 0;
        }
    }

    @Override
    public ListItem getListItem(int position) {
        RecyclerView.ViewHolder holder = mRecyclerView.findViewHolderForAdapterPosition(position);
        if (holder instanceof ListItem) {
            return (ListItem) holder;
        }
        return null;
    }

    @Override
    public int listItemSize() {
        return getItemCount();
    }
}
