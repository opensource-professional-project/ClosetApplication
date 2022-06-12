package com.example.closet_project.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.closet_project.R;
import com.example.closet_project.fragment.UserInfoFragment;
import com.google.android.material.tabs.TabLayout;

public class UserInfoActivity extends BasicActivity {
    TabLayout navtab;



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        navtab = findViewById(R.id.bot_tab);

        UserInfoFragment userInfoFragment = new UserInfoFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, userInfoFragment)
                .commit();



        navtab.selectTab(navtab.getTabAt(4));
        navtab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    Log.d("Log : ", "HOME");
                    myStartActivity(mainpage.class);
                }
                if (tab.getPosition() == 1) {
                    Log.d("Log : ", "HOME");
                    myStartActivity(MainActivity.class);
                }
                if(tab.getPosition() == 2){
                    myStartActivity(VoteActivity.class);
                }
                if(tab.getPosition() == 3){
                    myStartActivity(MyClosetActivity.class);
                }
                if (tab.getPosition() == 4) {
                    Log.d("Log : ", "aa");
                    myStartActivity(UserInfoActivity.class);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivityForResult(intent, 1);
    }
}