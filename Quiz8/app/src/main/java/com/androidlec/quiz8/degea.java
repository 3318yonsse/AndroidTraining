package com.androidlec.quiz8;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class degea extends Activity {

    private Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degea);

        Button button = findViewById(R.id.backbtn);

//        TextView name = findViewById(R.id.pname);
//        TextView age = findViewById(R.id.page);
//        TextView game = findViewById(R.id.pgame);
//
//        ManU manU = new ManU();
//        String name1 = manU.getName();
//        name.setText(name1);


        button.setOnClickListener(mClickListener);

    }

    View.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            finish();

        }
    };

    public void onButton2Clicked(View v){

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.premierleague.com/players/4330/David-de-Gea/overview"));
        startActivity(intent);
    };
}