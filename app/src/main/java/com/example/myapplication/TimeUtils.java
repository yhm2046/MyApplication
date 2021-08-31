package com.example.myapplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2021.8.31 Tuesday
 * 时间工具类
 */
public class TimeUtils {
    /**
     * 显示当前时间
     * reference：https://www.runoob.com/java/date-time-datetime.html
     */
    public static String showTimeNow() {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
//        System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制）
        return sdf.format(date)+"";
    }
}
