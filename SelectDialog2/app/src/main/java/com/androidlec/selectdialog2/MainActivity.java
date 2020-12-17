package com.androidlec.selectdialog2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 초기 값 (dialog defalut 선택값)
    int mSelect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.callButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("음식을 선택하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        // checkbox - multi(다중선택가능) //
                        // radiobutton - single//
                        .setSingleChoiceItems(R.array.foods, mSelect,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    // which(클릭한 위치)를 mSelect에 저장함.
                                    public void onClick(DialogInterface dialog, int which) {
                                        mSelect = which;
                                    }
                                }
                        )
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String[] foods = getResources().getStringArray(R.array.foods);
                                TextView text = findViewById(R.id.text1);
                                text.setText("선택한 음식 : " + foods[mSelect]);
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();

            }
        });
    }
}