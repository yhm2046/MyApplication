package com.example.myapplication.io;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.permission.PermissionUtils;

public class IOActivity extends AppCompatActivity {
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
                PermissionUtils.RequestPermissions(IOActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE);
                PermissionUtils.RequestPermissions(IOActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
                String filePath=Environment.getExternalStorageDirectory().getAbsolutePath()
                        +"/gps/json1.xml";
//                写入文件测试
//                Log.i(TAG,"filePath:"+filePath);
//                if(IOUtils.writeSDCardInfo("\n{1,2,3,4,5}",filePath)){
//                    Log.i(TAG,"write success");
//                }
//                else{Log.i(TAG,"write fail!");};
//                读取文件测试
                String str=IOUtils.getSDCardString(filePath);
                Log.i(TAG,"str:"+filePath);
                Log.i(TAG,"read file:"+str);
            }//end onclick
        });
    }

}