package com.androidlec.question1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int num1 = 3;
    int num2 = 4;
    int resultNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------ Step 1 ------//
        findViewById(R.id.callButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문")
                        .setMessage("어떤 연산을 하시겠습니까?")
                        .setPositiveButton("덧셈", mClick)
                        .setNegativeButton("곱셈", mClick)
                        .show();
                //------ Step 1! ------//
            }
        });
    }

        //------ Step 2 ------//
        //OnClickListener - DialogInterface
        DialogInterface.OnClickListener mClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    resultNum = num1 + num2;
                }else{
                    resultNum = num1 * num2;
                }
                TextView text = findViewById(R.id.text);
                text.setText("연산결과 : " + resultNum);
                //------ Step 2 ------//
            }
        };

    } //--------
