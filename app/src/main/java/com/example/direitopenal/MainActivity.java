package com.example.direitopenal;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

import android.app.Activity;
import android.content.Intent;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  implements AoClicarDireito {

    TabLayout mTabLayout;
    ViewPager mPager;
    FragmentAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        





        mTabLayout = findViewById(R.id.tab_layout);
        mPager = findViewById(R.id.viewPager);

        FragmentManager fm = getSupportFragmentManager();
        mPager = (ViewPager)findViewById(R.id.viewPager);
        mPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(mPager);
        mPager.getAdapter().notifyDataSetChanged();




    }

    @Override
    public void clicouDireito(Direito direito) {
        Intent it = new Intent(this, DireitoDetalheActivity.class);
        it.putExtra(DireitoDetalheActivity.EXTRA_DIREITO, direito);
        startActivity(it);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {



        return true;
    }
}
