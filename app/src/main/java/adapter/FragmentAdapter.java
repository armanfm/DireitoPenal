package com.example.direitopenal;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.direitopenal.CulpaFragment;
import com.example.direitopenal.DireitoListFragment;
import com.example.direitopenal.ExcludenteFragment;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    DireitoListFragment dlf;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        dlf = new DireitoListFragment();

    }


    @Override
    public Fragment getItem(int i) {


        switch (i) {
            case 1:
                return new CulpaFragment();
            case 2:
                return new ExcludenteFragment();


        }


        return dlf;
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


