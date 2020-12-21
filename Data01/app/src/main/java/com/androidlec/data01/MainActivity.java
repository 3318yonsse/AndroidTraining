package com.androidlec.data01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    // 로그캣에서 json이 들어왔나 확인하기 위함.
    // 로그를 달면서 해야 식별하기 용이함.
    final static String TAG = "Status";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parser();
        parser2();
    }



    // jasonex
    private void parser(){
        Log.v(TAG,"parser()");

        // json을 불러오는 방법 (json가져오기)
        InputStream inputStream = getResources().openRawResource(R.raw.jsonex);
        //메모리를 쌓아놓고 작업함
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);



        // 가져온 json을 담는 곳
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        try {
            while((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            Log.v(TAG,"String Buffer : " + stringBuffer.toString());




            // json중 일부를 가져올때
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            String name = jsonObject.getString("name");
            Log.v(TAG, "name : " + name);

            int age = jsonObject.getInt("age");
            Log.v(TAG, "age : " + age);




            // 배열 값 가져오기! (for문으로 빼옴)
            JSONArray jsonArray = jsonObject.getJSONArray("hobbies");
            for(int i=0; i<jsonArray.length(); i++){
                String hobby = jsonArray.getString(i);
                Log.v(TAG, "hobbies[" + i + "]" + hobby);
            }



            // 중괄호안에 있는 내용들 가져오기
            JSONObject jsonObject1 = jsonObject.getJSONObject("info");
            int no = jsonObject1.getInt("no");
            Log.v(TAG, "no : " + no);

            String id = jsonObject1.getString("id");
            Log.v(TAG, "id : " + id);

            String pw = jsonObject1.getString("pw");
            Log.v(TAG, "pw : " + pw);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (inputStream != null) inputStream.close();
                if(inputStreamReader != null) inputStreamReader.close();
                if (bufferedReader != null) bufferedReader  .close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }


    // jasonex2
    private void parser2(){
        Log.v(TAG, "parser2()");

        InputStream inputStream = getResources().openRawResource(R.raw.jsonex2);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        try{
            while((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            Log.v(TAG, stringBuffer.toString());

            //JSONObject를 선언하고 json 내용에 따라 바로 배열을 불러올준비를 함

            JSONObject jsonObject = new JSONObject(stringBuffer.toString());

            JSONArray jsonArray = new JSONArray(jsonObject.getString("members_info"));
                    for(int i = 0; i<jsonArray.length(); i++){
                    JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                    String name = jsonObject1.getString("name");
                    Log.v(TAG, "name : "+ name);
                    int age = jsonObject1.getInt("age");
                    Log.v(TAG, "age : "+ age);




                    JSONArray jsonArray1 = jsonObject1.getJSONArray("hobbies");
                    for(int j = 0; j<jsonArray1.length(); j++){
                        String hobby = jsonArray1.getString(j);
                        Log.v(TAG, "hobbies[" + j + "] : " + hobby);
                    }




                    JSONObject jsonObject2 = jsonObject1.getJSONObject("info");
                    int no = jsonObject2.getInt("no");
                    Log.v(TAG, "no : "+ no);

                    String id = jsonObject2.getString("id");
                    Log.v(TAG, "id : "+ id);

                    String pw = jsonObject2.getString("pw");
                    Log.v(TAG, "pw : "+ pw);

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (inputStream != null) inputStream.close();
                if(inputStreamReader != null) inputStreamReader.close();
                if (bufferedReader != null) bufferedReader  .close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }





} //--------------------------