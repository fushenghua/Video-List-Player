package com.mate.ad.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mate.ad.demo.adapter.CommonAdapter;
import com.mate.ad.demo.adapter.ShareAdapter;
import com.mate.ad.demo.bean.FamilyBean;

/**
 * create by fushenghua
 */
public class ShareFamilyActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private CommonAdapter<FamilyBean> mCommonAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps);
        initViews();
        initDatas();
        initToolBar();
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.family);
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
        mCommonAdapter = new ShareAdapter(R.layout.item_app, Utils.getApps());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mCommonAdapter);
        mCommonAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                FamilyBean item = mCommonAdapter.getItem(position);
                Uri uri = Uri.parse(item.url);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.share_recyclerView);
    }

}
