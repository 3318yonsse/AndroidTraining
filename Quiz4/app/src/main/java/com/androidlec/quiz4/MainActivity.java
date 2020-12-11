package com.androidlec.quiz4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn1 = findViewById(R.id.one);
        Button btn2 = findViewById(R.id.two);
        Button btn3 = findViewById(R.id.three);
        Button btn4 = findViewById(R.id.four);
        Button btn5 = findViewById(R.id.five);
        Button btn6 = findViewById(R.id.six);
        Button btn7 = findViewById(R.id.seven);
        Button btn8 = findViewById(R.id.eight);
        Button btn9 = findViewById(R.id.nine);
        Button btn0 = findViewById(R.id.zero);
        Button btnAdd = findViewById(R.id.add);
        Button btnSub = findViewById(R.id.sub);
        Button btnMul = findViewById(R.id.mul);
        Button btnDiv = findViewById(R.id.div);
        Button btnClear = findViewById(R.id.clear);
        Button btnResult = findViewById(R.id.result);








    }
}