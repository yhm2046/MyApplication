package com.example.myapplication.io;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * input and output class
 */
public class IOUtils {
    static final String TAG="IOUtils:azj";

    /**
     * 向sdcard中写入数据
     * @param filePath  写入的完整路径：storage/emulated/0/gps/test.txt
     * @return  获取的字符串
     */
    static public String getSDCardString(String filePath){
        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            return null;
//        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
//                +"/info.txt");  //打开要读的文件
        File file = new File(filePath);
        if(!file.exists())        //文件不存在的情况下
        {
            Log.i("sdcard", "file is Empty");
            return "";
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line=br.readLine())!=null)        //获取每一行数据源
            {
                sb.append(line+"\r\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG,"exception:"+e.toString());
            return null;
        }
    }
}
