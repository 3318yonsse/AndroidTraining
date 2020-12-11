package com.androidlec.editabletest;



import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    // Field
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit);

        addListener();
    }

    private void addListener(){
        Button insertBtn = findViewById(R.id.insert);
        insertBtn.setOnClickListener(mClickListener);

        findViewById(R.id.delete).setOnClickListener(mClickListener);
        findViewById(R.id.append).setOnClickListener(mClickListener);
        findViewById(R.id.replace).setOnClickListener(mClickListener);
        findViewById(R.id.clear).setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Editable edit = editText.getText();
            switch (v.getId()){
                    // 맨앞에 붙히기
                case R.id.insert:
                    edit.insert(0,"INS");
                    break;
                    //삭제하
                case R.id.delete:
                    edit.delete(2,5);
                    break;
                    //맨 뒤에 붙히기
                case R.id.append:
                    edit.append("APP");
                    break;
                    //바꾸기
                case R.id.replace:
                    edit.replace(2,5,"REP");
                    break;
                case R.id.clear:
                    edit.clear();
                    break;
            }


        }


    };
}