package com.androidlec.bmi;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnCalc);
        EditText height = findViewById(R.id.height);
        EditText weight = findViewById(R.id.weight);
        EditText result = findViewById(R.id.result);
        ImageView resulImage = findViewById(R.id.image);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                double heightValue = Double.parseDouble(height.getText().toString());
                double weightValue = Double.parseDouble(weight.getText().toString());

                double heightCm = heightValue * 0.01;

                double BMI = weightValue / (heightCm*heightCm);

                String BMIresult = String.format("%.2f", BMI);







                if (height.length() == 0) {
//
                    Toast.makeText(getApplicationContext(), "값을 입력해주세요", Toast.LENGTH_LONG).show();

                } else if (weight.length() == 0){

                    Toast.makeText(getApplicationContext(), "값을 입력해주세요", Toast.LENGTH_LONG).show();
                }
//
                if(BMI > 18.5) {
                    resulImage.setImageResource(R.drawable.blue);
                } else if (BMI >= 18.5 && BMI <=22.9){
                    resulImage.setImageResource(R.drawable.green);
                } else if (BMI >= 23 && BMI <= 24.9){
                    resulImage.setImageResource(R.drawable.orange);
                } else if (BMI >= 25 && BMI <=29.9){
                    resulImage.setImageResource(R.drawable.red);
                }else {
                    resulImage.setImageResource(R.drawable.images);
                }




                result.setText(BMIresult);
            }


        });



    }
}

