package com.mate.ad.demo.target;

import android.media.MediaPlayer;
import android.os.Build;

import com.mate.videolist.widget.VideoPlayerView;

/**
 * create by fushenghua
 */
public class VideoLoadTarget implements VideoPlayerView.MediaPlayerCallback {


    private final VideoLoadView mLoadMvpView;

    public VideoLoadTarget(VideoLoadView mvpView) {
        mLoadMvpView = mvpView;
        mLoadMvpView.getVideoView().setMediaPlayerCallback(this);
    }

    public void onResourceReady(String url) {
        mLoadMvpView.videoResourceReady(url);
    }

//    @Override
//    public void getSize(SizeReadyCallback cb) {
//        cb.onSizeReady(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
//    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        mLoadMvpView.videoStopped();
        return true;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mLoadMvpView.videoPrepared(mp);
        // it is better call when video rendering start, but this flag is added in API 17
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mLoadMvpView.videoBeginning();
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        // do nothing
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        // do nothing
//        cb.onSizeReady(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
    }

    @Override
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        // do nothing
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
            mLoadMvpView.videoBeginning();
            return true;
        }
        return false;
    }
}
