package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Handle test
 */
public class HandleActivity extends AppCompatActivity {
    private TextView tvShow;
    private Button btn1,btn2;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:tvShow.setText("btn1 click");break;
                case 2:tvShow.setText("btn2 click");break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);
        tvShow=(TextView) findViewById(R.id.tv_show);
        btn1=(Button) findViewById(R.id.btn_handler1);
        btn2=(Button) findViewById(R.id.btn_handler2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg=new Message();
                msg.what=1;
                handler.sendMessage(msg);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg=new Message();
                msg.what=2;
                handler.sendMessage(msg);
            }
        });
    }
}