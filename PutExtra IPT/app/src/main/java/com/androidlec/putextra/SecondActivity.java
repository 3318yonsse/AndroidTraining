package com.androidlec.putextra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    Button button;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //------ Step 1 ------//
        // 따로 만든 액티비티이기에 레이아웃 연결 따로 해줘야함.
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.tv_second);
        button =findViewById(R.id.btn_second);

        button.setOnClickListener(onClickListener);
        // MainActivity에서 보내는 Intent 값을 get으로 받음.
        Intent intent = getIntent();
        // getStringExtra 중요!!!!
        String userid = intent.getStringExtra("userid");
        int passwd = intent.getIntExtra("passwd",0);
        textView.setText("User ID : "+ userid + " / " + "Passwd : "+ passwd);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
            //------ Step 1! ------//
        }
    };
}
