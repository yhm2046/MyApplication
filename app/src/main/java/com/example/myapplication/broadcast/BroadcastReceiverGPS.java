package com.example.myapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * date:2021.9.3    Friday
 * gps broadcast receiver
 */
public class BroadcastReceiverGPS extends BroadcastReceiver {
    private String TAG="BroadcastGPS:xwg";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.abc")){
            Log.i(TAG,"reciver the broadcase...");
        }
    }
}
