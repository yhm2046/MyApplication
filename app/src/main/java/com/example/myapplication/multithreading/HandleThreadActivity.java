package com.example.myapplication.multithreading;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

/**
 * 2021.8.31 Tuesday
 * HandleThread test，handleThread用法，子线程和子线程中间通信
 * reference：
 * https://blog.csdn.net/ly502541243/article/details/52414637?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-5.control&spm=1001.2101.3001.4242
 */
public class HandleThreadActivity extends AppCompatActivity {
    private static final String TAG="HandleThreadActivity:azj";
    private TextView tvShow;
    private Button btn1,btn2;
    HandlerThread handlerThread;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);
        handlerThread=new HandlerThread("handlerThread");
        handlerThread.start();
        //必须在handlerThread创建运行后执行否则报空指针错误
        handler=new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        Log.i(TAG,"btn1 send...");
//                        tvShow.setText("btn1 click"); //不能更新ui否则报错
                        break;
                    case 2:
                        Log.i(TAG,"btn2 send...");
//                        tvShow.setText("btn2 click");
                        break;
                }
            }
        };
        tvShow=(TextView) findViewById(R.id.tv_show);
        btn1=(Button) findViewById(R.id.btn_handler1);
        btn2=(Button) findViewById(R.id.btn_handler2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           Thread.sleep(1000);
                           handler.sendEmptyMessage(1);
                       }catch (InterruptedException e){
                           e.printStackTrace();
                           Log.i(TAG,"btn1 error:"+e.toString());
                       }
                   }
               }).start();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            handler.sendEmptyMessage(2);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                            Log.i(TAG,"btn1 error:"+e.toString());
                        }
                    }
                }).start();
            }
        });
    }//end onCreate

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();
    }
}