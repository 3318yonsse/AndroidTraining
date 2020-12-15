package com.androidlec.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence> adapter = null;
    Spinner spinner = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adapter 연결
        adapter = ArrayAdapter.createFromResource(this,R.array.country, android.R.layout.simple_spinner_item);

        // 드롭다운 
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        // spinner - XML 연결
        spinner = findViewById(R.id.sp_01);

        // spinner - adapter 연결
       spinner.setAdapter(adapter);
    }
}