package com.android.bmi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CalorieActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    int mSelect = 0;
    TextView Height;
    int normal = 21;
    Button button;
    TextView tvheight;
    TextView tvweight;
    double weight;

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
                                String[] act = getResources().getStringArray(R.array.act);
                                TextView text = findViewById(R.id.result1);
                                double result = Integer.parseInt(act[mSelect])*weight;
                                String re = Double.toString(result).substring(0,7);
                                text.setText("일일 칼로리 요구량 : " + re);

                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
            }
        });


    }
}//--------------------