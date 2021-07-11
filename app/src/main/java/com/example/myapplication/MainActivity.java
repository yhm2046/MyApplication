package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private String TAG="MainActivity:xwg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"lcm(100,15)="+lcm(100,15));
        Log.i(TAG,"gcb(100,15)="+gcb(100,15));

    }
    //最小公倍数:lest common multiple
    public static int lcm(int p,int q){
       /* calculation process
        int r=gcb(p,q);
        return r*(p/r)*(q/r);
        */
        return p*q/gcb(p,q);    //simple version
    }
    //最大公约数:greatest common divisor
    public static int gcb(int p,int q){
       /*calculation process
       if(q==0)
            return p;
        int r=p%q;
        return gcb(q,r);
        */
        return (p%q==0)?q:gcb(q,p%q); //simple version
    }
}