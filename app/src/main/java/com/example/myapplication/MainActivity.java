package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.io.IOUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.myapplication.TimeUtils.showTimeNow;

public class MainActivity extends AppCompatActivity {
    private String TAG="MainActivity:xwg";
    private Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//       read text from sdcard: sdcard/gps/test.txt, storage/emulated/0/gps/test.txt
        btnShow=(Button) findViewById(R.id.btn_show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"read from sdcard");
//                Log.d(TAG, "getExternalStorageDirectory:  "+
//                        Environment.getExternalStorageDirectory().getAbsolutePath().toString());
                String filePath=Environment.getExternalStorageDirectory().getAbsolutePath()
                        +"/gps/gps.txt";
                String result=IOUtils.getSDCardString(filePath);
                Log.i(TAG,"filePath:"+filePath);
                if(result!=null&&result!=""){
                    Log.i(TAG,"result is:"+result);
                }
                else{Log.i(TAG,"result is null!");};
            }//end onclick
        });
    }

}