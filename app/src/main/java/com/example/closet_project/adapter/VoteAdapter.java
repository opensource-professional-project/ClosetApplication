package com.example.closet_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.closet_project.PhRecyclerItem;
import com.example.closet_project.R;
import com.example.closet_project.view.PhRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class VoteAdapter extends RecyclerView.Adapter<PhRecyclerViewHolder> {
    private List<PhRecyclerItem> mItemList;

    public VoteAdapter(List<PhRecyclerItem> a_list) {
        mItemList = a_list;
    }

    @Override
    public PhRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int a_position) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.item_list, a_viewGroup, false);

        return new PhRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhRecyclerViewHolder a_viewHolder, int a_position) {
        final PhRecyclerItem item = mItemList.get(a_position);

        a_viewHolder.ivIcon.setImageResource(item.getImageResId());
        a_viewHolder.button.setText(item.getName());
        a_viewHolder.tvName.setText(item.gettext());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}

