package com.androidlec.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 안드로이드처럼 띄우는 방법과 스윙처럼 띄우는 방법 2가지가 있음 //

        //------- Step 1 -------//
        findViewById(R.id.callButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder bld = new AlertDialog.Builder(MainActivity.this);
                bld.setTitle("알립니다");
                bld.setMessage("대화 상자를 열었습니다 \n 감사합니다"  );
                bld.setIcon(R.mipmap.testicon);
                bld.show();

            }
        });



    }
}   //----------------------------------------