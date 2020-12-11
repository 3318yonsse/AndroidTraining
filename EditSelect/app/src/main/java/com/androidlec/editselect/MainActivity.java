package com.androidlec.editselect;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit);

        findViewById(R.id.home1).setOnClickListener(mClickListener);
        findViewById(R.id.end1).setOnClickListener(mClickListener);
        findViewById(R.id.selblock).setOnClickListener(mClickListener);
        findViewById(R.id.selall).setOnClickListener(mClickListener);
        findViewById(R.id.getsel).setOnClickListener(mClickListener);


    }

    View.OnClickListener mClickListener =  new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                //setSelection을 통해 맨 앞으로 커서 이동
                case R.id.home1:
                    editText.setSelection(0);
                    break;
                //맨 뒤로 이동함
                case R.id.end1:
                    editText.setSelection(editText.getText().length());
                    break;
                //해당 범위만 블럭으로 선택함
                case R.id.selblock:
                    editText.setSelection(3,10);
                    break;
                // 전부 선택 selectAll()
                case R.id.selall:
                    editText.selectAll();
                    break;
                // 선택한 텍스트의 첫번째가 몇번째고 마지막이 몇번째인지 알려줌
                case R.id.getsel:
                    int start = editText.getSelectionStart();
                    int end = editText.getSelectionEnd();
                    Toast.makeText(MainActivity.this, "start=" + start + ",end=" + end, Toast.LENGTH_SHORT).show();
                    break;


            }
        }
    };


} //-----