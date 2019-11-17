package com.example.leaninggroupapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class testDBConnect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dbconnect);
        TextView UserListView = (TextView)findViewById(R.id.userListView);

        Intent intent = getIntent();
        UserListView.setText(intent.getStringExtra("userList"));
    }
}
