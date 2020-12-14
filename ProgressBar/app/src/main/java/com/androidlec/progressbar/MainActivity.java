package com.androidlec.progressbar;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

    ProgressBar pb01;
    ProgressBar pb02;
    Button progressBTN;
    Button resetBTN;
    Button showBTN;
    Button hideBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pb01 = findViewById(R.id.pb_01);
        pb02 = findViewById(R.id.pb_02);

        progressBTN = findViewById(R.id.btn_01);
        resetBTN = findViewById(R.id.btn_02);
        showBTN = findViewById(R.id.btn_03);
        hideBTN = findViewById(R.id.btn_04);

        progressBTN.setOnClickListener(clickListener);
        resetBTN.setOnClickListener(clickListener);
        showBTN.setOnClickListener(clickListener);
        hideBTN.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_01 :  // Progress Button
                    pb01.incrementProgressBy(10);
                    pb01.incrementSecondaryProgressBy(10);
                    break;
                case R.id.btn_02 : // Reset Button
                    pb01.setProgress(0);
                    pb01.setSecondaryProgress(10);
                    break;
                case R.id.btn_03 : // Show Button
                    pb02.setVisibility(ProgressBar.VISIBLE);
                    break;
                case R.id.btn_04 :  // Hide Button
                    pb02.setVisibility(ProgressBar.INVISIBLE);
                    break;
            }


        }
    };




} //--------------------