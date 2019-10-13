package com.example.myapplication;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    Integer tabCount;
    Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context, Integer tabCount) {
        super(fm);
        this.tabCount = tabCount;
        this.context=context;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                homeFragment home=new homeFragment();
                return  home;
            case 1:
                fragment_RecyclerView fragment=new fragment_RecyclerView();
                return  fragment;
            case 2:
                movie m=new movie();
                return  m;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

