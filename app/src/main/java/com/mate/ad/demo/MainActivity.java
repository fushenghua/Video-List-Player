package com.mate.ad.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    //    http:/api.m.mtime.cn/PageSubArea/TrailerList.api

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_recycleview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ShareFamilyActivity.class));
            }
        });
        findViewById(R.id.bt_listview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FamilyVideoListActivity.class));

            }
        });
        findViewById(R.id.bt_singleview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SingleVideoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra(GlobalConstant.DESCRIPTION, guideBean.description);
//                intent.putExtra(GlobalConstant.GPURL, guideBean.gpUrl);
//                intent.putExtra(GlobalConstant.NAME, guideBean.name);
                intent.putExtra(GlobalConstant.VIDEOURL, "http://vfx.mtime.cn/Video/2017/03/31/mp4/170331093811717750.mp4");
//                intent.putExtra(GlobalConstant.ICON, guideBean.icon);
//                intent.putExtra(GlobalConstant.VIDEO_BAC, guideBean.getImages().get(0).getUrl());
//                intent.putExtra(GlobalConstyant.BUTTON_TEXT, guideBean.getButton());
                startActivity(intent);
            }
        });

    }
}
