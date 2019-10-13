package com.example.myapplication;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class fragmentAdapter extends FragmentPagerAdapter {
    Context context;
    Integer totalTabs;

    public fragmentAdapter(FragmentManager fm, Context context, Integer totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                homeFragment home = new homeFragment();
                return home;
            case 1:
                sportFragment home1 = new sportFragment();
                return home1;
            case 2:
                movie home2 = new movie();
                return home2;

        }
        return null;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
