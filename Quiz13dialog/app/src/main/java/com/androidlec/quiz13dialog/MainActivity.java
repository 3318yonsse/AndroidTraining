package com.androidlec.quiz13dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int num1;
    int num2;
    String mul = "곱셈";
    String add = "덧셈";
    int resultNum;
    String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //------ Step 1 -------//
            // 첫번째 다이얼로그 //
            findViewById(R.id.callButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("질문")
                            .setMessage("좌변을 선택 하십시오")
                            // mclick으로 보내줌
                            .setPositiveButton("3", mClick)
                            .setNegativeButton("4", mClick)
                            .setCancelable(false)
                            .show();
            //------ Step 1! -------//
                }
            });
    }

    //------ Step 2 -------//
    // if , else로 조건(BUTTON_POSITIVE) 마다 값을 다르게줌
    DialogInterface.OnClickListener mClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                    num1=3;
             }else {
                    num1=4;
            }
            // mClick2 onclick으로 다이얼로그를 보냄.
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문")
                    .setMessage("우변을 선택 하십시오")
                    .setPositiveButton("6", mClick2)
                    .setNegativeButton("5", mClick2)
                    .setCancelable(false)
                    .show();
    //------ Step 2! -------//
            }

    };

    //------ Step 3 -------//
    DialogInterface.OnClickListener mClick2 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                num2=6;
            }else {
                num2=5;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문")
                    .setMessage("어떤 연산을 하시겠습니까?")
                    .setPositiveButton(mul, mClick3)
                    .setNegativeButton(add, mClick3)
                    .setCancelable(false)
                    .show();
    //------ Step 3! -------//
        }
    };

    //------ Step 4 -------//
    // 조건마다 다르게 받은 변수로 연산하여 setText로 보내줌!
    DialogInterface.OnClickListener mClick3 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                resultNum = num1 * num2;
            } else {
                resultNum = num1 + num2;
            }
            TextView text = findViewById(R.id.text);
            text.setText("연산결과 : " + resultNum);
    //------ Step 4! -------//
        }
    };






} //-------------------
