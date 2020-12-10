package com.androidlec.buttonedit;

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

        Button btn = findViewById(R.id.btn);        //xml(btn)과 연결
        EditText edit = findViewById(R.id.edit);    //xml(edit)과 연결

        btn.setOnClickListener(new View.OnClickListener() {                 //Listener가 있어야함.
            @Override
            public void onClick(View v) {
                String str = edit.getText().toString();                     // str로 받음
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });

    }
}