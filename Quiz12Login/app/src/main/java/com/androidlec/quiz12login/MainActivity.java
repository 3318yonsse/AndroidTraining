package com.androidlec.quiz12login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.userid);
        editText1 = findViewById(R.id.userpasswd);
        button = findViewById(R.id.submit);

        button.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String id1 = String.valueOf(editText.getText());
            String pw1 = String.valueOf(editText1.getText());
            if (id1.equals("qqq") && pw1.equals("aaa")) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("userid", "qqq");
                intent.putExtra("passwd", "aaa");
                startActivity(intent);

            } else {
                Toast.makeText(MainActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
            }

        }

        ;

    };
}//--------




