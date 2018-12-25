package com.uet.mysong2018.presentation.ui.fragments;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.uet.mysong2018.R;
import com.uet.mysong2018.common.Utils;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import co.mobiwise.library.MusicPlayerView;

public class PlayMusicFragment extends BaseFragment {

    @BindView(R.id.tv_name_song)
    TextView tvNameSong;

    @BindView(R.id.tv_name_singer)
    TextView tvNameSinger;

    @BindView(R.id.mpv)
    MusicPlayerView mvp;

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;

    @BindView(R.id.rl_heart)
    RelativeLayout rlHeart;

    @BindView(R.id.rl_next)
    RelativeLayout rlNext;

    @BindDrawable(R.drawable.vo_cung_phan_duy_anh)
    Drawable ivVocung;

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_playing_music, container, false);
        ButterKnife.bind(this, root);

        initView();
        setClickListener();

        return root;
    }

    private void setClickListener() {
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

        rlBack.setOnClickListener(view -> {

        });

        rlHeart.setOnClickListener(view -> {

        });

        rlNext.setOnClickListener(view -> {

        });
    }

    private void initView() {
        mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.vo_cung_phan_duy_anh);
        Log.e("PlayMusicFragment", "onCreate: time song: " + mediaPlayer.getDuration());

        Utils.getInstance().setColorStatusBar(getActivity(),
                ContextCompat.getColor(getActivity().getApplicationContext(), R.color.color_gray_status_bar));

        mvp.setCoverDrawable(ivVocung);
        mvp.setAutoProgress(true);
        mvp.setMax(mediaPlayer.getDuration() / 1000);

        Utils.getInstance().setFontScripti(tvNameSong);
        Utils.getInstance().setFontScripti(tvNameSinger);

    }
}
