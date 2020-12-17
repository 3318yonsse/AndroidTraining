package com.android.bmi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class CalorieActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    int mSelect = 0;
    TextView Height;
    int normal = 21;
    Button button;
    TextView tvheight;
    TextView tvweight;
    double weight;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_calorie);
        Log.v("MainActivity TAG", "구간 1----------------");


        // XML 연결 //
        tvweight = findViewById(R.id.tv_weight);
        tvheight = findViewById(R.id.tv_height);
        button = findViewById(R.id.hb01);
        Log.v("MainActivity TAG", "구간 2----------------");
        // XML 연결 //



        // intent //
//        Intent intent = getIntent();
//        int height = intent.getIntExtra("height" , 0);
//        tvheight.setText(height);
        // intent //


        // intent 받기 전 예비 //






        //--------------------------------------------------------------------------//
        //표준체중 구하기 버튼
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double heightextra = 1.75;
//              double heightValue = Double.parseDouble(String.valueOf(tvheight.getText()));



                Log.v("MainActivity TAG", "구간 3----------------");
                weight = (heightextra * heightextra)*normal;
                tvweight.setText("표중 체중은 " + (String.format("%.1f",weight)) + "입니다.");
                Log.v("MainActivity TAG", "구간 4----------------");
            }
        });










        // 필요 칼로리 버튼
        findViewById(R.id.callButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(CalorieActivity.this)
                        .setTitle("활동 정도를 입력하세요")
                        .setCancelable(false)
                        .setSingleChoiceItems(R.array.act, mSelect,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mSelect = which;
                                    }
                                }
                        )
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.v("aaa", Integer.toString(which));
                                String[] act = getResources().getStringArray(R.array.act);
                                TextView text = findViewById(R.id.result1);

                                switch (which){
                                    case -1:
                                        Log.v("aaa","1");
                                        result = 30 * weight;
                                        Log.v("aaa","2");
                                        break;
                                    case 0:
                                        Log.v("aaa","11112");
                                        result = 35 * weight;
                                        Log.v("aaa","dfffff2");
                                        break;
                                    case 1:
                                        result = 40 * weight;
                                        break;
                                }
                                Log.v("aaa","233");
                                String re = Double.toString(result).substring(0,7);
                                text.setText("일일 칼로리 요구량 : " + re);
                                Log.v("aaa","3444");

                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
            }
        });


    }
}//--------------------