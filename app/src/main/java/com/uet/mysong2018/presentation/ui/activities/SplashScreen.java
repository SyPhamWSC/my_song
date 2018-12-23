package com.uet.mysong2018.presentation.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.ldoublem.loadingviewlib.LVCircularCD;
import com.uet.mysong2018.BaseActivity;
import com.uet.mysong2018.MainActivity;
import com.uet.mysong2018.R;
import com.uet.mysong2018.common.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends BaseActivity {

    @BindView(R.id.anim)
    LVCircularCD lvCircularCD;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Utils.getInstance().init(getApplicationContext());

        Utils.getInstance().setColorStatusBar(this,
                ContextCompat.getColor(this, R.color.color_gray_status_bar));

        ButterKnife.bind(this);

//        lvCircularCD.setViewColor(R.color.anim_color);

        lvCircularCD.startAnim();

        new Thread(() -> {
            try {
                Thread.sleep(3000);

                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                SplashScreen.this.finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
