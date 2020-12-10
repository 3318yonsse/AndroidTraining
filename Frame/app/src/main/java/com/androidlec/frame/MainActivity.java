package com.androidlec.frame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.visibleBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView img = findViewById(R.id.dogImage);
                if(img.getVisibility() == v.VISIBLE){
                    img.setVisibility(v.INVISIBLE);
                }else{
                    img.setVisibility(v.VISIBLE);
                }
            }
        });
    }
}