package com.uet.mysong2018.common;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

public class Utils implements IUtils {
    private static Utils instance;
    private Context context;
    private Utils() {

    }

    public static Utils getInstance() {
        if(instance==null){
            instance = new Utils();
        }

        return instance;
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
}
