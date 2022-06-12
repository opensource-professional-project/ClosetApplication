package com.example.closet_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.closet_project.activity.LoginActivity;
import com.example.closet_project.activity.SignUpActivity;

public class SignLogin extends AppCompatActivity {
    Button tosign, tologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_login);

        tosign = findViewById(R.id.toSign);
        tologin = findViewById(R.id.toLogin);

        tosign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myStartActivity(SignUpActivity.class);
            }
        });

        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myStartActivity(LoginActivity.class);
            }
        });
    }


    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}