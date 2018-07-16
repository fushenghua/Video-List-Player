package com.mate.ad.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.mate.ad.demo.adapter.CommonAdapter;
import com.mate.ad.demo.adapter.ShareAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * create by fushenghua
 */
public class ShareFamilyActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayout mBack;
    private CommonAdapter commonAdapter;
    List<VideoBean> dates = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        initViews();
        initDatas();
    }

    private void initDatas() {
        dates = new ArrayList<>();
        VideoBean guidesBean = new VideoBean("You share", "", "");
//        guidesBean.setName("You share");
//        guidesBean.setDate("這是一個神奇的APP");
        for (int i = 0; i < 5; i++) {
            dates.add(guidesBean);
        }
        commonAdapter = new ShareAdapter(R.layout.holder_mate, dates);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(commonAdapter);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.share_recyclerView);
        mBack = findViewById(R.id.share_toolbar);
    }
}
