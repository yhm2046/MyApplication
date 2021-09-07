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
import com.example.myapplication.io.StringUtils;
import com.example.myapplication.io.SvStatusArrays;
import com.example.myapplication.permission.PermissionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.example.myapplication.TimeUtils.showTimeNow;

public class MainActivity extends AppCompatActivity {
    private String TAG="MainActivity:xwg";
    private Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow=(Button) findViewById(R.id.btn_show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"write");
/*
* $PQGSV,4,1,16,01,45,122,38,02,47,237,32,03,63,188,32,09,56,248,25*64


解析以上string，转换为
b[]={} 卫星号
b1[]={} 卫星类型
b2[]={} 可用卫星
d[]={} 信噪比
d[]={} 海拔
e[]={} 方位角
f[]={} 载波频率
//* */

            }//end onclick
        });//end button
        String str="$PQGSV,1,1,0,*73";
        String s2="$GPGSV,3,3,09,32,08,251,*4F";

        String []result= StringUtils.splitArrays(str);
        
        if(result.length>=8) Log.i(TAG,"useful");
        else Log.i(TAG,"unuseful");
        Log.i(TAG,"len:"+result.length+",result[]:"+Arrays.toString(result));
//                生成7个数组
        SvStatusArrays svStatusArrays=StringUtils.getSvStatusArrays(result);

    }//end oncreate

}