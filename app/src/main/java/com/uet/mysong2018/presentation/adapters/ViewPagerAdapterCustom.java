package com.uet.mysong2018.presentation.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.uet.mysong2018.presentation.ui.fragments.BaseFragment;
import com.uet.mysong2018.presentation.ui.fragments.MeFragment;
import com.uet.mysong2018.presentation.ui.fragments.PlayMusicFragment;
import com.uet.mysong2018.presentation.ui.fragments.SearchFragment;

public class ViewPagerAdapterCustom extends FragmentPagerAdapter {
    private FragmentManager fragmentManager;

    private BaseFragment searchFragment;
    private BaseFragment playMusicFragment;
    private BaseFragment meFragment;

    public ViewPagerAdapterCustom(FragmentManager fm) {
        super(fm);
        this.fragmentManager = fm;
        searchFragment = new SearchFragment();
        playMusicFragment = new PlayMusicFragment();
        meFragment = new MeFragment();
    }

    @Override
    public Fragment getItem(int i) {
        BaseFragment fragment = null;
        switch (i) {
            case 0:
                fragment = searchFragment;
                break;

            case 1:
                fragment = playMusicFragment;
                break;

            case 2:
                fragment = meFragment;
                break;

            default:
                fragment = playMusicFragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
