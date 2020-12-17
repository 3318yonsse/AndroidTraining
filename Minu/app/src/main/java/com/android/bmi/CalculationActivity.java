package com.android.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculationActivity extends AppCompatActivity {
    Intent intent = null;
    EditText userAge;
    EditText height;
    EditText weight;
    double bmi;
    String gender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculation);
        intent = getIntent();
        gender =  intent.getStringExtra("gender");
        userAge = findViewById(R.id.userAge);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);

        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(userAge.getText().length()==0){
                    Toast.makeText(CalculationActivity.this,"나이를 입력해 주세요.",Toast.LENGTH_SHORT).show();
                } else if (height.getText().length()==0) {
                    Toast.makeText(CalculationActivity.this,"키를 입력해 주세요.",Toast.LENGTH_SHORT).show();
                } else if(weight.getText().length()==0){
                    Toast.makeText(CalculationActivity.this,"몸무게를 입력해 주세요.",Toast.LENGTH_SHORT).show();
                }else {

                    double he = Double.parseDouble(height.getText().toString());
                    double we = Double.parseDouble(weight.getText().toString());
                    bmi = (10000 * we) / (he * he);

                    intent = new Intent(CalculationActivity.this, BmiResult.class);

                    intent.putExtra("BMI", Double.toString(bmi));
                    intent.putExtra("gender", gender);
                    intent.putExtra("userAge", userAge.getText().toString());
                    intent.putExtra("height", height.getText().toString());
                    intent.putExtra("weight", weight.getText().toString());


                    startActivity(intent);

                }
            }
        });
    }
}
