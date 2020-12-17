package com.androidlec.selectdialog1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------ Step 1 -------//
        // 첫번째 다이얼로그 //
        // values에 string-array를 만들어줌 //
        findViewById(R.id.callButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("음식을 선택하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        // values -> array 리스트를 받아옴.
                        .setItems(R.array.foods,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String[] foods = getResources().getStringArray(R.array.foods);
                                        TextView text = findViewById(R.id.text1);
                                        text.setText("선택한 음식은 : " + foods[which]);
                                    }
                                }
                        )
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                //------ Step 1! -------//
            }
        });
    }
} //---------