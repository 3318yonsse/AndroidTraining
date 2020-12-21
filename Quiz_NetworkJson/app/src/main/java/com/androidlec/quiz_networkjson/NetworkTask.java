package com.androidlec.quiz_networkjson;

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
    ArrayList<JsonStudent> students;

    public NetworkTask(Context context, String mAddr) {
        this.context = context;
        this.mAddr = mAddr;
        this.students = new ArrayList<JsonStudent>();
    }

    @Override
    protected void onPreExecute() {
        Log.v(TAG, "onPreExecute");
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dialogue");
        progressDialog.setMessage("down ...");
        progressDialog.show();
    }


    @Override
    protected Object doInBackground(Integer... integers) {
        Log.v(TAG, "doInBackground");

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();

        try {
            URL url = new URL(mAddr);
            Log.v(TAG, "Address" + mAddr);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            Log.v(TAG, "Accept : " + httpURLConnection.getResponseCode());

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true) {
                    String strline = bufferedReader.readLine();
                    if (strline == null) break;
                    stringBuffer.append(strline + "\n");
                }
                Log.v(TAG, "StringBuffer : " + stringBuffer.toString());
                parser(stringBuffer.toString());
            }

        } catch (Exception e) {
            Log.v(TAG, "Error!");
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (inputStream != null) inputStream.close();
                if (inputStreamReader != null) inputStreamReader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        return students;

    }

    @Override
    protected void onProgressUpdate(String... values) {
        Log.v(TAG, "onProgressUpdate");
        super.onProgressUpdate(values);

    }

    @Override
    protected void onPostExecute(Object o) {
        Log.v(TAG, "onPostExecute");
        super.onPostExecute(o);
        progressDialog.dismiss();
    }


    @Override
    protected void onCancelled() {
        Log.v(TAG,"onCancelled");
        super.onCancelled();
    }


    private void parser(String s) {
        Log.v(TAG, "parser()");

        try {
            Log.v(TAG, "----");
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("students_info"));
            students.clear();

            for (int i = 0; i<jsonArray.length(); i++) {
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String code = jsonObject1.getString("code");
                Log.v(TAG, "code : " + code);

                String name = jsonObject1.getString("name");
                Log.v(TAG, "name : " + name);

                String dept = jsonObject1.getString("dept");
                Log.v(TAG, "dept : " + dept);

                String phone = jsonObject1.getString("phone");
                Log.v(TAG, "phone : " + phone);

                JsonStudent student = new JsonStudent(code, name, dept, phone);
                students.add(student);
                Log.v(TAG, student.toString());
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
