package com.androidlec.handleevent;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MyView extends View {

    // Field
    private Context mContext;

    // Constructor
    public MyView(Context context) {
        super(context);
        this.mContext = context;            // MainActivity를 넘겨주기위해!
    }


    //------ Step 1 ------//
    // 화면 아무곳이나 터치하면 Toast가 뜨게함 //
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Toast.makeText(this.mContext,"Touch Event Received", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    //------ Step 1! ------//
    }
} //---------------------
