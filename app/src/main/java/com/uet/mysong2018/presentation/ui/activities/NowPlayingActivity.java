package com.uet.mysong2018.presentation.ui.activities;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.nfc.Tag;
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

    public static final String TAG ="NowPlayingActivity";

    @BindView(R.id.tv_name_song)
    TextView tvNameSong;

    @BindView(R.id.tv_name_singer)
    TextView tvNameSinger;

    @BindView(R.id.mpv)
    MusicPlayerView mvp;

    @BindDrawable(R.drawable.vo_cung_phan_duy_anh)
    Drawable ivVocung;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        ButterKnife.bind(this);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.vo_cung_phan_duy_anh);
        Log.e(TAG, "onCreate: time song: " + mediaPlayer.getDuration() );
        initView();

        mvp.setOnClickListener(view -> {
            if (Utils.isIsPlaying()) {
                mvp.stop();
                Utils.setIsPlaying(false);
                mediaPlayer.pause();
            } else {
                Utils.setIsPlaying(true);
                mediaPlayer.start();
                mvp.start();
            }
        });


    }

    private void initView() {

        Utils.getInstance().setColorStatusBar(this,
                ContextCompat.getColor(this, R.color.color_gray_status_bar));
        enableToolBarIndicator();
        setToolBarTitle(getResources().getString(R.string.str_now_playing));

        mvp.setCoverDrawable(ivVocung);
        mvp.setAutoProgress(true);

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
