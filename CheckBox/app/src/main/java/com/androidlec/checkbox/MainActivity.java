package com.androidlec.checkbox;


import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    CheckBox cb1, cb2, cb3, cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cb_01);
        cb2 = findViewById(R.id.cb_02);
        cb3 = findViewById(R.id.cb_03);
        cb4 = findViewById(R.id.cb_04);

        cb1.setOnCheckedChangeListener(checkedChangeListener);
        cb2.setOnCheckedChangeListener(checkedChangeListener);
        cb3.setOnCheckedChangeListener(checkedChangeListener);
        cb4.setOnCheckedChangeListener(checkedChangeListener);
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
       @Override
       public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
           String str = "";
           if(cb1.isChecked() == true) str += "운동";
           if(cb2.isChecked() == true) str += "요리";
           if(cb3.isChecked() == true) str += "독서";
           if(cb4.isChecked() == true) str += "여행";

           Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();



//            switch (buttonView.getId()){
//                case R.id.cb_01 :
//                    if(isChecked == true){
//                        str = "운동";
//                        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();;
//                    }
//                    break;
//                case R.id.cb_02 :
//                    if(isChecked == true){
//                        str = "요리";
//                        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();;
//                    }
//                    break;
//                case R.id.cb_03 :
//                    if(isChecked == true){
//                        str = "독서";
//                        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();;
//                    }
//                    break;
//                case R.id.cb_04:
//                    if(isChecked == true){
//                        str = "여행";
//                        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();;
//                    }
//                    break;
//            }


       }
   };
}   //------------