package com.mate.ad.demo.target;

import android.media.MediaPlayer;

import com.mate.videolist.widget.VideoPlayerView;

/**
 * create by fushenghua
 */
public interface VideoLoadView {

    VideoPlayerView getVideoView();

    void videoBeginning();

    void videoStopped();

    void videoPrepared(MediaPlayer player);

    void videoResourceReady(String videoPath);
}
