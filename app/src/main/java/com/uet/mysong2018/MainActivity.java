package com.uet.mysong2018;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.chaychan.library.BottomBarLayout;
import com.uet.mysong2018.common.CommonVLs;
import com.uet.mysong2018.presentation.adapters.ViewPagerAdapterCustom;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vp_content)
    ViewPager vpContent;

    @BindView(R.id.bottom_bar)
    BottomBarLayout bottomBarLayout;

    @BindView(R.id.root_view)
    LinearLayout linearLayout;

    private PagerAdapter mPageAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        CommonVLs.setupUI(linearLayout, this);

        mPageAdapter = new ViewPagerAdapterCustom(getSupportFragmentManager());
        vpContent.setAdapter(mPageAdapter);

        bottomBarLayout.setViewPager(vpContent);
        bottomBarLayout.setSmoothScroll(false);
    }
}
