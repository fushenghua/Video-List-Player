package com.mate.videolist.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mate.ad.BuildConfig;
import com.mate.videolist.IVideoPlayer;

import java.io.IOException;
import java.util.Map;

/**
 * create by fushenghua
 */
public class VideoPlayerView extends FrameLayout
        implements IVideoPlayer,
        Handler.Callback,
        TextureView.SurfaceTextureListener,
        MediaPlayer.OnPreparedListener,
        MediaPlayer.OnVideoSizeChangedListener,
        MediaPlayer.OnCompletionListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnInfoListener,
        MediaPlayer.OnBufferingUpdateListener {

    private static final String TAG = "VideoPlayerView";
    private static final boolean SHOW_LOGS = BuildConfig.DEBUG;

    private volatile int mCurrentState = STATE_IDLE;
    private volatile int mTargetState = STATE_IDLE;

    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PREPARING = 1;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PAUSED = 4;
    public static final int STATE_COMPLETED = 5;
    /**
     * 正在缓冲(播放器正在播放时，缓冲区数据不足，进行缓冲，缓冲区数据足够后恢复播放)
     **/
    public static final int STATE_BUFFERING_PLAYING = 5;
    /**
     * 正在缓冲(播放器正在播放时，缓冲区数据不足，进行缓冲，此时暂停播放器，继续缓冲，缓冲区数据足够后恢复暂停
     **/
    public static final int STATE_BUFFERING_PAUSED = 6;

    private static final int MSG_START = 0x0001;
    private static final int MSG_PAUSE = 0x0004;
    private static final int MSG_RESUME = 0x0003;
    private static final int MSG_STOP = 0x0006;
    private static final int MSG_RELEASE = 0x0007;
    private static final int MSG_BUFFERING_PAUSE = 0x0008;
    private static final int MSG_BUFFERING_RESUME = 0x0009;

    private Uri mUri;

    private Context mContext;

    private VideoTextureView mTextureView;

    private FrameLayout mContainer;

    private SurfaceTexture mSurfaceTexture;

    private Surface mSurface;

    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    private MediaPlayerCallback mMediaPlayerCallback;

    private Handler mHandler;

    private Handler mVideoHandler;

    private boolean mSoundMute;

    private boolean mHasAudio;

    private ScaleType mScaleType = ScaleType.FIT_XY;

    private HandlerThread sThread = null;

    private boolean continueFromLastPosition = true;

    public VideoPlayerView(@NonNull Context context) {
        this(context, null);
    }

    public VideoPlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            mContext = getContext();
            mCurrentState = STATE_IDLE;
            mTargetState = STATE_IDLE;
        }

        mContainer = new FrameLayout(mContext);
        mContainer.setBackgroundColor(Color.BLACK);
        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        this.addView(mContainer, params);
    }

    @Override
    public void setUp(String url, Map<String, String> headers) {

    }

    @Override
    public void start() {
        if (mCurrentState == STATE_IDLE) {
            initAudioManager();
            initMediaPlayer();
            initTextureView();
            VideoPlayerManager.getInstance().setCurrentNiceVideoPlayer(this);
        }
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mMediaPlayer = mediaPlayer;
    }

    public MediaPlayer getMediaPlayer() {
        return mMediaPlayer;
    }

    private void initTextureView() {
        if (mTextureView == null) {
            mTextureView = new VideoTextureView(mContext);
            mTextureView.setSurfaceTextureListener(this);
        }

        mContainer.removeView(mTextureView);
        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        mContainer.addView(mTextureView, 0, params);
    }

    private void initMediaPlayer() {
        if (mMediaPlayer == null) {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }
    }

    private void initAudioManager() {
        if (mAudioManager == null) {
            mAudioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
            mAudioManager.requestAudioFocus(null, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
        }
    }

    private void openMediaPlayer() {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mContainer.setKeepScreenOn(true);
            }
        });

        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setOnVideoSizeChangedListener(this);
        mMediaPlayer.setOnCompletionListener(this);
        mMediaPlayer.setOnErrorListener(this);
        mMediaPlayer.setOnInfoListener(this);
        mMediaPlayer.setOnBufferingUpdateListener(this);

        try {

            mMediaPlayer.setDataSource(mContext.getApplicationContext(), mUri);
            if (mSurface == null) {
                mSurface = new Surface(mSurfaceTexture);
            }
            mMediaPlayer.setSurface(mSurface);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.prepareAsync();

            // we don't set the target state here either, but preserve the
            // target state that was there before.
            mCurrentState = STATE_PREPARING;
            mTargetState = STATE_PREPARING;

            mHasAudio = true;
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                try {
//                    MediaExtractor mediaExtractor = new MediaExtractor();
//                    mediaExtractor.setDataSource(mContext, mUri, null);
//                    MediaFormat format;
//                    for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
//                        format = mediaExtractor.getTrackFormat(i);
//                        String mime = format.getString(MediaFormat.KEY_MIME);
//                        if (mime.startsWith("audio/")) {
//                            mHasAudio = true;
//                            break;
//                        }
//                    }
//                } catch (Exception ex) {
//                    // may be failed to instantiate extractor.
//                }
//            }

        } catch (IOException | IllegalArgumentException ex) {
            if (SHOW_LOGS) Log.w(TAG, "Unable to open content: " + mUri, ex);
            mCurrentState = STATE_ERROR;
            mTargetState = STATE_ERROR;
            if (mMediaPlayerCallback != null) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mMediaPlayerCallback != null) {
                            mMediaPlayerCallback.onError(mMediaPlayer, MediaPlayer.MEDIA_ERROR_UNKNOWN, 0);
                        }
                    }
                });
            }
        }
    }

    public void setMediaPlayerCallback(MediaPlayerCallback mediaPlayerCallback) {
        mMediaPlayerCallback = mediaPlayerCallback;
        if (mediaPlayerCallback == null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void setDataSource(String path) {
        if (SHOW_LOGS) Log.d(TAG, "setDataSource, path " + path + ", this " + this);
        setDataSource(Uri.parse(path));
    }

    public void setDataSource(Uri uri) {
        if (SHOW_LOGS) Log.i(TAG, "setDataSource " + uri.toString());
        mUri = uri;
    }

    public int getVideoHeight() {
        if (mMediaPlayer != null) {
            return mMediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        if (mMediaPlayer != null) {
            return mMediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public void setScaleType(ScaleType scaleType) {
        mScaleType = scaleType;
        scaleVideoSize(getVideoWidth(), getVideoHeight());
    }

    public ScaleType getScaleType() {
        return mScaleType;
    }

    private void scaleVideoSize(int videoWidth, int videoHeight) {
        if (videoWidth == 0 || videoHeight == 0) {
            return;
        }

        Size viewSize = new Size(getWidth(), getHeight());
        Size videoSize = new Size(videoWidth, videoHeight);
        ScaleManager scaleManager = new ScaleManager(viewSize, videoSize);
        final Matrix matrix = scaleManager.getScaleMatrix(mScaleType);
        if (matrix == null) {
            return;
        }

        if (Looper.myLooper() == Looper.getMainLooper()) {
            mTextureView.setTransform(matrix);
        } else {
            mHandler.postAtFrontOfQueue(new Runnable() {
                @Override
                public void run() {
                    mTextureView.setTransform(matrix);
                }
            });
        }
    }

    public void mute() {
        if (mMediaPlayer != null) {
            mMediaPlayer.setVolume(0, 0);
            mSoundMute = true;
        }
    }

    public void setLooping(boolean isLooping) {
        if (mMediaPlayer != null) {
            mMediaPlayer.setLooping(isLooping);
        }
    }

    public void unMute() {
        if (mAudioManager != null && mMediaPlayer != null) {
            int max = 100;
            int audioVolume = 100;
            double numerator = max - audioVolume > 0 ? Math.log(max - audioVolume) : 0;
            float volume = (float) (1 - (numerator / Math.log(max)));
            mMediaPlayer.setVolume(volume, volume);
            mSoundMute = false;
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        synchronized (TextureVideoView.class) {
            switch (msg.what) {

                case MSG_START:
                    if (SHOW_LOGS) Log.i(TAG, "<< handleMessage init");
                    openMediaPlayer();
                    if (SHOW_LOGS) Log.i(TAG, ">> handleMessage init");
                    break;


                case MSG_PAUSE:
                    if (SHOW_LOGS) Log.i(TAG, "<< handleMessage pause");
                    if (mMediaPlayer != null) {
                        mMediaPlayer.pause();
                        mTargetState = STATE_PAUSED;
                    }
                    mCurrentState = STATE_PAUSED;
                    if (SHOW_LOGS) Log.i(TAG, ">> handleMessage pause");
                    break;

                case MSG_BUFFERING_PAUSE:
                    if (SHOW_LOGS) Log.i(TAG, "<< handleMessage buffering pause");
                    if (mMediaPlayer != null) {
                        mMediaPlayer.pause();
                        mTargetState = STATE_BUFFERING_PAUSED;
                    }
                    mCurrentState = STATE_BUFFERING_PAUSED;
                    if (SHOW_LOGS) Log.i(TAG, ">> handleMessage buffering pause");
                    break;

                case MSG_STOP:
                    if (SHOW_LOGS) Log.i(TAG, "<< handleMessage stop");
                    if (mMediaPlayer != null) {
                        mMediaPlayer.stop();
                    }
                    if (SHOW_LOGS) Log.i(TAG, ">> handleMessage stop");
                    break;

                case MSG_RELEASE:
                    if (SHOW_LOGS) Log.i(TAG, "<< handleMessage release");
//                    release(true);
                    if (SHOW_LOGS) Log.i(TAG, ">> handleMessage release");
                    break;

                case MSG_RESUME:
                    if (SHOW_LOGS) Log.i(TAG, "<< handleMessage resume");
                    if (mMediaPlayer != null) {
                        mMediaPlayer.start();
                    }
                    mCurrentState = STATE_PLAYING;
                    if (SHOW_LOGS) Log.i(TAG, ">> handleMessage resume");
                    break;

                case MSG_BUFFERING_RESUME:
                    if (SHOW_LOGS) Log.i(TAG, "<< handleMessage resume");
                    if (mMediaPlayer != null) {
                        mMediaPlayer.start();
                    }
                    mCurrentState = STATE_BUFFERING_PLAYING;
                    if (SHOW_LOGS) Log.i(TAG, ">> handleMessage resume");
                    break;

            }
        }
        return true;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        boolean isInEditMode = isInEditMode();
        if (SHOW_LOGS) Log.v(TAG, ">> onAttachedToWindow " + isInEditMode);
        if (!isInEditMode) {
            if (sThread == null) {
                sThread = new HandlerThread("VideoPlayThread");
                sThread.start();
            }

            if (mHandler == null) {
                mHandler = new Handler();
            }

            if (mVideoHandler == null) {
                mVideoHandler = new Handler(sThread.getLooper(), this);
            }
        }

        if (SHOW_LOGS) Log.v(TAG, "<< onAttachedToWindow");

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        boolean isInEditMode = isInEditMode();

        if (SHOW_LOGS) Log.v(TAG, ">> onDetachedFromWindow, isInEditMode " + isInEditMode);
        if (!isInEditMode) {
            sThread.quit();
            sThread = null;
        }
        if (SHOW_LOGS) Log.v(TAG, "<< onDetachedFromWindow");
    }

    private boolean isInPlaybackState() {
        return (mMediaPlayer != null &&
                mCurrentState != STATE_ERROR &&
                mCurrentState != STATE_IDLE &&
                mCurrentState != STATE_PREPARING);
    }


    @Override
    public void start(long position) {
        start();
    }

    @Override
    public void resume() {
        if (mCurrentState == STATE_PAUSED) {
            mVideoHandler.obtainMessage(MSG_RESUME).sendToTarget();
        } else if (mCurrentState == STATE_BUFFERING_PAUSED) {
            mVideoHandler.obtainMessage(MSG_BUFFERING_RESUME).sendToTarget();
        } else if (mCurrentState == STATE_COMPLETED || mCurrentState == STATE_ERROR) {
            mMediaPlayer.reset();
            mVideoHandler.obtainMessage(MSG_START).sendToTarget();
        } else {
            if (SHOW_LOGS) Log.v(TAG, "resume error -1");
        }
    }

    @Override
    public void pause() {
        if (isPlaying() && mCurrentState == STATE_PLAYING) {
            mVideoHandler.obtainMessage(MSG_PAUSE).sendToTarget();
        }

        if (mCurrentState == STATE_BUFFERING_PLAYING) {
            mVideoHandler.obtainMessage(MSG_BUFFERING_PAUSE).sendToTarget();
        }
    }

    @Override
    public void seekTo(long pos) {
        if (mMediaPlayer != null) {
            mMediaPlayer.seekTo((int) pos);
        }
    }

    @Override
    public void setVolume(int volume) {
        if (mAudioManager != null) {
            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
        }
    }

    @Override
    public void setSpeed(float speed) {

    }

    @Override
    public void continueFromLastPosition(boolean continueFromLastPosition) {
        this.continueFromLastPosition = continueFromLastPosition;
    }

    @Override
    public boolean isIdle() {
        return mCurrentState == STATE_IDLE;
    }

    @Override
    public boolean isPreparing() {
        return mCurrentState == STATE_PREPARING;
    }

    @Override
    public boolean isPrepared() {
        return mCurrentState == STATE_PREPARED;
    }

    @Override
    public boolean isBufferingPlaying() {
        return mCurrentState == STATE_BUFFERING_PLAYING;
    }

    @Override
    public boolean isBufferingPaused() {
        return mCurrentState == STATE_BUFFERING_PAUSED;
    }

    @Override
    public boolean isPlaying() {
        return isInPlaybackState() && mMediaPlayer.isPlaying();
    }

    @Override
    public boolean isPaused() {
        return mCurrentState == STATE_PAUSED && !mMediaPlayer.isPlaying();
    }

    @Override
    public boolean isError() {
        return mCurrentState == STATE_ERROR;
    }

    @Override
    public boolean isCompleted() {
        return mCurrentState == STATE_COMPLETED;
    }

    @Override
    public boolean isFullScreen() {
        return false;
    }

    @Override
    public boolean isTinyWindow() {
        return false;
    }

    @Override
    public boolean isNormal() {
        return false;
    }

    @Override
    public int getMaxVolume() {
        if (mAudioManager != null) {
            return mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        }
        return 0;
    }

    @Override
    public int getVolume() {
        if (mAudioManager != null) {
            return mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        }
        return 0;
    }

    @Override
    public long getDuration() {
        return mMediaPlayer != null ? mMediaPlayer.getDuration() : 0;
    }

    @Override
    public long getCurrentPosition() {
        return mMediaPlayer != null ? mMediaPlayer.getCurrentPosition() : 0;
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public float getSpeed(float speed) {
        return 0;
    }

    @Override
    public long getTcpSpeed() {
        return 0;
    }

    @Override
    public void enterFullScreen() {

    }

    @Override
    public boolean exitFullScreen() {
        return false;
    }

    @Override
    public void enterTinyWindow() {

    }

    @Override
    public boolean exitTinyWindow() {
        return false;
    }

    @Override
    public void resetVideoPlayer() {
        if (mAudioManager != null) {
            mAudioManager.abandonAudioFocus(null);
            mAudioManager = null;
        }
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
        mContainer.removeView(mTextureView);
        if (mSurface != null) {
            mSurface.release();
            mSurface = null;
        }
        if (mSurfaceTexture != null) {
            mSurfaceTexture.release();
            mSurfaceTexture = null;
        }
        mCurrentState = STATE_IDLE;
    }

    @Override
    public void release() {

        resetVideoPlayer();

        Runtime.getRuntime().gc();
    }


    //********************SurfaceTexture callabck start **********************************//

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        if (mSurfaceTexture == null) {
            if (SHOW_LOGS) Log.i(TAG, "onSurfaceTextureAvailable start");
            mSurfaceTexture = surfaceTexture;
            openMediaPlayer();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                mTextureView.setSurfaceTexture(mSurfaceTexture);
            }
            if (SHOW_LOGS) Log.i(TAG, "onSurfaceTextureAvailable setsurfacetexture");
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return mSurfaceTexture == null;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

    }

    //********************SurfaceTexture callabck end **********************************//


    //******************** MediaPlayer start **********************************//


    @Override
    public void onCompletion(final MediaPlayer mp) {
        mCurrentState = STATE_COMPLETED;
        mTargetState = STATE_COMPLETED;
        mContainer.setKeepScreenOn(false);
        if (mMediaPlayerCallback != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (mMediaPlayerCallback != null) {
                        mMediaPlayerCallback.onCompletion(mp);
                    }
                }
            });
        }
    }

    @Override
    public boolean onError(final MediaPlayer mp, final int what, final int extra) {
        if (SHOW_LOGS)
            Log.e(TAG, "onError() called with " + "mp = [" + mp + "], what = [" + what + "], extra = [" + extra + "]");
        mCurrentState = STATE_ERROR;
        mTargetState = STATE_ERROR;
        if (mMediaPlayerCallback != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (mMediaPlayerCallback != null) {
                        mMediaPlayerCallback.onError(mp, what, extra);
                    }
                }
            });
        }
        return true;
    }

    @Override
    public void onPrepared(final MediaPlayer mp) {
        if (SHOW_LOGS) Log.i(TAG, "onPrepared " + mUri.toString());
        if (mTargetState != STATE_PREPARING || mCurrentState != STATE_PREPARING) {
            return;
        }

        mCurrentState = STATE_PREPARED;

        if (isInPlaybackState()) {
            mMediaPlayer.start();
            mCurrentState = STATE_PLAYING;
            mTargetState = STATE_PLAYING;
        }

        if (mMediaPlayerCallback != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (mMediaPlayerCallback != null) {
                        mMediaPlayerCallback.onPrepared(mp);
                    }
                }
            });
        }
    }

    @Override
    public void onVideoSizeChanged(final MediaPlayer mp, final int width, final int height) {
        scaleVideoSize(width, height);
        if (mMediaPlayerCallback != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (mMediaPlayerCallback != null) {
                        mMediaPlayerCallback.onVideoSizeChanged(mp, width, height);
                    }
                }
            });
        }
    }

    @Override
    public void onBufferingUpdate(final MediaPlayer mp, final int percent) {
        if (mMediaPlayerCallback != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (mMediaPlayerCallback != null) {
                        mMediaPlayerCallback.onBufferingUpdate(mp, percent);
                    }
                }
            });
        }
    }

    @Override
    public boolean onInfo(final MediaPlayer mp, final int what, final int extra) {

        if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
            mCurrentState = STATE_PLAYING;
        } else if (what == MediaPlayer.MEDIA_INFO_BUFFERING_START) {
            if (mCurrentState == STATE_PAUSED || mCurrentState == STATE_BUFFERING_PAUSED) {
                mCurrentState = STATE_BUFFERING_PAUSED;
                Log.d(TAG, "onInfo() called with MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
            } else {
                mCurrentState = STATE_BUFFERING_PLAYING;
                Log.d(TAG, "onInfo() called with MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
            }
        } else if (what == MediaPlayer.MEDIA_INFO_BUFFERING_END) {
            if (mCurrentState == STATE_BUFFERING_PLAYING) {
                mCurrentState = STATE_PLAYING;
//                mController.onPlayStateChanged(mCurrentState);
                Log.e(TAG, "onInfo() called with MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
            }
            if (mCurrentState == STATE_BUFFERING_PAUSED) {
                mCurrentState = STATE_PAUSED;
//                mController.onPlayStateChanged(mCurrentState);
                Log.d(TAG, "onInfo() called with MEDIA_INFO_BUFFERING_END： STATE_PAUSED");

            }
        }


        if (mMediaPlayerCallback != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (mMediaPlayerCallback != null) {
                        mMediaPlayerCallback.onInfo(mp, what, extra);
                    }
                }
            });
        }
        return true;
    }
    //******************** MediaPlayer end **********************************//


    //******************** MediaPlayerCallback **********************************//
    public interface MediaPlayerCallback {

        void onPrepared(MediaPlayer mp);

        void onCompletion(MediaPlayer mp);

        void onBufferingUpdate(MediaPlayer mp, int percent);

        void onVideoSizeChanged(MediaPlayer mp, int width, int height);

        boolean onInfo(MediaPlayer mp, int what, int extra);

        boolean onError(MediaPlayer mp, int what, int extra);
    }

}
