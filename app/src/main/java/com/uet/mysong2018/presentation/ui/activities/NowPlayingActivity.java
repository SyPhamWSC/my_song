package com.uet.mysong2018.presentation.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.MenuItem;

import com.uet.mysong2018.BaseActivity;
import com.uet.mysong2018.R;
import com.uet.mysong2018.common.Utils;

public class NowPlayingActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Utils.getInstance().setColorStatusBar(this,
                ContextCompat.getColor(this, R.color.color_gray_status_bar));
        enableToolBarIndicator();
        setToolBarTitle(getResources().getString(R.string.str_now_playing));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }

        return false;
    }
}
