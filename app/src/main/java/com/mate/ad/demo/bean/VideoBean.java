package com.mate.ad.demo.bean;

import com.mate.ad.demo.adapter.VideoRecycleViewAdapter;

/**
 * create by fushenghua
 */
public class VideoBean {


    public String url;

    public String videoTitle;

    public String coverImg;

    public VideoBean(String videoUrl, String videoTitle, String coverImg) {
        this.url = videoUrl;
        this.videoTitle = videoTitle;
        this.coverImg = coverImg;
    }

    public int getType() {
        return VideoRecycleViewAdapter.TYPE_VIDEO;
    }
}
