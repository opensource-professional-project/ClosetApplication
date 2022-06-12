package com.example.closet_project.listener;

import com.example.closet_project.PostInfo;

public interface OnPostListener {
    void onDelete(PostInfo postInfo);
    void onModify();
}