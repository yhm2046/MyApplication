package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.io.IOUtils;
import com.example.myapplication.permission.PermissionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
        Log.i(TAG,"MainActivity--------------");
//       read text from sdcard: sdcard/gps/test.txt, storage/emulated/0/gps/test.txt
        btnShow=(Button) findViewById(R.id.btn_show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"write");
                PermissionUtils.RequestPermissions(MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE);
                PermissionUtils.RequestPermissions(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);

                String filePath=Environment.getExternalStorageDirectory().getAbsolutePath()
                        +"/gps/gps.txt";
//                写入文件测试
                Log.i(TAG,"filePath:"+filePath);
                if(IOUtils.writeSDCardInfo("\n{1,2,3,4,5}",filePath)){
                    Log.i(TAG,"write success");
                }
                else{Log.i(TAG,"write fail!");};
//                读取文件测试
                String str=IOUtils.getSDCardString(filePath);
                Log.i(TAG,"str:"+filePath);
                Log.i(TAG,"read file:"+str);
            }//end onclick
        });
    }

}