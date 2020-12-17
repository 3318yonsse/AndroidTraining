package com.androidlec.selectdialog3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 체크박스 - 초기값은 false로 선택 안된상태!
    boolean[] mSelect = {false, false, false, false};

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
                        .setMultiChoiceItems(R.array.foods, mSelect,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        mSelect[which] = isChecked;
                                    }
                                }


                        )
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String[] foods = getResources().getStringArray(R.array.foods);
                                TextView text = findViewById(R.id.text1);
                                String result = "선택한 음식은 = ";
                                for (int i = 0; i < mSelect.length; i++) {
                                    if (mSelect[i]) {
                                        result += foods[i] + " ";
                                    }
                                }
                                text.setText(result);
                            }

                        })
                        .setNegativeButton("취소", null)
                        .show();

            }
        });
    }
}