package com.uet.mysong2018.app;

import android.app.Application;

import com.uet.mysong2018.common.CommonVLs;
import com.uet.mysong2018.common.Utils;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Utils.getInstance().init(getApplicationContext());
        CommonVLs.initListSong();
    }
}
