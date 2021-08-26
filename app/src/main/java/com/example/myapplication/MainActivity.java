package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private String TAG="MainActivity:xwg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       String str="4d442e2e";
       byte[] array=AdanGPS.hexStringToByteArray(str);
       Log.i(TAG, "array:"+Arrays.toString(array));  //AB:-85,cc:-52
        byte[]array2={11,23,55,67};
        AdanGPS.dHex("xwg:array2",array2,array2.length);
        Log.i(TAG,"check:"+AdanGPS.getCheckSum(array));


        Log.i(TAG,"a:"+AdanGPS.getCheckSum(new byte[]{0x22,0x11,0x11,0x32}));
        Log.i(TAG,"b:"+AdanGPS.getCheckSum(new byte[]{0x22,0x11,0x11,0x32}));
        Log.i(TAG,"c:"+AdanGPS.getCheckSum(new byte[]{2,2,4,4,1,2}));

        String hex="3444343432453245303030373030303630303031333030313030303130313338";
        Log.i(TAG,"hex len:"+hex.length());
    }

}