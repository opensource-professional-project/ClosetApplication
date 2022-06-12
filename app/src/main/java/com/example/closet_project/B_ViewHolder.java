package com.example.closet_project;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.closet_project.activity.BasicActivity;

public class B_ViewHolder extends RecyclerView.ViewHolder{
    int b;
    public B_ViewHolder(@NonNull View itemView , int b){
        super(itemView);

        this.b = b;
    }
}
