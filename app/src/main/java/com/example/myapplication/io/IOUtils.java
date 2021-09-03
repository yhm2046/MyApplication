package com.example.myapplication.io;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * input and output class
 */
public class IOUtils {
    static final String TAG="IOUtils:azj";

    /**
     * reference:https://cloud.tencent.com/developer/article/1582237
     * read text from sdcard
     * @param content   写入内容
     * @param filePath 文件完整路径
     * @return  写入成功true，否则false
     */
    static public boolean writeSDCardInfo(String content,String filePath){
        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            return false;
//        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
//                +"/info.txt");
        File file = new File(filePath);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            fos.flush();
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG,"writeSDCardInfo exception:"+e.toString());
            return false;
        }
    }
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
