package com.androidlec.quiz8;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mcguire extends Activity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcguire);




        Button button = findViewById(R.id.backbtn);

        button.setOnClickListener(mClickListener);

    }

    View.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            finish();

        }
    };

    public void onButton2Clicked(View v){

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.premierleague.com/players/9566/Harry-Maguire/overview"));
        startActivity(intent);
    };
}