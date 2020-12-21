package com.androidlec.networkimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    String urlAddr = "http://192.168.0.89:8080/test/img_0214.jpg";
    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.btn);
        imageView = findViewById(R.id.imageView);


        button.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn :
                    // 생성자를 만듬,  imageView는 findViewById(R.id.imageView)와 연결된 것.
                    NetworkTask networkTask = new NetworkTask(MainActivity.this, urlAddr, imageView);
                    // 10초, execute는 클래스 상속자와 연결이 되어있어 사용가능.
                    networkTask.execute(100);
                    button.setText("Download Complete!");
                    break;
            }
        }
    };


//    public NetworkTask(Context context, String mAddr, ImageView imageView)











} //-----------------------------