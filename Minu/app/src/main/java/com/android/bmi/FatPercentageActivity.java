package com.android.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;

import java.util.ArrayList;

public class FatPercentageActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private ArrayList<FatRate> data = null;
    private FatRateAdapter adapter = null;
    private ListView listView = null;

    int i = 0;

    ImageView color = null;
    TextView state = null;
    TextView rate = null;
    ImageView manbtn;
    ImageView womanbtn;

    TextView result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fatpercentage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        data = new ArrayList<FatRate>();
        data.add(new FatRate(R.drawable.r, "낮음", "           < 8 %"));
        data.add(new FatRate(R.drawable.e, "정상", "    8 ~ 20 %"));
        data.add(new FatRate(R.drawable.w, "높음", "  20 ~ 25 %"));
        data.add(new FatRate(R.drawable.q, "매우 높음", "> 25 %"));

        EditText mAge = findViewById(R.id.member_Age);
        TextView result = findViewById(R.id.fat_result);

//        result.setOnClickListener(rClickListener);

        manbtn = findViewById(R.id.Manbtn);
        womanbtn = findViewById(R.id.Womanbtn);
        manbtn.setOnClickListener(mClickListener);
        womanbtn.setOnClickListener(mClickListener);



        adapter = new FatRateAdapter(FatPercentageActivity.this, R.layout.fragment_fatlist_layout, data);
        listView = findViewById(R.id.list_state);
        listView.setAdapter(adapter);

        result = findViewById(R.id.fat_result);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.Manbtn:
                    if(i == 0){
                        manbtn.setImageResource(R.drawable.m1);

                        i++;
                    }
                    else{
                        manbtn.setImageResource(R.drawable.m2);
                        i--;
                    }
                    break;
                case R.id.Womanbtn:
                    if(i == 0){
                        womanbtn.setImageResource(R.drawable.w2);
                        i++;
                    }else {
                        womanbtn.setImageResource(R.drawable.w1);
                        i--;
                    }
                    break;
            }
        }
    };
   /* View.OnClickListener rClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };*/
}