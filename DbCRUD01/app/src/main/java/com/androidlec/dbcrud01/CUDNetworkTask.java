package com.androidlec.dbcrud01;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;

public class CUDNetworkTask extends AsyncTask<Integer, String, Void> {

  // Field
  final static String TAG = "CUDNetworkTask";
  Context context = null;
  String mAddr = null;
  ProgressDialog progressDialog = null;

  // Constructor


    public CUDNetworkTask(Context context, String mAddr) {
        this.context = context;
        this.mAddr = mAddr;
        Log.v(TAG, "Start : " + mAddr);
    }


    @Override
    protected void onPreExecute() {
        Log.v(TAG, "onPreExecute()");
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Create/Update/Delete");
        progressDialog.setMessage("Working ....");
        progressDialog.show();
    }


    @Override
    protected Void doInBackground(Integer... integers) {
        Log.v(TAG, "doInBackground()");
        try{
            URL url = new URL(mAddr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onProgressUpdate(String... values) {
        Log.v(TAG, "onProgressUpdate()");
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Log.v(TAG, "onPostExecute()");
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        Log.v(TAG, "onCancelled()");
        super.onCancelled();
    }
}
