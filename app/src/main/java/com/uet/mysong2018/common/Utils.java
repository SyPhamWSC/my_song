package com.uet.mysong2018.common;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;

import com.uet.mysong2018.domain.model.ItemSongModel;

import java.util.ArrayList;
import java.util.List;

public class Utils implements IUtils {
    private static Utils instance;
    private Context context;

    private static boolean isPlaying;

    private Utils() {

    }

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }

        return instance;
    }

    public static boolean isIsPlaying() {
        return isPlaying;
    }

    public static void setIsPlaying(boolean isPlaying) {
        Utils.isPlaying = isPlaying;
    }

    @Override
    public void setColorStatusBar(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            activity.getWindow().setStatusBarColor(color);
        }

    }

    public void init(Context applicationContext) {
        this.context = applicationContext;
    }

    public void setCustomFonts(String fontsName, TextView textView) {
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontsName + ".ttf");
        textView.setTypeface(custom_font);
    }

    public void setFontBrushsbi(TextView tv) {
        this.setCustomFonts("brushsbi", tv);
    }

    public void setFontScripti(TextView tv) {
        this.setCustomFonts("scripti", tv);
    }

    @Override
    public Drawable getDrawableByName(String name) {
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(name, "drawable",
                context.getPackageName());
        return resources.getDrawable(resourceId);
    }

    @Override
    public List<ItemSongModel> searchSong(String query) {
        List<ItemSongModel> result = new ArrayList<>();
        for (ItemSongModel songModel : CommonVLs.getListSong()) {
            if(songModel.getNameSong().toLowerCase().contains(query.toLowerCase())){
                result.add(songModel);
            }
        }
        return result;
    }
}
