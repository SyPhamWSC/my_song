package com.uet.mysong2018.presentation.ui.activities;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.uet.mysong2018.BaseActivity;
import com.uet.mysong2018.R;
import com.uet.mysong2018.common.Utils;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.mobiwise.library.MusicPlayerView;

public class NowPlayingActivity extends BaseActivity {

    public static final String TAG = "NowPlayingActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        ButterKnife.bind(this);


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
