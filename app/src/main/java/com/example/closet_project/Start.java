package com.example.closet_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.closet_project.activity.MainActivity;
import com.example.closet_project.activity.mainpage;

public class Start extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Handler handler = new Handler(){
            @SuppressLint("HandlerLeak")
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                startActivity(new Intent(Start.this, SignLogin.class)); //로고창 다음 activity는 이거로 조절 가능 로그인, 회원가입 , 로그인 & 회원가입페이지확인하고 싶으면 여기서 바꾸셈
                finish();
            }
        };

        handler.sendEmptyMessageDelayed(0,2000); // 3초후 화면 전환
    }
}