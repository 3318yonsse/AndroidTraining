package com.android.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BmiResult extends AppCompatActivity {
   Intent intent = null;
    TextView tv_age;
    TextView tv_height;
    TextView tv_weight;
    TextView tv_bmi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_result);
    intent = getIntent();
    String userAge = intent.getStringExtra("userAge");
    String bmi = intent.getStringExtra("BMI");
    String height = intent.getStringExtra("height");
    String weight = intent.getStringExtra("weight");

    double bmiD = Double.parseDouble(bmi);

    tv_age = findViewById(R.id.tv_age);
    tv_height = findViewById(R.id.tv_height);
    tv_weight = findViewById(R.id.tv_weight);
    tv_bmi = findViewById(R.id.tv_bmi);

    tv_age.setText(userAge + " Y");
    tv_height.setText(height+" cm");
    tv_weight.setText(weight+" kg");
    tv_bmi.setText(Double.toString(bmiD).substring(0,4));





    }
}
