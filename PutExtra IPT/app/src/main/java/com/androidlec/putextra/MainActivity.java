package com.androidlec.putextra;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int RValues = 0;
    TextView textView = null;
    Button button, button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_main);
        button = findViewById(R.id.btn_main);
        button1 = findViewById(R.id.btn1_main);

        button.setOnClickListener(onClickListener);
        button1.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;

            switch (v.getId()){
                // second activity로 값을 보낸다 (intent를 통해) putextra
                case R.id.btn_main :
                    intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("userid", "root");
                    intent.putExtra("passwd",1111);
                    startActivity(intent);
                    break;

                // third activity로 값을 보낸다 (intent를 통해) putextra
                case R.id.btn1_main :
                    intent = new Intent(MainActivity.this, ThirdActivity.class);
                    intent.putExtra("userid","admin");
                    intent.putExtra("passwd",2222);
                    // ThirdActivity가 값을 받기를 기다리고있음. ----> onActivityResult
                    // 값을 받을 Activity면 startActivityForResult(intent, RValues);를 무조건 써야함.
                    startActivityForResult(intent, RValues);

            }
        }
    };

    // startActivityForResult로 받으면 제일 처음 실행됨!
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // requestCode는 RValues의 스위치!
        // 데이터를 주고받는 액티비티가 많아지면 RValues가 많아짐
        switch (requestCode){
            case MainActivity.RValues :
                textView.setText("Return Value : " + data.getStringExtra("result"));
                break;

        }
    }
}   //-------------------