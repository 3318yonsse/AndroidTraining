package com.androidlec.networkimage;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkTask extends AsyncTask<Integer, String, Integer> {



   final static String TAG = "NetworkTask";
   Context context = null;
   String mAddr = null;
   ProgressDialog progressDialog = null;
   String devicePath;
   ImageView imageView;



   // constructor 생성
    public NetworkTask(Context context, String mAddr, ImageView imageView) {
        this.context = context;
        this.mAddr = mAddr;
        this.imageView = imageView;
    }







    // progressDialog
    @Override
    protected void onPreExecute() {
        Log.v(TAG, "onPreExecute()");
        progressDialog =  new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dialogue");
        progressDialog.setMessage("down ....");
        progressDialog.show();

    }








    // onProgressUpdate
    // 여기서 빼와서 보여줌
    @Override
    protected void onProgressUpdate(String... values) {
        Log.v(TAG, "onProgressUpdate()");
        super.onProgressUpdate(values);
    }

    //






    @Override
    protected void onPostExecute(Integer integer) {
        Log.v(TAG, "onPostExecute()");
        // 다 돌았으니 화면에 띄워줘야함
        Bitmap bitmap = BitmapFactory.decodeFile(devicePath);
        imageView.setImageBitmap(bitmap);
        // progressDialog를 끝냄
        progressDialog.dismiss();
    }





    // 조건이 초과되면 빠져버리기
    @Override
    protected void onCancelled() {
        Log.v(TAG, "onCancelled()");
        super.onCancelled();
    }






    // 계속 돌고있음, 이미지를 가져오려함
    //doInBackground = AsyncTask가 관리하는 메소드
    // 백그라운드는 다운로드가 끝
    @Override
    protected Integer doInBackground(Integer... integers) {
        Log.v(TAG, "doInBackground()");

        // 톰캣 주소 중 마지막 슬래쉬 뒤에 파일 이름을 가져와야함
        int index = mAddr.lastIndexOf("/");
        String imgName = mAddr.substring(index + 1);
        Log.v(TAG, "urlAddress : " + mAddr);
        Log.v(TAG, "index : " + index);
        Log.v(TAG, "image name : " + imgName);

        // imaga 경로주소를 확인해서 넣어줌
        devicePath = Environment.getDataDirectory().getAbsolutePath() + "/data/com.androidlec.networkimage/files/" + imgName;
        Log.v(TAG, "device path : " + devicePath);

        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try{
            URL url = new URL(mAddr);
            // Http를 사용한다 선언
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            //10초?
            httpURLConnection.setConnectTimeout(10000);

            //파일 크기를 불러옴
            int len = httpURLConnection.getContentLength();
            byte[] bs = new byte[len];

            // httpURLConnection으로 연결이 잘되었다면.
            // input과 output쓸것을 연결한 상태
            if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                fileOutputStream = context.openFileOutput(imgName, 0);

                while (true) {
                    int i = inputStream.read(bs);
                    // 읽어올 data가 없다면
                    if (i < 0) break;
                    fileOutputStream.write(bs, 0, i);
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(inputStream != null) inputStream.close();
                if(fileOutputStream != null) fileOutputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return null;
    }
}
