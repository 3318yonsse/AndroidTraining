package com.androidlec.dbcrud01;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {

    final static String TAG = "NetworkTask";
    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    ArrayList<Student> members;

    // Constructor
    public NetworkTask(Context mContext, String mAddr) {
        this.context = mContext;
        this.mAddr = mAddr;
        this.members = new ArrayList<Student>();
        Log.v(TAG,"Start : " + mAddr);
    }
    // Constructor



    @Override
    protected void onPreExecute() {
        Log.v(TAG,"onPreExecute()");
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Data Fetch");
        progressDialog.setMessage("Get ....");
        progressDialog.show();
    }




    // onPreExecute()와 같이 실행됨!
    @Override
    protected Object doInBackground(Integer... integers) {
        Log.v(TAG,"doInBackground()");
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;


        try{
            // 주소 : mAddr에서 가져와라
            URL url = new URL(mAddr);
            // http 사용하겠다
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //연결 하는 시간. (10초)
            httpURLConnection.setConnectTimeout(10000);

            if(httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK){
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                // data를 한번에 가져옴
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true) {
                    // 차곡차곡 쌓인게 없으면 while문 빠진다.
                    String strline = bufferedReader.readLine();
                    if(strline == null) break;
                    // 쌓이면 parser로 빠진다.
                    stringBuffer.append(strline+ "\n");
                }
                parser(stringBuffer.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null) bufferedReader.close();
                if(inputStream != null) inputStreamReader.close();
                if(inputStream != null) inputStream.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return members;

    }


    @Override
    protected void onProgressUpdate(String... values) {
        Log.v(TAG,"onProgressUpdate()");
        super.onProgressUpdate(values);
    }


    @Override
    protected void onPostExecute(Object o) {
        Log.v(TAG,"onPostExecute()");
        super.onPostExecute(o);
        progressDialog.dismiss();                   //progress 종료
    }

    @Override
    protected void onCancelled() {
        Log.v(TAG,"onCancelled()");
        super.onCancelled();
    }

    private void parser(String s){                  // StringBuffer에 있는게 String s로 넘어옴
        Log.v(TAG,"parser()");
        try{
            JSONObject jsonObject = new JSONObject(s);                  //String s 받은걸 JSONObject에 넣어줌
            JSONArray jsonArray = new JSONArray(jsonObject.getString("students_info"));         // json에 배열의 시작을 선언하고 그 배열의 이름은 students_info
            members.clear();

            for(int i = 0; i < jsonArray.length(); i++){                    // 배열에 있는 내용을 가져올때 "("안에 내용을 - for문을 사용해 뽑아옴.
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);     // 오브젝트 내용을 가져옴
                String code = jsonObject1.getString("code");        // 가져온 내용들을 선언해줌
                String name = jsonObject1.getString("name");
                String dept = jsonObject1.getString("dept");
                String phone = jsonObject1.getString("phone");

                Student student = new Student(code, name, dept, phone);     //bean에 넣음
                members.add(student);                   // ArrayList 에 넣음.

            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }










}//-------------------------------
