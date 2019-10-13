package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {
    final Context context = this;
    final String[] lst = {"jb", "fre", "fer"};
     ArrayAdapter<String> adapter;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu,menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);



     final   Button btn = (Button) findViewById(R.id.btnSA);

        registerForContextMenu(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //   Toast.makeText(SecondActivity.this,"yes",Toast.LENGTH_LONG).show();
              //  Intent intent = new Intent(context, ThirdActivity.class);
              //  intent.putExtra(ThirdActivity.dataResult, "I am from second activity");
              //  startActivityForResult(intent, 100);
                PopupMenu popupMenu=new PopupMenu(context,btn);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());
                popupMenu.show();

            }
        });

       adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,//new String
                //  []{"jan","feb","march","april"}
                getResources().getStringArray(R.array.languagesList));
        //      data.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item); does not work
        final ListView lst = (ListView) findViewById(R.id.lstV);
        lst.setAdapter(adapter);

registerForContextMenu(lst);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //   TextView txtV=(TextView) view;
               PopupMenu popupMenu=new PopupMenu(context,view);
               popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());
           //    popupMenu.setOnMenuItemClickListener(new );
                Toast.makeText(SecondActivity.this, "element at " + position + " is " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
        Spinner sp = (Spinner) findViewById(R.id.spSecA);
        final ArrayAdapter<String> dataSp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String
                []{"jan", "feb", "march", "april"});
        dataSp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataSp);

//       sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//           @Override
//           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//               Toast.makeText(SecondActivity.this,"yes",Toast.LENGTH_SHORT).show();
//           }
//       });

        RadioGroup radioG = (RadioGroup) findViewById(R.id.radioGSec);
        //  final RadioButton radiobtn=(RadioButton) findViewById(radioG.getCheckedRadioButtonId());
        radioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioBtn = (RadioButton) findViewById(checkedId);
                Toast.makeText(SecondActivity.this, radioBtn.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //get menu item detail if clicked
        AdapterView.AdapterContextMenuInfo menuInfo=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int itemIndex=menuInfo.position;
        Toast.makeText(context,adapter.getItem(itemIndex),Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.sub1:
                Intent n=new Intent(context,ThirdActivity.class);
                startActivity(n);
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {


                String dt = data.getStringExtra(ThirdActivity.dataResult);
                //  TextView txt=(TextView) findViewById(R.id.secT);
                // txt.setText(dt);
                Toast.makeText(SecondActivity.this, dt, Toast.LENGTH_SHORT).show();

            }
        }
    }
}
