package com.androidlec.dbcrud01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectAllActivity extends AppCompatActivity {

    final static String TAG = "SelectAllActivity";
    String urlAddr = null;
    ArrayList<Student> members;
    StudentAdapter adapter;
    ListView listView;
    String macIP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectall);

        listView = findViewById(R.id.lv_student);

        Intent intent = getIntent();
        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/student_query_all.jsp";
    }


    @Override
    protected void onResume() {
        super.onResume();
        connectGetData();
        Log.v(TAG, "onResume()");
    }

    private void connectGetData(){
        try {
            NetworkTask networkTask = new NetworkTask(SelectAllActivity.this, urlAddr);    //NetworkTask를 연결.
            Object obj = networkTask.execute().get();         // 연결한것을 암호화 된 상태로 가져와 저장함.
            members = (ArrayList<Student>) obj;             // 가져온 것을 members에 저장

            adapter = new StudentAdapter(SelectAllActivity.this, R.layout.student_layout,members);
            listView.setAdapter(adapter);
            // 클릭 한번했을때

//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent intent = null;
//                    intent = new Intent(SelectAllActivity.this, UpdateActivity.class);
//                    intent.putExtra("scode",members.get(position).getCode());
//                    intent.putExtra("sname",members.get(position).getName());
//                    intent.putExtra("sdept",members.get(position).getDept());
//                    intent.putExtra("sphone",members.get(position).getPhone());
//                    startActivity(intent);
//                }
//            });




            //클릭 두번 했을때
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = null;
                    intent = new Intent(SelectAllActivity.this, DeleteActivity.class);
                    intent.putExtra("delete_code", members.get(position).getCode());
                    intent.putExtra("delete_name", members.get(position).getName());
                    intent.putExtra("delete_dept", members.get(position).getDept());
                    intent.putExtra("delete_phone", members.get(position).getPhone());
                    intent.putExtra("macIP", macIP);
                    startActivity(intent);

                    return true;
                }
            });





        }catch (Exception e){
            e.printStackTrace();
        }
    }




}