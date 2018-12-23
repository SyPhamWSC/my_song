package com.uet.mysong2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uet.mysong2018.presentation.ui.activities.NowPlayingActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayer = findViewById(R.id.btn_start);

        btnPlayer.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, NowPlayingActivity.class)));
    }
}
