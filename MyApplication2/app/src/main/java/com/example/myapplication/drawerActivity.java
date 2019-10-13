package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class drawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawermain_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.whatsapToolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
      //  drawer.openDrawer(GravityCompat.START);
        toggle.syncState();
//        FloatingActionButton btn=findViewById(R.id.floatingbtn);
//        registerForContextMenu(btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//openContextMenu(v);
//                Snackbar.make(v,"snackbar data",Snackbar.LENGTH_LONG).show();
//            }
//        });
        final Context context=this;

        TabLayout tabLayout=(TabLayout) findViewById(R.id.whatsapTablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Pening"));
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("hkh"));
        final ViewPager viewPager=(ViewPager) findViewById(R.id.whatsapViewPager);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager(),context,tabLayout.getTabCount());
           viewPager.setAdapter(adapter);
           viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
           tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
               @Override
               public void onTabSelected(TabLayout.Tab tab) {
                   viewPager.setCurrentItem(tab.getPosition());
               }

               @Override
               public void onTabUnselected(TabLayout.Tab tab) {

               }

               @Override
               public void onTabReselected(TabLayout.Tab tab) {

               }
           });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itm1:
                Toast.makeText(drawerActivity.this,"item1 selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.itm2:
                Toast.makeText(drawerActivity.this,"item2 selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
