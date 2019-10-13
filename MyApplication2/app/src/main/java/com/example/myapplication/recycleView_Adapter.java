package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class recycleView_Adapter extends RecyclerView.Adapter<recycleView_Adapter.ViewHolder> {
    private final String[] mainTitleArray;
    private final String[] subTitleArray;
    private final Integer[] imgArray;


    public recycleView_Adapter(String[] mainTitleArray, String[] subTitleArray, Integer[] imgArray) {
        this.mainTitleArray = mainTitleArray;
        this.subTitleArray = subTitleArray;
        this.imgArray = imgArray;
    }


    @Override
    public recycleView_Adapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View convertView=inflater.inflate(R.layout.customlistview_ui,parent,false);
        ViewHolder viewHolder=new ViewHolder(convertView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.maintitle.setText(mainTitleArray[position]);
        holder.subtitle.setText(subTitleArray[position]);
        holder.image.setImageResource(imgArray[position]);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"main title is"+mainTitleArray[position],Toast.LENGTH_SHORT).show();
            }
        });
        //Toast.makeText(recycleView_Adapter.th,mainTitleArray[position].toString(),Toast.LENGTH_SHORT).show();
    }



    @Override
    public int getItemCount() {
        return 15;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView maintitle;
        public TextView subtitle;

        public ImageView image;
        public LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.maintitle = itemView.findViewById(R.id.txt1C);
            this.subtitle = itemView.findViewById(R.id.txt2C);
            this.image = itemView.findViewById(R.id.imgC);
            layout=itemView.findViewById(R.id.linearCL);
        }
    }
}
