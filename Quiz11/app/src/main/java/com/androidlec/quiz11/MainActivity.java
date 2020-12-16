package com.androidlec.quiz11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView = null;
    Button small = null;
    Button large = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView01);
        small = findViewById(R.id.smallBtn);
        large = findViewById(R.id.largeBtn);

        small.setOnClickListener(mClickListener);
        large.setOnClickListener(mClickListener);
    }
    View.OnClickListener mClickListener = new View.OnClickListener() {
        double i = 10.0;
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.smallBtn:
                    i = i - 1;
                    textView.setTextSize((float) i);
//                    small.setTextColor(Color.WHITE);
//                    small.setTextColor(Color.RED);
                    small.setTextSize((float) i);
//                    Log.v("Value", "TextSize Value Small : " + textView.getTextSize());

                    break;
                case R.id.largeBtn:
                    i = i + 1;
                    textView.setTextSize((float) i);
//                    large.setTextColor(Color.WHITE);
//                    large.setTextColor(Color.BLUE);
                    large.setTextSize((float) i);
//                    Log.v("Value", "TextSize Value Large : " + textView.getTextSize());
                    break;
            }

        }
    };
}