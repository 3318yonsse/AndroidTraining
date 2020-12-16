package com.androidlec.callactivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

    //------ Step 1 ------//
                        // extends 반드시 해주어야 함.
public class SubActivity extends AppCompatActivity {

    String TAG = "Sub";

    // protected onCreate 추가해줌
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.v(TAG,"SubActivity onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    //------ Step 1! ------//

        // 화면 전환 //
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 화면 전환! //

        Button btnClose =findViewById(R.id.close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 종료 메소드!
                finish();
            }
        });
    }

        @Override
        protected void onStart() {
            Log.v(TAG,"SubActivity onStart()");
            super.onStart();
        }

        @Override
        protected void onResume() {
            Log.v(TAG,"SubActivity onResume()");
            super.onResume();
        }

        @Override
        protected void onPause() {
            Log.v(TAG,"SubActivity onPause()");
            super.onPause();
        }

        @Override
        protected void onStop() {
            Log.v(TAG,"SubActivity onStop()");
            super.onStop();
        }

        @Override
        protected void onDestroy() {
            Log.v(TAG,"SubActivity onDestroy()");
            super.onDestroy();
        }
    }//--------
