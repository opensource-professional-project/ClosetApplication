package com.example.closet_project;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class C_ViewHolder extends RecyclerView.ViewHolder {
    int c;
    TextView textView;
    public C_ViewHolder(@NonNull View itemView , int c){
        super(itemView);

        this.c = c;

        textView =itemView.findViewById(R.id.c_textview);
        textView.setText(String.valueOf(c));
    }
}
