package com.example.myapplication.broadcast;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 广播的服务
 * date:2021.9.3    Friday
 *
 */
public class ServiceGPS extends Service {
    BroadcastReceiverGPS broadcastReceiverGPS=null;
    IntentFilter intentFilter=null;
    Intent intentGPS=null;
    public static final String TAG="ServiceGPS:xwg";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCrete");
        intentFilter=new IntentFilter();
        intentFilter.addAction(ConstantGPS.ACTION_GPS2);
        broadcastReceiverGPS=new BroadcastReceiverGPS();
        registerReceiver(broadcastReceiverGPS,intentFilter);
//        每隔2s发送广播：com.xyz
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
//                每隔2s发送广播：com.xyz
                Log.i(TAG,"send broadcast xyz------------");
                Intent intent=new Intent(ServiceGPS.this,
                        BroadcastReceiverGPS.class);
                intent.setAction(ConstantGPS.ACTION_GPS2);
                sendBroadcast(intent);
            }
        };
        timer.schedule(timerTask,1000*1,1000*2);    //延迟1s，每隔2s执行
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
