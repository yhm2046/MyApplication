package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.io.IOUtils;
import com.example.myapplication.permission.PermissionUtils;

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
                Log.i(TAG,"write");
//                 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
//    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
                PermissionUtils.RequestPermissions(MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE);
                PermissionUtils.RequestPermissions(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
                String filePath=Environment.getExternalStorageDirectory().getAbsolutePath()
                        +"/gps/gps.txt";
//                String result=IOUtils.getSDCardString(filePath);
                Log.i(TAG,"filePath:"+filePath);
                if(IOUtils.writeSDCardInfo("azj2",filePath)){
                    Log.i(TAG,"write success");
                }
                else{Log.i(TAG,"write fail!");};
            }//end onclick
        });
    }

}