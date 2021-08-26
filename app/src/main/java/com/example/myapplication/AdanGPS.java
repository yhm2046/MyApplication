package com.example.myapplication;

import android.util.Log;

/**
 * build 2021.8.26  Thursday
 * gps相关方法
 */
public class AdanGPS {
    /**
     * 16进制表示的字符串转换为字节数组，//4d442e2e ->  [77, 68, 46, 46]
     *
     * @param s String 16进制表示的字符串,必须偶数位，比如aa，cdef
     * @return byte[] 字节数组
     */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] b = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
            b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return b;
    }   //hexStringToByteArray

    /**
     *校验数据是否重复，除最后一位外。
     * @param bytes byte[]  字节数组
     * @return  byte 重复的数
     */
    public static byte getCheckSum(byte[] bytes) {
        byte b = 0x00;
        for (int i = 0; i < bytes.length-1 ; i++) {
            b = (byte) (b ^ bytes[i]);
        }
        return b;
    }

    /**
     * 字节还原成16进制数，[77, 68, 46, 46] -> 4D 44 2E 2E
     * @param tag   String:打印的标志
     * @param buf   byte[]:字节数组
     * @param len   int：字节数组长度
     */
    public static void dHex(String tag, byte[] buf, int len) {
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < len; n++) {
            String stmp = Integer.toHexString(buf[n] & 0xFF);
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
            sb.append(" ");
        }
        Log.d(tag, sb.toString().toUpperCase().trim());
    }
}
