package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    final Context context = this;
    public static final String third_data = "", dataResult = "";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
//        final Intent intent = getIntent();
//        String data = intent.getStringExtra(third_data);
//        TextView txt = (TextView) findViewById(R.id.txt1);
//        txt.setText(data);
//
//
//        String result = intent.getStringExtra(dataResult);
//        txt.setText(result);
        autoCompletetextView_Function();
        createAlertDialog();

        String[] maintitleList = {
                "Title 1", "Title 2",
                "Title 3", "Title 4",
                "Title 5",
        };

        String[] subtitleList = {
                "Sub Title 1", "Sub Title 2",
                "Sub Title 3", "Sub Title 4",
                "Sub Title 5",
        };

        Integer[] imgList = {R.mipmap.first, R.mipmap.secon, R.mipmap.third, R.mipmap.fourth, R.mipmap.fifth};
//     final  customlist_Adapter customAdapter = new customlist_Adapter(this, maintitleList, subtitleList, imgList);
         ListView lstV = (ListView) findViewById(R.id.customizeThird);
//    lstV.setAdapter(customAdapter);

        ModelClass obj1 = new ModelClass("Title 1", "Sub Title 1", R.mipmap.first);
        ModelClass obj2 = new ModelClass("Title 2", "Sub Title 2", R.mipmap.first);
        ModelClass obj3 = new ModelClass("Title 3", "Sub Title 3", R.mipmap.first);
        ModelClass obj4 = new ModelClass("Title 4", "Sub Title 4", R.mipmap.first);
        ModelClass obj5 = new ModelClass("Title 5", "Sub Title 5", R.mipmap.first);

        ArrayList<ModelClass> objList = new ArrayList<>();
        objList.add(obj1);
        objList.add(obj2);
        objList.add(obj3);
        objList.add(obj4);
        objList.add(obj5);

       final   customList_modelClass customadpater = new customList_modelClass(this, R.layout.customlistview_ui, objList);
        lstV.setAdapter(customadpater);
        lstV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //   TextView txt=(TextView)  view;
                Toast.makeText(ThirdActivity.this, customadpater.getItem(position).getMaintitle(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void autoCompletetextView_Function() {
        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.thrdAuto);
        TextView ShowText = (TextView) findViewById(R.id.txt1);
        StringBuilder addText = new StringBuilder();
        addText.append("Input value:").append("\n");
        for (String v : getResources().getStringArray(R.array.languagesList)) {
            addText.append(v).append(',');
        }
        ShowText.setText(addText);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.languagesList));
        auto.setThreshold(1); //default 2 (minimumm character on which data show)
        auto.setAdapter(ad);

    }

    public void goBack(View v) {
        Intent intent = new Intent(context, SecondActivity.class);

        intent.putExtra(dataResult, "from third activity for second");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void createAlertDialog() {
        builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.dialogMsg))
                .setCancelable(false)//.setCustomTitle(getResources().getString(R.string.FirstApp))
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(ThirdActivity.this, "you choose cancel action  for this alert box", Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ThirdActivity.this, "you choose positive action  for this alert box", Toast.LENGTH_SHORT).show();
            }
        });


        AlertDialog alert = builder.create();
        alert.setTitle(getResources().getString(R.string.dialogTitle));
        alert.show();

    }

    public void showDialog(View v) {
        createAlertDialog();
    }


}

