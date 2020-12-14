package com.androidlec.quiz7;



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {


    RadioGroup radioGroupWebsite;
    RadioButton radioButton;
    Button btnWebSiteNames;
    String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "Start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addListenerRadioButton();
        Log.v(TAG,"Start Listener");
    }

    private void addListenerRadioButton(){
        radioGroupWebsite = findViewById(R.id.radioGroup);
        btnWebSiteNames = findViewById(R.id.button);
        btnWebSiteNames.setOnClickListener(onClickListener);
        Log.v(TAG,"Ready to Click");
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int selected = radioGroupWebsite.getCheckedRadioButtonId();
            Log.v(TAG, Integer.toString(selected));

            radioButton = findViewById(selected);
            Toast.makeText(MainActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
        }
    };





}//--------------------