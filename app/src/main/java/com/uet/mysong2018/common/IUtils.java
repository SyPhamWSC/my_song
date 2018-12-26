package com.uet.mysong2018.common;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.uet.mysong2018.domain.model.ItemSongModel;

import java.util.List;

public interface IUtils {
    void setColorStatusBar(Activity activity, int color);
    Drawable getDrawableByName(String name);
    List<ItemSongModel> searchSong(String query);
}
