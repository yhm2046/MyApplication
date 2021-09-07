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
import static com.example.myapplication.io.StringUtils.getStringArraysSumImprove;

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
        String []s1=null;
        String []s2=null;
        String []s3=getStringArraysSumImprove(s1,s2);
        if(s3==null) Log.i(TAG,"s3 is null");
        else Log.i(TAG,"s3:"+Arrays.toString(s3));
    }//end oncreate




}