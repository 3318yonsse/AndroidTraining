package com.androidlec.database01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MemberInfo extends SQLiteOpenHelper {
    final static String TAG = "MemberInfo";


    // construcor 추가
    public MemberInfo(@Nullable Context context) {
        super(context, "MemberInfo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v(TAG,"onCreate();");
        // 테이블 만들어 줌 create
        String query = "CREATE TABLE member(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, userid TEXT, passwd INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(TAG, "onUpgrade();");
        String query = "DROP TABLE IF EXISTS member;";
        db.execSQL(query);
        onCreate(db);
    }
}
