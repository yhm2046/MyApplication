package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.io.StringUtils;

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
        String[] str = {"$GPGSV","028","09"};
        String sb = StringUtils.getString(str);
        Log.i(TAG,"sb:"+sb.toString());
    }//end oncreate




}