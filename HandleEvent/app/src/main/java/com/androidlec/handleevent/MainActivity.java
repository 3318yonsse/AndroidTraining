package com.androidlec.handleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //내가 만든 메소드를 선언해주고
        View view = new MyView(this);
        setContentView(view);
    }
}