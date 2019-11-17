package com.example.leaninggroupapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    //이메일 인증을 누르면 자체적으로 중복 검사 후 중복이면 중복 메시지를 반환, 아니면 인증 진행
    //랜덤으로 6자리 난수를 생성해 보내주기, 인증
    //이 인증을 새 activity를 만들건지, 아니면 팝업창으로 진행할건지 상의 필요

    EditText authenticationEmail;
    Button authenticationButton;

    /*public void aithenticationEmail(){

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        authenticationEmail = (EditText)findViewById(R.id.input_email_authentication);
        authenticationButton = (Button)findViewById(R.id.input_email_authentication_button);
        authenticationButton.setOnClickListener(this);

    }

    public void onClick(View v){

    }
}
