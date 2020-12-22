package com.androidlec.dbcrud01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {


    final static String TAG = "DeleteActivity";
    Button btnDelete;
    String urlAddr = null;
    EditText Ecode, Ename, Edept, Ephone;
    String scode, sname, sdept, sphone;
    String macIP;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        intent = getIntent();
        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/studentDelete.jsp?";

        Ecode = findViewById(R.id.delete_code);
        Ename = findViewById(R.id.delete_name);
        Edept = findViewById(R.id.delete_dept);
        Ephone = findViewById(R.id.delete_phone);


        Ecode.setText(intent.getStringExtra("delete_code"));
        Ename.setText(intent.getStringExtra("delete_name"));
        Edept.setText(intent.getStringExtra("delete_dept"));
        Ephone.setText(intent.getStringExtra("delete_phone"));


        btnDelete = findViewById(R.id.delete_btn);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                macIP = intent.getStringExtra("macIP");
                urlAddr = "http://" + macIP + ":8080/test/studentDelete.jsp?";

                Ecode = findViewById(R.id.delete_code);
                Ename = findViewById(R.id.delete_name);
                Edept = findViewById(R.id.delete_dept);
                Ephone = findViewById(R.id.delete_phone);

            }
        });


    }
}