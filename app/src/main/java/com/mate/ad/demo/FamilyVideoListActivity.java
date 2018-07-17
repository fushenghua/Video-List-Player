package com.mate.ad.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mate.ad.demo.adapter.VideoRecycleViewAdapter;
import com.mate.ad.demo.bean.VideoBean;
import com.mate.videolist.visibility.calculator.ListItemsVisibilityCalculator;
import com.mate.videolist.visibility.calculator.SingleListViewItemActiveCalculator;
import com.mate.videolist.visibility.scroll.RecyclerViewItemPositionGetter;
import com.mate.videolist.widget.VideoPlayerManager;

import java.util.ArrayList;
import java.util.List;

public class FamilyVideoListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private VideoRecycleViewAdapter mGuideAdapter;

    private int mScrollState;

    private List<VideoBean> mGuideDatas = new ArrayList<>();

    private LinearLayoutManager mLayoutManager;

    private ListItemsVisibilityCalculator mVideoVisibilityCalculator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_video);
        initViews();
        initDatas();
        initVideoView();
        initToolBar();
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.discover);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initDatas() {
        mGuideDatas.clear();
        mGuideDatas.addAll(Utils.getVideos());
        mGuideAdapter = new VideoRecycleViewAdapter(this, mGuideDatas, mRecyclerView);
        mRecyclerView.setAdapter(mGuideAdapter);
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.addItemDecoration(new SpacesItemDecoration(10));
    }


    private void initVideoView() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                mScrollState = newState;
                if (newState == RecyclerView.SCROLL_STATE_IDLE && mGuideAdapter.getItemCount() > 0) {
                    mVideoVisibilityCalculator.onScrollStateIdle();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                mVideoVisibilityCalculator.onScrolled(mScrollState);
            }
        });
        mRecyclerView.setHasFixedSize(true);
        mVideoVisibilityCalculator = new SingleListViewItemActiveCalculator(mGuideAdapter, new RecyclerViewItemPositionGetter(mLayoutManager, mRecyclerView));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VideoPlayerManager.getInstance().releaseVideoPlayer();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        VideoPlayerManager.getInstance().resumeVideoPlayer();
        mVideoVisibilityCalculator.onScrollStateIdle();
//        mVideoVisibilityCalculator.onScrolled(RecyclerView.SCROLL_STATE_IDLE);

    }

    @Override
    protected void onPause() {
        super.onPause();
//        VideoPlayerManager.getInstance().suspendVideoPlayer();
    }
}
