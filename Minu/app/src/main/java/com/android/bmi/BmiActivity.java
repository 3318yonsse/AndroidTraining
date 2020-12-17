package com.android.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BmiActivity extends AppCompatActivity {
    ImageView imgMan;
    ImageView imgWoman;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_gender);


        findViewById(R.id.imgMan).setOnClickListener(genderClickListener);
        findViewById(R.id.imgWoman).setOnClickListener(genderClickListener);







    }

    View.OnClickListener genderClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.imgMan:
                    intent = new Intent(BmiActivity.this, CalculationActivity.class);
                    intent.putExtra("gender","남자");
                    startActivity(intent);
                    break;

                case R.id.imgWoman:
                    intent = new Intent(BmiActivity.this, CalculationActivity.class);
                    intent.putExtra("gender","여자");
                    startActivity(intent);
                    break;

            }
        }
    };
}
