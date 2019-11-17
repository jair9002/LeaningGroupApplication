package com.example.leaninggroupapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
    }

    public void onClick_Singin(View view){
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    public void onClick_FindEmail(View view){
        Intent intent = new Intent(this, SignInActivity.class); //find email activity 만들어야함
        startActivity(intent);
    }

    public void onClick_ChangePassword(View view){
        Intent intent = new Intent(this, SignInActivity.class); //find email activity 만들어야함
        startActivity(intent);
    }

    public void onClick_GoMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
