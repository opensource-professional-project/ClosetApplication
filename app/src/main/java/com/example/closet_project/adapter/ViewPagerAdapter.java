package com.example.closet_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.closet_project.B_ViewHolder;
import com.example.closet_project.C_ViewHolder;
import com.example.closet_project.Data_Type;
import com.example.closet_project.R;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<Data_Type> mdata;

    public ViewPagerAdapter(Context context, ArrayList<Data_Type> mdata){
        this.context = context;
        this.mdata = mdata;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case 1: {
                View view = inflater.inflate(R.layout.a_viewholder,parent,false);
            }
            case 2: {
                View view = inflater.inflate(R.layout.b_viewholder,parent,false);

                return  new B_ViewHolder(view,viewType);
            }
            case 3: {
                View view = inflater.inflate(R.layout.c_viewholder,parent,false);

                return  new C_ViewHolder(view,viewType);
            }
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }
    @Override
    public int getItemViewType(int position) {
        switch (mdata.get(position).getType()){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
        }
        return 1;
    }
}
