package com.example.myapplication.broadcast;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.io.StringUtils;
import com.example.myapplication.io.SvStatus;
import com.example.myapplication.io.SvStatusArrays;
import com.example.myapplication.io.Test1;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

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
        intentFilter.addAction("com.adan.gps");
        broadcastGPS=new BroadcastReceiverGPS();
        registerReceiver(broadcastGPS,intentFilter);

//        启动服务
        serviceGPS=new Intent(this,ServiceGPS.class);
//        startService(serviceGPS);
        btn=(Button) findViewById(R.id.btn_send_broadcast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"send broadcast...");
//                Intent intent=new Intent(TestActivity2.this,
//                        BroadcastReceiverGPS.class);
//                intent.setAction("com.xyz");
//                SvStatus svStatus=new SvStatus();
//                svStatus.setB(1);
//                svStatus.setB1(1);
//                svStatus.setB2(1);
//                svStatus.setC(1f);
//                svStatus.setD(1f);
//                svStatus.setE(1f);
//                svStatus.setF(1f);
                SvStatusArrays svStatusArrays=new SvStatusArrays();
                svStatusArrays.setB(new int[]{1});
                svStatusArrays.setB1(new int[]{1});
                svStatusArrays.setB2(new int[]{1});
                svStatusArrays.setC(new float[]{1});
                svStatusArrays.setD(new float[]{1});
                svStatusArrays.setE(new float[]{1});
                svStatusArrays.setF(new float[]{1});
//                intent.putExtra("sv",svStatus);
//                Test1 test1=new Test1(1,"2");
//                intent.putExtra("test",  test1);
////                intent.putExtra("aa","aa");
                Intent intent=new Intent("com.adan.gps");
//                intent.putExtra("sv",svStatusArrays);
                /**
                 * 参考：
                 * Bundle bundle = intent.getExtras();
                 * bundle.setClassLoader(BFWCNetWorkType.class.getClassLoader());
                 * networkType =(BFWCNetWorkType)bundle.getSerializable("status");
                 * BFWCNetWorkUtil.setCurrentNetworkType(networkType);
                 *
                 */
                Bundle bundle=new Bundle();
                bundle.putParcelable("sv",  svStatusArrays);
                intent.putExtra("data",bundle);
                sendBroadcast(intent);

            }
        });//onbtn
        double []pins = {9,3,7,2};
        float []copy2 = new float[pins.length];
        for(int i=0;i<pins.length;i++) copy2[i]=(float ) pins[i];
//        Log.i(TAG,"copy2:"+Arrays.toString(copy2));
        SvStatusArrays sv=new SvStatusArrays();
        int i=sv.getSvCount();

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