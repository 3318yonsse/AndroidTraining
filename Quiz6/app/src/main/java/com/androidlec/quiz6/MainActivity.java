package com.androidlec.quiz6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Start");

        // Data 준비
        ArrayList<Integer> number = new ArrayList<>();
        for(int i = 1; i<=100; i++){
            number.add(i);
        }

        // Adapter
        ArrayAdapter<Integer> adapter;
        adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, number);



        // Adapter를 ListView에 연결
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);
    }


}