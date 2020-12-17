package com.androidlec.dialogbutton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //------ Step 1 -------//
                // 변수명 정하지않고 밑으로 . 찍어 이어가는법 //
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("알립니다")
                        .setMessage("대화 상자를 열었습니다.")
                        .setIcon(R.mipmap.ic_launcher)
                        // 닫기버튼을 눌렀을때만 dialogue 를 끄게함 //
                        .setCancelable(false)
                        .setPositiveButton("닫기",null)
                        .show();

                //------ Step 1! -------//
            }
        });
    }
}