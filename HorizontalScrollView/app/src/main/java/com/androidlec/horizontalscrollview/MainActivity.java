package com.androidlec.horizontalscrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // 이미지 차곡차곡 쌓으려면 배열을 써야함.
    // 안드로이드는 숫자 이기에 int배열을 사용
    private int[] data = {R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,R.drawable.w5,R.drawable.w6,R.drawable.w7};
    private LinearLayout ll;
    private ImageView[] ivs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.ll_01);
        ivs = new ImageView[7];

        for(int i=0; i<7; i++){
            //for문 i값을 ivs배열에 넣음, this = 메인화면에 띄움
            ivs[i] = new ImageView((this));
            // ivs[i]에 data[i]값을 넣음
            ivs[i].setImageResource(data[i]);
            // LinearLayout에 ivs[i]값을 addview함
            ll.addView(ivs[i]);
        }
    }
}