package com.example.myapplication.broadcast;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * 广播的服务
 * date:2021.9.3    Friday
 *
 */
public class ServiceGPS extends Service {
    BroadcastReceiverGPS broadcastReceiverGPS=null;
    IntentFilter intentFilter=null;
    public static final String TAG="ServiceGPS:xwg";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCrete");
        intentFilter=new IntentFilter();
        intentFilter.addAction(ConstantGPS.ACTION_GPS2);
        broadcastReceiverGPS=new BroadcastReceiverGPS();
        registerReceiver(broadcastReceiverGPS,intentFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (broadcastReceiverGPS!=null){
            unregisterReceiver(broadcastReceiverGPS);
            broadcastReceiverGPS=null;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
