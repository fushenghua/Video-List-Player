package com.mate.ad.demo.holder;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mate.ad.demo.BuildConfig;
import com.mate.ad.demo.GlobalConstant;
import com.mate.ad.demo.R;
import com.mate.ad.demo.SingleVideoActivity;
import com.mate.ad.demo.bean.VideoBean;
import com.mate.ad.demo.target.VideoLoadTarget;
import com.mate.ad.demo.target.VideoLoadView;
import com.mate.videolist.visibility.items.ListItem;
import com.mate.videolist.widget.VideoPlayerView;


public class VideosHolder extends BaseViewHolder<VideoBean> implements VideoLoadView, ViewPropertyAnimatorListener, ListItem {
    private static final String TAG = "VideosHolder";

    public ImageView videoCover, mPlay;

    public RelativeLayout mRlVideo;

    public TextView mVideoName;

    private static final int STATE_IDLE = 0;
    private static final int STATE_ACTIVED = 1;
    private static final int STATE_DEACTIVED = 2;
    private int videoState = STATE_IDLE;
    private String videoLocalPath;

    public VideoPlayerView videoView;
    private final VideoLoadTarget videoTarget;

    private Context mContext;


    public VideosHolder(View itemView, final Context context) {
        super(itemView);
        videoView = itemView.findViewById(R.id.video_play);
        mRlVideo = itemView.findViewById(R.id.rl_video);
        videoCover = itemView.findViewById(R.id.iv_video);
        mPlay = itemView.findViewById(R.id.iv_play);
        mVideoName = itemView.findViewById(R.id.tv_video);
        this.mContext = context;
        videoView.setAlpha(0);
        videoTarget = new VideoLoadTarget(this);
    }

    private void reset() {
        videoState = STATE_IDLE;
        videoView.resetVideoPlayer();
        videoLocalPath = null;
        videoStopped();
    }

    private void cancelAlphaAnimate(View v) {
        ViewCompat.animate(v).cancel();
    }

    private void startAlphaAnimate(View v) {
        ViewCompat.animate(v).setListener(this).alpha(0f);
    }

    @Override
    public VideoPlayerView getVideoView() {
        return videoView;
    }

    @Override
    public void videoBeginning() {

    }

    @Override
    public void videoStopped() {
        cancelAlphaAnimate(videoCover);
        videoView.setAlpha(0);
        videoCover.setAlpha(1.f);
        videoCover.setVisibility(View.VISIBLE);
    }

    @Override
    public void videoPrepared(MediaPlayer player) {
        videoView.setAlpha(1.f);
        cancelAlphaAnimate(mPlay);
        startAlphaAnimate(mPlay);
        cancelAlphaAnimate(videoCover);
        startAlphaAnimate(videoCover);
//        videoView.mute();
//        videoView.setLooping(true);
    }

    @Override
    public void videoResourceReady(String videoPath) {
        videoLocalPath = videoPath;
        if (videoLocalPath != null) {
            videoView.setDataSource(videoPath);
            if (videoState == STATE_ACTIVED) {
                videoView.start();
            }
        }
    }

    @Override
    public void setActive(View newActiveView, int newActiveViewPosition) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "setActive " + newActiveViewPosition + " path " + videoLocalPath);
        }

        videoState = STATE_ACTIVED;
        if (videoLocalPath != null) {
            videoView.setDataSource(videoLocalPath);
            videoView.start();
        }
    }

    @Override
    public void deactivate(View currentView, int position) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, "deactivate " + position);
        }

        videoState = STATE_DEACTIVED;
        videoView.resetVideoPlayer();
        videoStopped();
    }

    @Override
    public void onAnimationStart(View view) {

    }

    @Override
    public void onAnimationEnd(View view) {
        view.setVisibility(View.GONE);
    }

    @Override
    public void onAnimationCancel(View view) {

    }

    @Override
    public void onBind(int position, final VideoBean videoBean) {
        reset();
        mVideoName.setText(videoBean.videoTitle);
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startVideoActivity(videoBean);
            }
        });
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startVideoActivity(videoBean);
            }
        });

        Glide.with(itemView.getContext()).load(videoBean.coverImg).into(videoCover);
        videoTarget.onResourceReady(videoBean.url);
    }

    private void startVideoActivity(VideoBean videoBean) {
        Intent intent = new Intent(itemView.getContext(), SingleVideoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(GlobalConstant.NAME, videoBean.videoTitle);
        intent.putExtra(GlobalConstant.VIDEOURL, videoBean.url);
        intent.putExtra(GlobalConstant.VIDEO_BAC, videoBean.coverImg);
        itemView.getContext().startActivity(intent);
    }


}
