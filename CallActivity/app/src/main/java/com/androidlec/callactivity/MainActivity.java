package com.androidlec.callactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG,"MainActivity onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCall = findViewById(R.id.call);


        //------ Step 1 ------//
        // intent 입력 //
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent(,)                            ,기준 앞은 보내는곳 뒤는 보낼곳
                Intent intent =  new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
        //------ Step 1 ------//
            }
        });
    }

    @Override
    protected void onStart() {
        Log.v(TAG,"MainActivity onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v(TAG,"MainActivity onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v(TAG,"MainActivity onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v(TAG,"MainActivity onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG,"MainActivity onDestroy()");
        super.onDestroy();
    }
}