package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class alikeWhatsapMain extends AppCompatActivity {
    final Context context=this;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);//super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alikewhatsap_layout);
        Toolbar toolbar=(Toolbar) findViewById(R.id.whatsapToolbar);
        setSupportActionBar(toolbar);

//        TabLayout tabLayout=(TabLayout) findViewById(R.id.whatsapTablayout);
//        tabLayout.addTab(tabLayout.newTab().setText("Pending"));
//        tabLayout.addTab(tabLayout.newTab().setText("Visited"));
//        tabLayout.addTab(tabLayout.newTab().setText("Prodcutive"));
//        final ViewPager viewPager=(ViewPager) findViewById(R.id.whatsapViewPager);
//        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),context,tabLayout.getTabCount());
//        viewPager.setAdapter(pagerAdapter);
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//
  }



}
