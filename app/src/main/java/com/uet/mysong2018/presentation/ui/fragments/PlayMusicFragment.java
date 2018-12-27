package com.uet.mysong2018.presentation.ui.fragments;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.taishi.library.Indicator;
import com.uet.mysong2018.R;
import com.uet.mysong2018.common.CommonVLs;
import com.uet.mysong2018.common.Utils;
import com.uet.mysong2018.domain.model.ItemSongModel;

import java.util.List;

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

    @BindView(R.id.iv_heart)
    ImageView heart;

    @BindView(R.id.rl_next)
    RelativeLayout rlNext;

    @BindView(R.id.indicator)
    Indicator indicator;

    @BindDrawable(R.drawable.vo_cung_phan_duy_anh)
    Drawable ivVocung;

    @BindViews({R.id.indicator, R.id.indicator2, R.id.indicator3})
    List<Indicator> indicatorList;

    MediaPlayer mediaPlayer;

    private boolean isFavorites;

    private int current = 0;

    private ItemSongModel modelSong;

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
                indicatorList.get(current).setVisibility(View.INVISIBLE);
            } else {
                Utils.setIsPlaying(true);
                mediaPlayer.start();
                indicatorList.get(current).setVisibility(View.VISIBLE);
                mvp.start();
            }
        });

        rlBack.setOnClickListener(view -> {
            switch (current) {
                case 0:
                    current = 2;
                    modelSong = CommonVLs.getListSong().get(2);
                    indicatorList.get(2).setVisibility(View.VISIBLE);
                    indicatorList.get(1).setVisibility(View.INVISIBLE);
                    indicatorList.get(0).setVisibility(View.INVISIBLE);
                    initMusicView(true, modelSong);

                    break;
                case 1:
                    current = 0;
                    modelSong = CommonVLs.getListSong().get(0);
                    indicatorList.get(0).setVisibility(View.VISIBLE);
                    indicatorList.get(2).setVisibility(View.INVISIBLE);
                    indicatorList.get(1).setVisibility(View.INVISIBLE);
                    initMusicView(true, modelSong);

                    break;
                case 2:
                    current = 1;
                    modelSong = CommonVLs.getListSong().get(1);
                    indicatorList.get(1).setVisibility(View.VISIBLE);
                    indicatorList.get(0).setVisibility(View.INVISIBLE);
                    indicatorList.get(2).setVisibility(View.INVISIBLE);
                    initMusicView(true, modelSong);

                    break;
            }
        });

        rlHeart.setOnClickListener(view -> {
            if (isFavorites) {
                heart.setImageDrawable(getActivity().getDrawable(R.drawable.heart));
                isFavorites = false;
                Toast.makeText(getContext(), "Xóa khỏi danh sách yêu thích", Toast.LENGTH_SHORT).show();
            } else {
                heart.setImageDrawable(getActivity().getDrawable(R.drawable.heart_2));
                isFavorites = true;
                Toast.makeText(getContext(), "Thêm vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
            }
        });

        rlNext.setOnClickListener(view -> {
            switch (current) {
                case 0:
                    current = 1;
                    modelSong = CommonVLs.getListSong().get(1);
                    indicatorList.get(1).setVisibility(View.VISIBLE);
                    indicatorList.get(0).setVisibility(View.INVISIBLE);
                    indicatorList.get(2).setVisibility(View.INVISIBLE);
                    initMusicView(true, modelSong);

                    break;
                case 1:
                    current = 2;
                    modelSong = CommonVLs.getListSong().get(2);
                    indicatorList.get(2).setVisibility(View.VISIBLE);
                    indicatorList.get(0).setVisibility(View.INVISIBLE);
                    indicatorList.get(1).setVisibility(View.INVISIBLE);
                    initMusicView(true, modelSong);

                    break;
                case 2:
                    current = 0;
                    modelSong = CommonVLs.getListSong().get(0);
                    indicatorList.get(0).setVisibility(View.VISIBLE);
                    indicatorList.get(1).setVisibility(View.INVISIBLE);
                    indicatorList.get(2).setVisibility(View.INVISIBLE);
                    initMusicView(true, modelSong);

                    break;
            }
        });
    }

    private void initView() {
        modelSong = CommonVLs.getListSong().get(0);
        Utils.getInstance().setFontScripti(tvNameSong);
        Utils.getInstance().setFontScripti(tvNameSinger);
        initMusicView(false, modelSong);

        Utils.getInstance().setColorStatusBar(getActivity(),
                ContextCompat.getColor(getActivity().getApplicationContext(), R.color.color_gray_status_bar));


    }

    private void initMusicView(boolean startPlaySong, ItemSongModel songModel) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        Uri uriMp3 = Uri.parse("android.resource://com.uet.mysong2018/raw/" + songModel.getNameSongRaw());
//        mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.vo_cung_phan_duy_anh);
        mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(), uriMp3);
        Log.e("PlayMusicFragment", "onCreate: time song: " + mediaPlayer.getDuration());

        Drawable drawable = Utils.getInstance().getDrawableByName(modelSong.getNameImage());
//        mvp.setCoverDrawable(ivVocung);
        mvp.setProgress(0);
        mvp.setCoverDrawable(drawable);
        mvp.setAutoProgress(true);
        mvp.setMax(mediaPlayer.getDuration() / 1000);

        if (startPlaySong) {
            mvp.start();
            mediaPlayer.start();
            Utils.setIsPlaying(true);
            indicatorList.get(current).setVisibility(View.VISIBLE);
        } else indicatorList.get(current).setVisibility(View.INVISIBLE);

        tvNameSinger.setText(modelSong.getNameSinger());
        tvNameSong.setText(modelSong.getNameSong());


    }
}
