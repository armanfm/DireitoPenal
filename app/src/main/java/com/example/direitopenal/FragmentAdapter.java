package com.example.direitopenal;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {


    public FragmentAdapter(FragmentManager fm, Lifecycle lifecycle) {
        super(fm);
    }

    public FragmentAdapter(Object supportFragmentManager) {
        super((FragmentManager) supportFragmentManager);
    }


    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 1:
                return new CulpaFragment();
            case 2:
                return new ExcludenteFragment();


        }


        return new DireitoListFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 1:
                return "Dolo e Culpa";
            case 2:
                return "Excludente do Dever Legal";
        }

            return "Tentativa e Consumação";
        }


    }


