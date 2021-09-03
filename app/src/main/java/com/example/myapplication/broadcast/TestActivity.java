package com.example.myapplication.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

/**
 * date:2021.9.3    Friday
 * 静态广播例子
 * https://www.cnblogs.com/senior-engineer/p/11237518.html
 */
public class TestActivity extends AppCompatActivity {
    private String TAG="TestActivity:xwg";
    Button btn;
    BroadcastReceiverGPS broadcastGPS=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_broadcast);
        Log.i(TAG,"TestActivity--------------");
//        Intent intent=new Intent(TestActivity.this,MainActivity.class);
//        startActivity(intent);
//        finish();
//        BroadcastGPS broadcastGPS=new BroadcastGPS();
//        registerReceiver(broadcastGPS);
        btn=(Button) findViewById(R.id.btn_send_broadcast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"send broadcast...");
//                broadcastGPS=new BroadcastReceiverGPS();
//                registerReceiver(broadcastGPS,new IntentFilter(
//                        "com.abc"));
                Intent intent=new Intent(TestActivity.this,
                        BroadcastReceiverGPS.class);
                intent.setAction("com.abc");
                sendBroadcast(intent);
            }
        });
    }//onCreate

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (broadcastGPS!=null){
//            unregisterReceiver(broadcastGPS);
//            broadcastGPS=null;
//        }
    }
}