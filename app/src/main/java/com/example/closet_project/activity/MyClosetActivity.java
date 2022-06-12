package com.example.closet_project.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.closet_project.R;
import com.example.closet_project.fragment.CapFragment;
import com.example.closet_project.fragment.EtcFragment;
import com.example.closet_project.fragment.HomeFragment;
import com.example.closet_project.fragment.PantsFragment;
import com.example.closet_project.fragment.ShoesFragment;
import com.example.closet_project.fragment.TopFragment;
import com.google.android.material.tabs.TabLayout;

public class MyClosetActivity extends BasicActivity {
    TabLayout navtab, topnavtab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_closet);
        navtab = findViewById(R.id.bot_tab);
        topnavtab = findViewById(R.id.top_tab);
        CapFragment capFragment = new CapFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, capFragment)
                .commit();

        topnavtab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    CapFragment capFragment = new CapFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, capFragment)
                            .commit();
                }
                if (tab.getPosition() == 1) {
                    TopFragment topFragment = new TopFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, topFragment)
                            .commit();
                }
                if(tab.getPosition() == 2){
                    PantsFragment pantsFragment = new PantsFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, pantsFragment)
                            .commit();
                }
                if(tab.getPosition() == 3){
                    ShoesFragment shoesFragment = new ShoesFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, shoesFragment)
                            .commit();
                }
                if (tab.getPosition() == 4) {
                    EtcFragment etcFragment = new EtcFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, etcFragment)
                            .commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
















        //맨밑 네비게이션 바 코드 시작
        navtab.selectTab(navtab.getTabAt(3));
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
        //코드 끝
    }


    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivityForResult(intent, 1);
    }
}