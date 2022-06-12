package com.example.closet_project;

import android.view.View;

public class PhRecyclerItem {
    private int imageResId;
    private String buttontext;
    private String strName;

    public PhRecyclerItem(int a_resId, String a_strbuttontext, String a_strName) {
        imageResId = a_resId;
        buttontext = a_strbuttontext;
        strName = a_strName;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return buttontext;
    }
    public String gettext() {
        return strName;
    }


}
