package com.mate.ad.demo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mate.videolist.widget.VideoPlayerView;


public class SingleVideoActivity extends AppCompatActivity {

    public static final String TAG = SingleVideoActivity.class.getSimpleName();


    private ImageView mIconImage;
    private TextView mIconText, mTvBack;
    private TextView mAppDesc;
    private Button mTryButton;
    private LinearLayout mBackLayout;
    //    private VideoPlayerView mVideoView;
    private VideoPlayerView mVideoView2;
    private ImageView mVideoBg;
    private ImageView mVideoPause;

    private String appName;
    private String appDesc;
    private String gpUrl;
    private String videoUrl;
    private String iconUrl;
    private String videoBg;
    private String buttonText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_video);
        initView();
        initData();
        initToolBar();
    }

    private void initView() {
        mIconImage = findViewById(com.mate.ad.R.id.app_image);
        mIconText = findViewById(com.mate.ad.R.id.app_name);
        mAppDesc = findViewById(com.mate.ad.R.id.app_desc);
        mTryButton = findViewById(com.mate.ad.R.id.app_download);
        mVideoView2 = findViewById(com.mate.ad.R.id.videoView);
        mVideoBg = findViewById(com.mate.ad.R.id.video_bg);
        mVideoPause = findViewById(com.mate.ad.R.id.video_pause);
        mTryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(appName);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//这2行是设置返回按钮的
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void initData() {
        if (getIntent() == null || getIntent().getExtras() == null) return;
        appName = getIntent().getExtras().getString(GlobalConstant.NAME);
        appDesc = getIntent().getExtras().getString(GlobalConstant.DESCRIPTION);
        gpUrl = getIntent().getExtras().getString(GlobalConstant.GPURL);
        videoUrl = getIntent().getExtras().getString(GlobalConstant.VIDEOURL);
        iconUrl = getIntent().getExtras().getString(GlobalConstant.ICON);
        videoBg = getIntent().getExtras().getString(GlobalConstant.VIDEO_BAC);
        buttonText = getIntent().getExtras().getString(GlobalConstant.BUTTON_TEXT);

//        Glide.with(this).load(iconUrl).into(mIconImage);
        Glide.with(this).load(videoBg).into(mVideoBg);
        mIconText.setText(appName);
        mAppDesc.setText(appDesc);
        mTryButton.setText(buttonText);  //Try Now云端多语言
        playVideo();
    }


    private void playVideo() {
        if (TextUtils.isEmpty(videoUrl)) return;
        mVideoView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mVideoView2.isPlaying()) {
                    mVideoView2.pause();
                    mVideoPause.setVisibility(View.VISIBLE);
                    mVideoPause.setImageResource(com.mate.ad.R.drawable.video_pause);
                } else {
                    mVideoView2.resume();
                    mVideoPause.setVisibility(View.GONE);
                }
            }
        });
        mVideoView2.setMediaPlayerCallback(new VideoPlayerView.MediaPlayerCallback() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoBg.setVisibility(View.GONE);
                mVideoPause.setVisibility(View.GONE);
            }

            @Override
            public void onCompletion(MediaPlayer mp) {
                mVideoPause.setVisibility(View.VISIBLE);
                mVideoPause.setImageResource(com.mate.ad.R.drawable.video_start);
            }

            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {

            }

            @Override
            public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

            }

            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                return false;
            }

            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                return false;
            }
        });
        mVideoView2.setDataSource(videoUrl);
        mVideoView2.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVideoView2.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVideoView2.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView2.release();
    }
}
