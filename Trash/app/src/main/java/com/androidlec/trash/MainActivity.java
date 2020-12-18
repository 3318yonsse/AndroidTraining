package com.androidlec.trash;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    final static String TAG = "Status";
    Button btnInsert;
    StudentInfo studentInfo;
    EditText userId,userName,userPw,userTel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentInfo = new StudentInfo(InsertActivity.this);

        userId = findViewById(R.id.userid);
        userName = findViewById(R.id.username);
        userPw = findViewById(R.id.userpw);
        userTel = findViewById(R.id.usertel);


        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {

            SQLiteDatabase DB;

            @Override
            public void onClick(View v) {
                switch (v.getId()){

                    // DB Insert case
                    case R.id.btn_insert :
                        try {
                            //입력할때 getWritableDatabase()
                            DB = studentInfo.getWritableDatabase();
                            String query ="INSERT INTO member (username, userid,passwd) VALUES( '" + userId.getText().toString() + "' , '" + userName.getText().toString() + "','"+ userPw.getText().toString() +"','"+ userTel.getText().toString() +"');";
                            DB.execSQL(query);

                            studentInfo.close();
                            Toast.makeText(InsertActivity.this, "입력 완료!", Toast.LENGTH_SHORT).show();

                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(InsertActivity.this, "입력 오류!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        });

    }
}