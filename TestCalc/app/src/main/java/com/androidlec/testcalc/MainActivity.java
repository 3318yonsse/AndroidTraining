package com.androidlec.testcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button sum = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button mul = findViewById(R.id.mul);
        Button div = findViewById(R.id.div);

        sum.setOnClickListener(mClickListener);
        sub.setOnClickListener(mClickListener);
        mul.setOnClickListener(mClickListener);
        div.setOnClickListener(mClickListener);

    }
//
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String total;
            EditText one = findViewById(R.id.first);
            EditText two = findViewById(R.id.second);

            String One = one.getText().toString();
            String Two = two.getText().toString();

            int OneN = Integer.parseInt(One);
            int TwoN = Integer.parseInt(Two);

            switch (v.getId()) {
                case R.id.add:
                    total = Integer.toString(OneN + TwoN);
                    Toast.makeText(MainActivity.this, total, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.sub:
                    total = Integer.toString(OneN - TwoN);
                    Toast.makeText(MainActivity.this, total, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.mul:
                    total = Integer.toString(OneN * TwoN);
                    Toast.makeText(MainActivity.this, total, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.div:
                    total = Integer.toString(OneN / TwoN);
                    Toast.makeText(MainActivity.this, total, Toast.LENGTH_SHORT).show();
                    break;

            }


        }
    };

}