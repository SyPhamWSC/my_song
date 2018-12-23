package com.uet.mysong2018.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;

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
}
