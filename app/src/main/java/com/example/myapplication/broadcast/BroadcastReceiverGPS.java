package com.example.myapplication.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.myapplication.io.SvStatus;
import com.example.myapplication.io.Test1;

/**
 * date:2021.9.3    Friday
 * gps broadcast receiver
 */
public class BroadcastReceiverGPS extends BroadcastReceiver {
    private static String TAG="BroadcastGPS:xwg";
    private static final String ACTION1="com.abc";
    private static final String ACTION2="com.xyz";
    @Override
    public void onReceive(Context context, Intent intent) {
        String acion=intent.getAction().toString();
        switch (acion){
            case ACTION1:
                Log.i(TAG,"reciver the abc...");
                break;
            case ACTION2:
                Log.i(TAG,"reciver the X...");
//                String aa=intent.getStringExtra("aa");
                Test1 test1= (Test1)(intent.getSerializableExtra("test"));
                Log.i(TAG,"test1:"+test1.getA());
                SvStatus svStatus= (SvStatus) (intent.getSerializableExtra("sv"));
                 Log.i(TAG,"sv:"+svStatus.getC());
                    break;
            default:
        }
    }
}
