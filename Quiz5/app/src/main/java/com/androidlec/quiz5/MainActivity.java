package com.androidlec.quiz5;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    EditText result;
    TextView TextResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        num1 = findViewById(R.id.num01);
        num2 = findViewById(R.id.num02);
        result = findViewById(R.id.result);
        TextResult = findViewById(R.id.TextResult);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

       if(num1.getText().toString().trim().length() == 0 || num2.getText().toString().trim().length() == 0){
            Toast.makeText(this,"값을 입력하세요",Toast.LENGTH_SHORT).show();
       } else {

           int Num1 = Integer.parseInt(num1.getText().toString());
           int Num2 = Integer.parseInt(num2.getText().toString());


           switch (item.getItemId()) {
               case R.id.add:
                   String result1 = Integer.toString(Num1 + Num2);
                   result.setText(result1);
                   TextResult.setText("AddResult");
                   break;
               case R.id.sub:
                   result1 = Integer.toString(Num1 - Num2);
                   result.setText(result1);
                   TextResult.setText("SubResult");
                   break;
               case R.id.mul:
                   result1 = Integer.toString(Num1 * Num2);
                   result.setText(result1);
                   TextResult.setText("MulResult");
                   break;
               case R.id.div:
                   result1 = Integer.toString(Num1 / Num2);
                   result.setText(result1);
                   TextResult.setText("DivResult");
                   break;

           }


       }
        return true;
    }
}