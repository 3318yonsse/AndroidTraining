package com.androidlec.listadddel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //step 단위로 git commit!

    //-------- Step 1 --------//
    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ListView listView;
    //-------- Step 1! --------//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //-------- Step 2 --------//
        // ArrayList에 추가 //
        // Adapter연결 //
        items = new ArrayList<String>();
        items.add("First");
        items.add("Second");
        items.add("Third");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, items);
        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        // choice 할수 있는 모드 //
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //-------- Step 2! --------//




        //-------- Step 3 --------//
        //ClickListener로 연결//
        listView.setOnItemClickListener(mItemClickListener);
        findViewById(R.id.addButton).setOnClickListener(mClickListener);
        findViewById(R.id.deleteButton).setOnClickListener(mClickListener);
        //-------- Step 3! --------//
    }



        //-------- Step 4 --------//
        // 리스트를 클릭했을때 Toast 띄우기 //
        AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String messeage;
                messeage = "Select Item = " + items.get(position);
                Toast.makeText(MainActivity.this, messeage, Toast.LENGTH_SHORT).show();
            }
        };
        //-------- Step 4! --------//



        //-------- Step 5 --------//
        // button action //
        View.OnClickListener mClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.newItem);
                switch (v.getId()){
                    case R.id.addButton :
                        String text = editText.getText().toString();        // arraylist 넣으려고 스트링으로 바꿔줌
                        if(text.length() != 0){
                            items.add(text);                                // arraylist에 editText에 입력된 String을 추가함.
                            adapter.notifyDataSetChanged();                 // adapter가 데이터가 바뀌었다고 알려주는 메소드.
                        }
                        break;
                    case R.id.deleteButton :
                        int id;
                        id = listView.getCheckedItemPosition();             // 몇번째(position)를 눌렀는지 가져옴.
                        if(id != ListView.INVALID_POSITION){
                            items.remove(id);                               // arraylist 지울때 .remove   id번째를 지운다.
                            listView.clearChoices();                        // listview를 clear한다
                            adapter.notifyDataSetChanged();
                        }
                        break;
                    //-------- Step 5! --------//
            }
        }


    };
}   //-------------