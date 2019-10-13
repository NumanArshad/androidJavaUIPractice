package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class fragmentPagerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout_withfragment);
        final ViewPager viewPager=(ViewPager) findViewById(R.id.viewPager);
        TabLayout tabeLayout=(TabLayout) findViewById(R.id.tabLayout);
        tabeLayout.addTab(tabeLayout.newTab().setText("Home"));
        tabeLayout.addTab(tabeLayout.newTab().setText("Second"));
        tabeLayout.addTab(tabeLayout.newTab().setText("third tab"));
       final Context context=this;
        fragmentAdapter myAdapter=new fragmentAdapter(getSupportFragmentManager(),context,tabeLayout.getTabCount());
       viewPager.setAdapter(myAdapter);
    //    tabeLayout.setupWithViewPager(viewPager); //or below commented code
       viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabeLayout));
        tabeLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tab.getPosition()); //swipe functionality
//                switch (tab.getPosition()) {
//                    case 0:
//                        homeFragment fragment=new homeFragment();
//                        getSupportFragmentManager().beginTransaction().add(R.id.frm,fragment).commit();
//
//                    case 1:
//                    //    sportFragment home1 = new sportFragment();
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frm,new sportFragment()).commit();
//
//                    case 2:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frm,new movie()).commit();
//
//
//                }

            }
//
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
