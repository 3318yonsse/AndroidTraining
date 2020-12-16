package com.androidlec.putextra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    final static int RValues = 0;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textView = findViewById(R.id.tv_third);
        button = findViewById(R.id.btn_third);

        button.setOnClickListener(onClickListener);
        // 들어오는것을 받음
        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");
        int passwd = intent.getIntExtra("passwd", 0);
        textView.setText("User ID : " + userid + " / " + "Passwd : " + passwd);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("result", "****");
            // Main으로 전달할 리턴값을 여기서 전달함.
            // MainActivity가 Pause상태라 start할수가 없어서 setResult로 보냄.
            setResult(RValues, intent);
            // data를 보내고 종료.
            finish();
        }
    };
}
