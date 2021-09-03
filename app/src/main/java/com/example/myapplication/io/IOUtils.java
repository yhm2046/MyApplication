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
        File file = new File(filePath);
        try {
            FileOutputStream fos = new FileOutputStream(file,true);
            //以追加而非覆盖方式写入，若覆盖写入为new FileOutputStream(file)
//            reference:https://www.cnblogs.com/renhui/p/8656586.html
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
     * 从sdcard中读数据
     * @param filePath  读文件的完整路径：storage/emulated/0/gps/test.txt
     * @return  获取的字符串，有输出string，无返回null
     */
    static public String getSDCardString(String filePath){
        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            return null;
        File file = new File(filePath);
        if(!file.exists())        //文件不存在的情况下
        {
            Log.i("sdcard", "file is Empty");
            return "";
        }
        try {
            FileInputStream fis = new FileInputStream(file);
//            加速获取多行数据：
//            https://stackoverflow.com/questions/5172284/faster-way-than-scanner-or-bufferedreader-reading-multiline-data-from-stdin
            BufferedReader br = new BufferedReader(new InputStreamReader(fis),32*1024*1024);
            StringBuilder sb = new StringBuilder();
            while (br.ready()) {
                String line = br.readLine();
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
