package com.androidlec.bmi;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button start = findViewById(R.id.start);
        Button btn = findViewById(R.id.btnCalc);
        Button goback = findViewById(R.id.goback);

        EditText height = findViewById(R.id.height);
        EditText weight = findViewById(R.id.weight);
        TextView result = findViewById(R.id.result);
        ImageView resulImage = findViewById(R.id.image);

        LinearLayout text = findViewById(R.id.text);
        LinearLayout info = findViewById(R.id.infoImage);
        LinearLayout insert = findViewById(R.id.insert);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(info.getVisibility() == v.VISIBLE) {
                    info.setVisibility(v.INVISIBLE);
                    insert.setVisibility(v.VISIBLE);


                }
            }
        });


        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(insert.getVisibility() == v.VISIBLE) {
                    insert.setVisibility(v.INVISIBLE);
                    info.setVisibility(v.VISIBLE);

                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                double heightValue = Double.parseDouble(height.getText().toString());
                double weightValue = Double.parseDouble(weight.getText().toString());





                if (height.getText().length()==0 || weight.getText().length()==0 ){
                    String str = "값을 입력해주세요";
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

                } else{
                    double heightCm = heightValue * 0.01;

                    double BMI = weightValue / (heightCm*heightCm);

                    String BMIresult = String.format("%.2f", BMI);

                    if(BMI <= 18.5) {

                        resulImage.setImageResource(R.drawable.first);
                        result.setText("당신의 BMI지수는 "+BMIresult+" 입니다.");
                    } else if (BMI >= 18.5 && BMI <=22.9){
                        resulImage.setImageResource(R.drawable.second);
                        result.setText("당신의 BMI지수는 "+BMIresult+" 입니다.");
                    } else if (BMI >= 23 && BMI <= 24.9){
                        resulImage.setImageResource(R.drawable.thrid);
                        result.setText("당신의 BMI지수는 "+BMIresult+" 입니다.");
                    } else if (BMI >= 25 && BMI <=29.9){
                        resulImage.setImageResource(R.drawable.fourth);
                        result.setText("당신의 BMI지수는 "+BMIresult+" 입니다.");
                    }else {
                        resulImage.setImageResource(R.drawable.fifth);
                        result.setText("당신의 BMI지수는 "+BMIresult+" 입니다.");
                    }
                }
//






            }


        });



    }
}

