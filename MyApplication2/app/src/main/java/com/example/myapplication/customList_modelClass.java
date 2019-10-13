package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customList_modelClass extends ArrayAdapter<ModelClass> {

    private final Context context;

    public customList_modelClass(Context context, int resource, ArrayList<ModelClass> objects) {
        super(context, resource, objects);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.customlistview_ui, parent, false);


            TextView mainT = (TextView) convertView.findViewById(R.id.txt1C);
            TextView subT = (TextView) convertView.findViewById(R.id.txt2C);
            ImageView imgT = (ImageView) convertView.findViewById(R.id.imgC);

            String main = getItem(position).getMaintitle();
            String sub = getItem(position).getSubtitle();
            Integer img = getItem(position).getImg();

            mainT.setText(main);
            subT.setText(sub);
            imgT.setImageResource(img);
        }

        return convertView;

    }
}
