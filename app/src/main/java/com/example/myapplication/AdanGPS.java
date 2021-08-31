package com.example.myapplication;

import android.util.Log;

import java.util.Arrays;

/**
 * build 2021.8.26  Thursday
 * gps相关方法
 */
public class AdanGPS {
    private static final String TAG="AdanGPS:xwg";

    /**
     * 移除校验码
     * @param string
     * @return
     */
    public static String removeCheckSum(String string){
        return string.substring(0,string.length() - 2);
    }
    public static void decodeMsg(String msg) {
        if (!msg.startsWith("4D442E2E")) {
            Log.i(TAG,"not start with 4D442E2E");
            return;
        }
        if (msg == null || msg.length() <= 12) {
            //长度过短
            Log.i("decodeMsg", "Too Short");
            return;
        }
        byte[] totalBytes = hexStringToByteArray(msg);   //[77, 68, 46, 46, 2, -73,...]转成十进制数字
        Log.i(TAG,"totalBytes:"+ Arrays.toString(totalBytes));
        Log.i(TAG,"totalBytes size:"+ totalBytes.length);
       dHex("decodeMsg", totalBytes, totalBytes.length);   //4D 44 2E 2E 02 B7。。，打印十六进制数字
        if (totalBytes[totalBytes.length - 1] != getCheckSum(totalBytes)) {
            //检验出错
            Log.i("decodeMsg", "CheckSum Error");
            return;
        }
        if (totalBytes[0] == 0x4D
                && totalBytes[1] == 0x44
                && totalBytes[2] == 0x2E
                && totalBytes[3] == 0x2E) { //message header头文件
            int messageSize = ((totalBytes[4] & 0xff) << 8) | (totalBytes[5] & 0xff);
            Log.i("decodeMsg", "messageSize : " + messageSize);
            if (messageSize == totalBytes.length - 9) {//message header 4位+message size 2位
//                                                        +dispatcher message length 2位+ checksum 1 位
                int applicationID = ((totalBytes[10] & 0xff) << 8) | (totalBytes[11] & 0xff);
                Log.i("decodeMsg", "applicationID : " + Integer.toHexString(applicationID));
                switch (applicationID) {
                    case 0x3001:
//                        decodeGpsMsg(msg);
                        Log.i(TAG,"定位信息查询设置");
                        break;
                    case 0x3003:
//                        decodeNetMsg(msg);
                        Log.i(TAG,"网络信息查询设置");
                        break;
                    case 0x3005:
//                        decodeVin(msg);
                        Log.i(TAG,"VIN信息查询设置");
                        break;
                    default:Log.i(TAG,"nothing!");
                }
            }
        }
    }

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
            b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
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
//            b = (byte) (b ^ bytes[i]);
            b^=bytes[i];
        }
        return b;
    }

    /**
     * 10进制字节还原成16进制数，[77, 68, 46, 46] -> 4D 44 2E 2E
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
        Log.i(tag, sb.toString().toUpperCase().trim());
    }
}
