package com.example.myapplication.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.io.SvStatus;
import com.example.myapplication.io.SvStatusArrays;
import com.example.myapplication.io.SvStatusArrays2;
import com.example.myapplication.io.Test1;

import java.util.Arrays;

/**
 * date:2021.9.3    Friday
 * gps broadcast receiver
 */
public class BroadcastReceiverGPS extends BroadcastReceiver {
    private static String TAG="BroadcastReceiverGPS:xwg";
    private static final String ACTION1="com.abc";
    private static final String ACTION2="com.adan.gps";
    @Override
    public void onReceive(Context context, Intent intent) {
        String acion=intent.getAction().toString();
        switch (acion){
            case ACTION1:
                Log.i(TAG,"reciver the abc...");
                break;
            case ACTION2:
                Log.i(TAG,"reciver the X...");
//                SvStatusArrays svStatusArrays=
//                        (SvStatusArrays)intent.getSerializableExtra("sv");
//                 Log.i(TAG,"sv bc:"+ Arrays.toString(svStatusArrays.getC()));
                Bundle bundle=intent.getBundleExtra("data");
                SvStatusArrays2 svStatusArrays=
                        (SvStatusArrays2)bundle.getSerializable("sv");
                Log.i(TAG,"sv b[]:"+ Arrays.toString(svStatusArrays.getB()));
                Log.i(TAG,"sv b1[]:"+ Arrays.toString(svStatusArrays.getB1()));
                Log.i(TAG,"sv b2[]:"+ Arrays.toString(svStatusArrays.getB2()));
                Log.i(TAG,"sv c[]:"+ Arrays.toString(svStatusArrays.getC()));
                Log.i(TAG,"sv d[]:"+ Arrays.toString(svStatusArrays.getD()));
                Log.i(TAG,"sv e[]:"+ Arrays.toString(svStatusArrays.getE()));
                Log.i(TAG,"sv f[]:"+ Arrays.toString(svStatusArrays.getF()));
                break;
            default:
        }
    }
}
