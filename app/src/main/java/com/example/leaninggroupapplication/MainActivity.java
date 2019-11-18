package com.example.leaninggroupapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.AsyncTask;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity {

    LinearLayout LanguageFrame;
    LinearLayout LicenseFrame;
    LinearLayout ReadingFrame;
    LinearLayout MajoringFrame;
    LinearLayout HobbyFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼들을 정의
        Button LanguageButton = (Button) findViewById(R.id.LanguageButton);
        LanguageButton.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View view) {
                changeView(0);
            }
        });

        Button LicenseButton = (Button) findViewById(R.id.LicenseButton);
        LicenseButton.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View view) {
                changeView(1);
            }
        });

        Button ReadingButton = (Button) findViewById(R.id.ReadingButton);
        ReadingButton.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View view) {
                changeView(2);
            }
        });

        Button MajoringButton = (Button) findViewById(R.id.MajoringButton);
        MajoringButton.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View view) {
                changeView(3);
            }
        });

        Button HobbyButton = (Button) findViewById(R.id.HobbyButton);
        HobbyButton.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View view) {
                changeView(4);
            }
        });

        LanguageFrame = (LinearLayout) findViewById(R.id.LanguageFrame); //버튼을 클릭하면 각 버튼에 대한 프레임을 실행하기 위해 findView하고 하나의 프레임만 남아있게 제거하는 과정
        LicenseFrame = (LinearLayout) findViewById(R.id.LicenseFrame);
        ReadingFrame = (LinearLayout) findViewById(R.id.ReadingFrame);
        MajoringFrame = (LinearLayout) findViewById(R.id.MajoringFrame);
        HobbyFrame = (LinearLayout) findViewById(R.id.HobbyFrame);

        FrameLayout frame = (FrameLayout) findViewById(R.id.frame);

        frame.removeView(LicenseFrame);
        frame.removeView(ReadingFrame);
        frame.removeView(MajoringFrame);
        frame.removeView(HobbyFrame);

        //System.out.println("sdf");

        Button checkUserListButton = (Button) findViewById(R.id.checkUserListButton); //회원정보를 확인하기 위한 버튼
        checkUserListButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) { //유저리스트를 확인하기 위한 버튼을 클릭하면 백그라운드에서 실행
                new BackgroundTask().execute();
            }
        });

    }


    class BackgroundTask extends AsyncTask<Void, Void, String> { //모든 회원에 대한 정보를 가져오기 위한 쓰레드

        String target;

        @Override
        protected void onPreExecute() {
            //post.php는 파싱으로 가져올 웹페이지, 서버 페이지
            target = "http://39.127.82.121:80/post.php";
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {
                URL url = new URL(target);//URL 객체 생성성

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); //url을 이용해 웹 페이지에 연결
                InputStream inputStream = httpURLConnection.getInputStream();// 바이트 단위 입력 스트림 생성 소스
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)); //웹페이지 출력물을 버퍼로 받음(속도 문제)

                String temp;
                StringBuilder stringBuilder = new StringBuilder();

                while ((temp = bufferedReader.readLine()) != null) {
                    stringBuilder.append(temp + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim(); //앞뒤 공백 제거하고 스트링리턴

            } catch (Exception e) {
                e.printStackTrace();
            }

            String string = new String("여기서 널 리턴"); //파싱 테스트 구문
            return string;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            Intent intent = new Intent(MainActivity.this, testDBConnect.class);
            intent.putExtra("userList", result); //파싱한 값을 넘겨줌
            MainActivity.this.startActivity(intent); //testDBconnect 액티비티로 넘어감
        }
    }

    private void changeView(int index) { //버튼을 클릭함에 따라 프레임 뷰를 바꾸기 위함

        FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
        frame.removeViewAt(0);

        switch (index) {
            case 0:
                frame.addView(LanguageFrame);
                break;
            case 1:
                frame.addView(LicenseFrame);
                break;
            case 2:
                frame.addView(ReadingFrame);
                break;
            case 3:
                frame.addView(MajoringFrame);
                break;
            case 4:
                frame.addView(HobbyFrame);
                break;
        }
    }

}
