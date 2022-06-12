package com.example.closet_project.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.closet_project.R;

import java.util.ArrayList;


public class RecylcerAdapter extends RecyclerView.Adapter<RecylcerAdapter.MyViewHolder> {

    String[] data1,data2;
    int[] images;
    Context context;
    public RecylcerAdapter(Context ct,String[]s1,String []s2,int[]img){
        context =ct;
        data1= s1;
        data2= s2;
        images=img;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_usedmarket,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textcell.setText("판매");
        holder.texttitle.setText(data1[position]);
        holder.textprice.setText(data2[position]);
        holder.imageView.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textcell,texttitle,textprice;
        ImageView imageView;
        CardView mainlayout;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            textprice = itemView.findViewById(R.id.price);
            textcell = itemView.findViewById(R.id.sell);
            texttitle = itemView.findViewById(R.id.titleTextnameview);
            imageView = itemView.findViewById(R.id.used_img);
            mainlayout = itemView.findViewById(R.id.mainlayout);
        }
    }
}
