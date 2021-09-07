package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

import static com.example.myapplication.io.StringUtils.getIntArraysSum;

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
        int b[]={7,8,9};
        Log.i(TAG,"c[]:"+Arrays.toString(getIntArraysSum(a,b)));

    }//end oncreate



}