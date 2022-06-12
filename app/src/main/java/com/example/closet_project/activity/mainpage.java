package com.example.closet_project.activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;

import android.os.Build;
import android.util.Log;
import android.os.Bundle;
import android.widget.TextView;

import com.example.closet_project.Data_Type;
import com.example.closet_project.R;
import com.example.closet_project.adapter.ViewPagerAdapter;
import com.example.closet_project.fragment.CapFragment;
import com.example.closet_project.fragment.CodyFragment;
import com.example.closet_project.fragment.EtcFragment;
import com.example.closet_project.fragment.HomeFragment;
import com.example.closet_project.fragment.PantsFragment;
import com.example.closet_project.fragment.ShoesFragment;
import com.example.closet_project.fragment.TopFragment;
import com.example.closet_project.fragment.weekcodyFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.List;

public class mainpage extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;
    ArrayList<Data_Type>mdata;
    Context context;
    TabLayout navtab, topnavtab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        context = this;
        mdata = new ArrayList<>();

        navtab = findViewById(R.id.bot_tab);
        topnavtab = findViewById(R.id.top_tab);



        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser == null) {
            myStartActivity(SignUpActivity.class);
        } else {
            DocumentReference documentReference = FirebaseFirestore.getInstance().collection("users").document(firebaseUser.getUid());
            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document != null) {
                            if (document.exists()) {
                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            } else {
                                Log.d(TAG, "No such document");
                                myStartActivity(MemberInitActivity.class);
                            }
                        }
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });
            weekcodyFragment weekcodyfragment = new weekcodyFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, weekcodyfragment)
                    .commit();


            topnavtab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    if (tab.getPosition() == 0) {
                        weekcodyFragment weekcodyfragment = new weekcodyFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, weekcodyfragment)
                                .commit();
                    }
                    if (tab.getPosition() == 1) {
                        CodyFragment codyFragment = new CodyFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, codyFragment)
                                .commit();
                    }
                    if(tab.getPosition() == 2){
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, homeFragment)
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

    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivityForResult(intent, 1);
    }

}