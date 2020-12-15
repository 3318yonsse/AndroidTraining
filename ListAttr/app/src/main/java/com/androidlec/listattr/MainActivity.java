package com.androidlec.listattr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adapter
        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(this,R.array.country, android.R.layout.simple_list_item_multiple_choice);

        // Adapter
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);

        // 체크박스를 선택할수 있게 함
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        // Color 줄수 있음
        list.setDivider(new ColorDrawable(0x50ff0000));
        // 리스트 사이 너비
        list.setDividerHeight(100);


    }
}