package com.android.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    Button backBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Log.v("SubActivity", "들어왔냐?");
        Log.v("SubActivity", "들어왔냐?");
        Log.v("SubActivity", "들어왔냐?");
        Log.v("SubActivity", "들어왔냐?");
        Log.v("SubActivity", "들어왔냐?");

        backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubActivity.this, SubMenuActivity.class);
                startActivity(intent);
            }
        });



    }
}
