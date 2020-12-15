package com.androidlec.listactivity;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    ArrayList<String> data = null;
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // XML이랑 상관 없어서 끔
        // 글자만 화면에 띄울 용도면 ListActivity를 사용하는게 용이하
//        setContentView(R.layout.activity_main);

        data = new ArrayList<String>();
        data.add("월");
        data.add("화");
        data.add("수");
        data.add("목");
        data.add("금");
        data.add("토");
        data.add("일");
        data.add("월");
        data.add("화");
        data.add("수");
        data.add("목");
        data.add("금");
        data.add("토");
        data.add("일");
        data.add("월");
        data.add("화");
        data.add("수");
        data.add("목");
        data.add("금");
        data.add("토");
        data.add("일");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        setListAdapter(adapter);
    }
}