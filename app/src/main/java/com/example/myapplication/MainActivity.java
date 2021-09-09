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
        String s="$GPGSV, 2, 1, 05, 10, 25, 172, 41, 26, 61, 219, 47, 29, 19, 085, 36, 32, 59, 077, 36, ," +
                "$GPGSV, 2, 2, 05, 31, 50, 341";
        String s2="11";
        String []a={"1","","3"};
        String []b={"7","8",""};
        String []tmp=StringUtils.getStringArraysSumImprove(a,b);
        Log.i(TAG,"abc len:"+"abc".length());
        Log.i(TAG,"[]tmp:"+Arrays.toString(tmp));
    }//end oncreate




}