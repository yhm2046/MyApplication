package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.nio.IntBuffer;
import java.util.Arrays;

import static com.example.myapplication.io.StringUtils.getFloatArraysSumImprove;
import static com.example.myapplication.io.StringUtils.getIntArraysSumImprove;

public class MainActivity extends AppCompatActivity {
    private String TAG="MainActivity:xwg";
    private Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow=(Button) findViewById(R.id.btn_show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"write");

            }//end onclick
        });//end button
        int a[]={1,2,3};
        int b[]=null;
        float[] f1= null;
        float[] f2= null;
        int[] sum = getIntArraysSumImprove(a,b);
        float[] s2=getFloatArraysSumImprove(f1,f2);
        if(sum==null) Log.i(TAG,"sum==null");
        else Log.i(TAG,"sum[]:"+Arrays.toString(sum));
        if(s2==null) Log.i(TAG,"s2==null");
        else Log.i(TAG,"s2:"+Arrays.toString(s2));
    }//end oncreate




}