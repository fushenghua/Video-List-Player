package com.mate.videolist.widget;

/**
 * create by fushenghua
 */
public class VideoPlayerManager {

    private VideoPlayerView mVideoPlayer;

    private VideoPlayerManager() {
    }

    public static VideoPlayerManager getInstance() {
        return VideoPlayerHolder.INSTANCE;
    }

    public VideoPlayerView getCurrentVideoPlayer() {
        return mVideoPlayer;
    }

    public void setCurrentNiceVideoPlayer(VideoPlayerView videoPlayer) {
        if (mVideoPlayer != videoPlayer) {
            releaseVideoPlayer();
            mVideoPlayer = videoPlayer;
        }
    }

    public void suspendVideoPlayer() {
        if (mVideoPlayer != null && (mVideoPlayer.isPlaying() || mVideoPlayer.isBufferingPlaying())) {
            mVideoPlayer.pause();
        }
    }

    public void resumeVideoPlayer() {
        if (mVideoPlayer != null && (mVideoPlayer.isPaused() || mVideoPlayer.isBufferingPaused())) {
            mVideoPlayer.resume();
        }
    }

    public void releaseVideoPlayer() {
        if (mVideoPlayer != null) {
            mVideoPlayer.release();
            mVideoPlayer = null;
        }
    }

    public boolean onBackPressd() {
        if (mVideoPlayer != null) {
            if (mVideoPlayer.isFullScreen()) {
                return mVideoPlayer.exitFullScreen();
            } else if (mVideoPlayer.isTinyWindow()) {
                return mVideoPlayer.exitTinyWindow();
            }
        }
        return false;
    }

    public static class VideoPlayerHolder {
        static VideoPlayerManager INSTANCE = new VideoPlayerManager();
    }
}
