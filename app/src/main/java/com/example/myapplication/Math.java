package com.example.myapplication;

/**
 * build 2021.8.26  Thursday
 * 数学算法
 */
public class Math {
    /**
     * 将字节数组转换为16进制字符串
     * @param bytes
     * @return
     */
    public static String binaryToHexString(byte[] bytes) {
        if (bytes == null || bytes.length == 0) return "";
        String hexStr = "0123456789ABCDEF";
        StringBuilder result = new StringBuilder("");
        String hex = "";
        for (byte b : bytes) {
            hex = String.valueOf(hexStr.charAt((b & 0xF0) >> 4));
            hex += String.valueOf(hexStr.charAt(b & 0x0F));
            result.append(hex);
            //result += hex + " ";//可加空格分割
        }
        return result.toString();
    }

    /**
     * 将一组十六进制字符转换成字节数组
     * @param hexString
     * @return
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        // toUpperCase将字符串中的所有字符转换为大写
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        // toCharArray将此字符串转换为一个新的字符数组。
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * 返回在指定字符的第一个发生的字符串中的索引，即返回匹配字符
     * @param c
     * @return
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
    //最小公倍数:lest common multiple
    public static int lcm(int p,int q){
       /* calculation process
        int r=gcb(p,q);
        return r*(p/r)*(q/r);
        */
        return p*q/gcb(p,q);    //simple version
    }
    //最大公约数:greatest common divisor
    public static int gcb(int p,int q){
       /*calculation process
       if(q==0)
            return p;
        int r=p%q;
        return gcb(q,r);
        */
        return (p%q==0)?q:gcb(q,p%q); //simple version
    }
}
