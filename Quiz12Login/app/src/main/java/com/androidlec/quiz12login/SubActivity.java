package com.androidlec.quiz12login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class SubActivity extends AppCompatActivity {

    Button button;
    TextView textView, textView1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.second_id);
        textView = findViewById(R.id.second_pw);

        // -------------------userid , password------------- 값 가져와보기!//

        button = findViewById(R.id.btn_second);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


    }
}
