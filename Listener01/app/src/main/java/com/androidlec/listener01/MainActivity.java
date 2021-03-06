package com.androidlec.listener01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------- Step 1 -------//
        constraintLayout = findViewById(R.id.cl);
        constraintLayout.setOnClickListener(onClickListener);
        constraintLayout.setOnLongClickListener(onLongClickListener);
    }
        //------- Step 1! -------//



        //------- Step 2 -------//때
        // 클릭했을 때
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "onClick()",Toast.LENGTH_SHORT).show();
        }
    };


        // LongClick 했을 때
    View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(MainActivity.this, "onLongClick()",Toast.LENGTH_SHORT).show();
            return true;
        }
    };
         //------- Step 2! -------//
}