package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customlist_Adapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] mainTitleArray;
    private final String[] subTitleArray;
    private final Integer[] imgArray;

    public customlist_Adapter(Activity conext, String[] maintitleArray, String[] subtitleArray, Integer[] imageArray) {
        super(conext, R.layout.customlistview_ui, maintitleArray);
        this.context = conext;
        this.mainTitleArray = maintitleArray;
        this.subTitleArray = subtitleArray;
        this.imgArray = imageArray;
    }
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater inflator = context.getLayoutInflater();
        View rowView = inflator.inflate(R.layout.customlistview_ui, null, true);
        TextView main = (TextView) rowView.findViewById(R.id.txt1C);
        TextView sub = (TextView) rowView.findViewById(R.id.txt2C);
        ImageView img = (ImageView) rowView.findViewById(R.id.imgC);
        main.setText(this.mainTitleArray[position]);
        sub.setText((this.subTitleArray[position]));
        img.setImageResource(this.imgArray[position]);

        return rowView;
    }
}
