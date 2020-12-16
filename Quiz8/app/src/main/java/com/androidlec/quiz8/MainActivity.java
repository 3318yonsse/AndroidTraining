package com.androidlec.quiz8;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {


    private ArrayList<ManU> data = null;
    private ManUAdapter adapter = null;
    private ListView listView = null;
    private EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        data = new ArrayList<ManU>();

        data.add(new ManU("1", R.drawable.oneyou, "David de Gea",R.drawable.spain,"30세","David de Gea","30"));
        data.add(new ManU("29", R.drawable.twoyou, "Aaron Wan-Bissaka",R.drawable.england,"23세","Aaron Wan-Bissaka","28/27"));
        data.add(new ManU("2", R.drawable.fouryou, "Victor Lindelof",R.drawable.sweden,"26세","Victor Lindelof","29"));
        data.add(new ManU("5", R.drawable.fiveyou, "Harry Maguire",R.drawable.england,"27세","Harry Maguire ","30"));
        data.add(new ManU("23", R.drawable.threeyou, "Luke Shaw",R.drawable.england,"25세","Luke Shaw","24/22"));
        data.add(new ManU("31", R.drawable.nineyou, "Nemanja Matic",R.drawable.serbia,"32세","Nemanja Matic","22/19"));
        data.add(new ManU("17", R.drawable.sevenyou, "Fred",R.drawable.brazil,"27세","Fred","28/24"));
        data.add(new ManU("39", R.drawable.eightyou, "Scott Mctominay",R.drawable.scotland,"24세","Scott Mctominay","18/17"));
        data.add(new ManU("6", R.drawable.sixyou, "Paul Pogba",R.drawable.france,"27세","Paul Pogba","25/23"));
        data.add(new ManU("9", R.drawable.tenyou, "Anthony Martial",R.drawable.france,"25세","Anthony Martial","24"));
        data.add(new ManU("10", R.drawable.elevenyou, "Marcus Rashford", R.drawable.england,"23세","Marcus Rashford","28"));

        adapter = new ManUAdapter(MainActivity.this, R.layout.custom_layout, data);
        listView = findViewById(R.id.lv_player);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(mItemClickListener);
    }

    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            switch (position){
                case 0:
                    Intent intent = new Intent(getApplicationContext(), degea.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(getApplicationContext(), bisaka.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(getApplicationContext(), lindelof.class);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(getApplicationContext(), mcguire.class);
                    startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(getApplicationContext(), lshow.class);
                    startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(getApplicationContext(), matic.class);
                    startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(getApplicationContext(), fred.class);
                    startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(getApplicationContext(), mctominay.class);
                    startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(getApplicationContext(), pogba.class);
                    startActivity(intent);
                    break;
                case 9:
                    intent = new Intent(getApplicationContext(), matial.class);
                    startActivity(intent);
                    break;
                case 10:
                    intent = new Intent(getApplicationContext(), rashford.class);
                    startActivity(intent);
                    break;



            }


        }
    };
}