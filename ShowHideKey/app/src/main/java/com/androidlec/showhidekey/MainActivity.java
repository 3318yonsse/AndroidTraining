package com.androidlec.showhidekey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    InputMethodManager mImm;
    EditText mEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------ Step 1 -------//
        // 연결 //
        mImm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        mEdit = findViewById(R.id.edit);

        findViewById(R.id.showButton).setOnClickListener(mClickListener);
        findViewById(R.id.hideButton).setOnClickListener(mClickListener);
        //------ Step 1! -------//
    }




        //------ Step 2 -------//
        // EditText 눌렀을때 자판 보이게,안보이게 //
        View.OnClickListener mClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.showButton :
                        mImm.showSoftInput(mEdit,0);
                        break;
                    case R.id.hideButton :
                        mImm.hideSoftInputFromWindow(mEdit.getWindowToken(),0);
                        break;

        //------ Step 2! -------//
                }
            }
        };





    } //------------------
