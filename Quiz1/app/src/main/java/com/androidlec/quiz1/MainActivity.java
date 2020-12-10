package com.androidlec.quiz1;

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

        Button btn = findViewById(R.id.btn);
        EditText edit = findViewById(R.id.edit);
        EditText edit2 = findViewById(R.id.edit2);
        EditText edit3 = findViewById(R.id.edit3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i  = Integer.parseInt(edit.getText().toString());
                int j = Integer.parseInt(edit2.getText().toString());

                String result = Integer.toString(i + j);

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();

                edit3.setText("계산 결과"+result);
            }
        });


    }
}