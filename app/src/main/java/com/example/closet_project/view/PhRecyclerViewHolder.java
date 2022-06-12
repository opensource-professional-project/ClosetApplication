package com.example.closet_project.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.closet_project.R;

import java.util.ArrayList;

public class PhRecyclerViewHolder extends RecyclerView.ViewHolder {
    public Button button;
    public TextView tvName;
    public ImageView ivIcon;
    public static int[] voteCount = {800,1,899,100,101,500,900,15,50,400,20,300,700,8,64,78};

    public PhRecyclerViewHolder(View a_itemView) {
        super(a_itemView);

        button = a_itemView.findViewById(R.id.button);
        ivIcon = a_itemView.findViewById(R.id.iv_icon);
        tvName = a_itemView.findViewById(R.id.tv_name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = getAdapterPosition();
                if(pos != RecyclerView.NO_POSITION)
                {
                    voteCount[getAdapterPosition()]++;
                    Log.d("Recyclerview","position= " + voteCount[getAdapterPosition()]);
                }
            }
        });

    }
}

