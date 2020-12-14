package com.androidlec.listfromarray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    RadioGroup radioGroup = null;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.rg_01);
        radioGroup.setOnCheckedChangeListener(checkChangeListener);

        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.country, android.R.layout.simple_expandable_list_item_1);
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);

    }

    RadioGroup.OnCheckedChangeListener checkChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {


           switch (checkedId){
               case R.id.rb_01 :
                   adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.country, android.R.layout.simple_expandable_list_item_1);
                   ListView list = findViewById(R.id.list);
                   list.setAdapter(adapter);
                   break;
               case R.id.rb_02 :
                   adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.fruits, android.R.layout.simple_expandable_list_item_1);
                   ListView list1 = findViewById(R.id.list);
                   list1.setAdapter(adapter);
                   break;


           }



        }
    };
}
