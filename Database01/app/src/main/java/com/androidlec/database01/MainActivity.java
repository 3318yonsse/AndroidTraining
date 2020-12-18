package com.androidlec.database01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "Status";
    Button btnInsert, btnUpgrade, btnDeletem, btnSelect;
    TextView tvResult;
    // 로컬이기에 MemberInfo(db)를 선언해주어야함
    MemberInfo memberInfo;
    EditText userId, userName, userPw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memberInfo = new MemberInfo(MainActivity.this);

        userId = findViewById(R.id.userid);
        userName = findViewById(R.id.username);
        userPw = findViewById(R.id.userpw);



        findViewById(R.id.btn_insert).setOnClickListener(onClickListener);
        findViewById(R.id.btn_update).setOnClickListener(onClickListener);
        findViewById(R.id.btn_delete).setOnClickListener(onClickListener);
        findViewById(R.id.btn_select).setOnClickListener(onClickListener);
        tvResult = findViewById(R.id.tv_result);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        SQLiteDatabase DB;

        @Override
        public void onClick(View v) {
            switch (v.getId()){


                // DB Insert case
                case R.id.btn_insert :
                    try {
                        //입력할때 getWritableDatabase()
                        DB = memberInfo.getWritableDatabase();
                        String query ="INSERT INTO member (username, userid,passwd) VALUES( '" + userId.getText().toString() + "' , '" + userName.getText().toString() + "','"+ userPw.getText() +"');";
                        DB.execSQL(query);

                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "Insert OK!", Toast.LENGTH_SHORT).show();

                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Insert Error!", Toast.LENGTH_SHORT).show();
                    }
                    break;




                // DB Update case
                case R.id.btn_update :
                        try {
                            //업데이트 할 때  getWritableDatabase()
                            DB = memberInfo.getWritableDatabase();
                            String query ="UPDATE membber SET username = '관우' WHERE userid = 'yb';";
                            DB.execSQL(query);

                            memberInfo.close();
                            Toast.makeText(MainActivity.this, "Update OK!", Toast.LENGTH_SHORT).show();

                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Update Error!", Toast.LENGTH_SHORT).show();
                        }
                        break;




                // DB Select case
                case R.id.btn_select :
                    try{
                        // 검색할때 getReadableDatabase
                        DB = memberInfo.getReadableDatabase();
                        String query ="SELECT username, userid, passwd FROM member;";
                        Cursor cursor = DB.rawQuery(query, null);

                        StringBuffer stringBuffer = new StringBuffer();

                        while(cursor.moveToNext()){
                            String username = cursor.getString(0);
                            String userid = cursor.getString(1);
                            int passwd = cursor.getInt(2);
                            stringBuffer.append("username : " + username + ", userid : "+ userid +", paaswd : " + passwd);

                        }
                        tvResult.setText(stringBuffer.toString());
                        cursor.close();
                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "Select OK!", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Select Error!", Toast.LENGTH_SHORT).show();
                    }
                    break;



                // DB Delete case
                case R.id.btn_delete :
                    try {
                        //업데이트 할 때  getWritableDatabase()
                        DB = memberInfo.getWritableDatabase();
                        String query = "DELETE FROM member WHERE userid = 'yb';";
                        DB.execSQL(query);

                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "Delete OK!", Toast.LENGTH_SHORT).show();

                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Delete Error!", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }


        }
    };


}//-------------------------------