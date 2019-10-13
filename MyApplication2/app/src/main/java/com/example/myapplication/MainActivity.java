package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    final Context context = this;

    @Override
    //called when activity is created
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Log.d("msg","yes");
        Toast.makeText(MainActivity.this, "Yes onCreate()", Toast.LENGTH_LONG).show();

        Button btn = (Button) findViewById(R.id.btn);
        final TextView tx1 = (TextView) findViewById(R.id.txt1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(context,v);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==R.id.item1P){
                            Intent intent=new Intent(context,RecycleViewMain.class);
                            startActivity(intent);

                        }
                        return true;
                    }
                });
                popupMenu.show();
                Log.d("txtBefore", tx1.getText().toString());
                tx1.setText("after");
                Toast.makeText(MainActivity.this, "tx1 updated is" + tx1.getText().toString(), Toast.LENGTH_LONG).show();

            }
        });

        navigateSecondActivity();
        navigateThirdActivity();
    }


    public void navigateSecondActivity() {
        Button btn = (Button) findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void navigateThirdActivity() {
        Button btn1 = (Button) findViewById(R.id.btn3M);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Snackbar.make(v,"click me",Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(context, ThirdActivity.class);
                intent.putExtra(ThirdActivity.third_data, "data from main activity");
              startActivity(intent);
            }
        });
    }
    public void drawerActivity(View v){
        Intent intent=new Intent(context,drawerActivity.class);
        startActivity(intent);
    }

    @Override
    //called when activity is about to start
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "onStart()", Toast.LENGTH_LONG).show();
    }

    @Override
    //called when activity is visible to user
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "onResume()", Toast.LENGTH_LONG).show();

    }

    @Override
    //called when activity is not longer visible
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "onStop()", Toast.LENGTH_LONG).show();
    }

    @Override
    //called when another activity is taking focus
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "onPause()", Toast.LENGTH_LONG).show();
    }

    @Override
    //called just before  activity is destroyed
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "onDestroy()", Toast.LENGTH_LONG).show();
    }


}
