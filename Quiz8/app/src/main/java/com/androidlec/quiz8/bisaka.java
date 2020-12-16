package com.androidlec.quiz8;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class bisaka extends Activity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bisaka);
        Button button = findViewById(R.id.backbtn);
        Button button1 = findViewById(R.id.recordbtn);


        button.setOnClickListener(mClickListener);


    }

    View.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            finish();

        }
    };

    public void onButton2Clicked(View v){

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.premierleague.com/players/14164/Aaron-Wan-Bissaka/overview"));
        startActivity(intent);
    };




}