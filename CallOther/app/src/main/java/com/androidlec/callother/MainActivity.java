package com.androidlec.callother;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.web).setOnClickListener(mClickListener);
        findViewById(R.id.dial).setOnClickListener(mClickListener);
        findViewById(R.id.list).setOnClickListener(mClickListener);
    }

    //------ Step 1 -------//
    // Uri 링크 걸기 //
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                    // 해당 홈페이지로 넘어감
                case R.id.web :
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                    startActivity(intent);
                    break;
                    // 전화화면으로 넘어감
                case R.id.dial :
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-2222"));
                    startActivity(intent);
                    break;
                    // Activity를 불러옴!
                case R.id.list :
                    intent = new Intent(Intent.ACTION_MAIN);
                    intent.setComponent(new ComponentName("com.androidlec.quiz8","com.androidlec.quiz8.MainActivity"));
                    startActivity(intent);
                    break;


     //------ Step 1 -------//


            }
        }
    };

}