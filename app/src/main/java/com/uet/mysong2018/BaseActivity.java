package com.uet.mysong2018;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;

    protected void enableToolBarIndicator() {
        toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
        }

    }

    protected void setToolBarTitle(String titleName) {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle(titleName);
        toolbar.setTitleTextColor(Color.WHITE);
    }
}
