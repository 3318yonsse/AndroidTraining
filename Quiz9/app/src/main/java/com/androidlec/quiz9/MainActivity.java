package com.androidlec.quiz9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    TextView textView;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       button1 = findViewById(R.id.apple);
       button2 = findViewById(R.id.orange);
       textView = findViewById(R.id.fruit);
       imageView = findViewById(R.id.fi);


       button1.setOnClickListener(onClickListener);
       button2.setOnClickListener(onClickListener);


    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.apple :
                    textView.setText("Apple");
                    imageView.setImageResource(R.drawable.apple);
                    break;
                case R.id.orange:
                    textView.setText("Orange");
                    imageView.setImageResource(R.drawable.orange);
                    break;

            }
        }
    };




}