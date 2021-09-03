package com.example.myapplication.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

/**
 * date:2021.9.3    Friday
 * 动态播例子
 */
public class TestActivity2 extends AppCompatActivity {

    private String TAG="TestActivity:xwg";
    Button btn;
    BroadcastReceiverGPS broadcastGPS=null;
    IntentFilter intentFilter=null;
    Intent serviceGPS=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_broadcast);
        Log.i(TAG,"动态广播--------------");
        intentFilter=new IntentFilter();
        intentFilter.addAction(ConstantGPS.ACTION_GPS2);
        broadcastGPS=new BroadcastReceiverGPS();
        registerReceiver(broadcastGPS,intentFilter);
//        启动服务
        serviceGPS=new Intent(this,ServiceGPS.class);
        startService(serviceGPS);
        btn=(Button) findViewById(R.id.btn_send_broadcast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"send broadcast...");
                Intent intent=new Intent(TestActivity2.this,
                        BroadcastReceiverGPS.class);
                intent.setAction("com.xyz");
                sendBroadcast(intent);
            }
        });
    }//onCreate

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (broadcastGPS!=null){
            unregisterReceiver(broadcastGPS);
            broadcastGPS=null;
        }
        if (serviceGPS!=null){stopService(serviceGPS);}
    }
}