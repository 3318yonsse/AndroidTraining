package com.androidlec.quiz3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);

        LinearLayout grey = findViewById(R.id.grey);
        LinearLayout red = findViewById(R.id.red);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(grey.getVisibility() == v.VISIBLE){
                    grey.setVisibility(v.INVISIBLE);
                    red.setVisibility(v.VISIBLE);
                }

            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(red.getVisibility() == v.VISIBLE){
                    red.setVisibility(v.INVISIBLE);
                    grey.setVisibility(v.VISIBLE);


                }
            }
        });
    }
}