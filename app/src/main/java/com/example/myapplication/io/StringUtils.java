package com.example.myapplication.io;

import android.util.Log;

import androidx.annotation.NonNull;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.io.File.separator;

/**
 * 字符串工具类，2021.9.5  Sunday
 */
public class StringUtils {
    private static final String TAG="StringUtils:xwg";

    /**
     * 三种方法判断两个字符串是否相等
     * @param a String
     * @param b String
     */
    public static void isEqual(String a,String b){
        Log.i(TAG,a+"=="+b+":"+(a==b)); //相等true，否则false
        Log.i(TAG,a+"equals("+b+"):"+(a.equals(b)));//相等true，否则false
        Log.i(TAG,a+".indexOf("+b+"):"+(a.indexOf(b)));//相等0，否则-1
    }

    /**
     * 2021.9.8 Wednsday
     * 字符串数组转成字符串变量：[a,b,c]->{a,b,c}
     * @param str   原数组
     * @return String 字符串
     */
    @NonNull
    public static String getString(String[] str) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length; i++){
            sb.append(str[i]);
            if(i<str.length-1) sb.append(",");
        }
        return sb.toString();
    }

    /**
     * 合并两个String数组
     * @param a String[] 可以包含空串“”
     * @param b String[] 可以包含空串“”
     * @return String[] 可以包含空串“”
     */
    public static String[] getStringArraysSumImprove(String a[],String b[]) {
        if(a==null&&b!=null) return b;
        if(a!=null&&b==null) return a;
        if(a==null&&b==null) return null;
        int alen=a.length;
        int blen=b.length;
        a=Arrays.copyOf(a,alen+blen);
        System.arraycopy(b,0,a,alen,blen);
        return a;
    }

    /**
     * 合并两个float数组
     * @param a float[]
     * @param b float[]
     * @return float[]
     */
    public static float[] getFloatArraysSumImprove(float a[],float b[]) {
        if(a==null&&b!=null) return b;
        if(a!=null&&b==null) return a;
        if(a==null&&b==null) return null;
        FloatBuffer floatBuffer = FloatBuffer.allocate(a.length+b.length);
        floatBuffer.put(a);
        floatBuffer.put(b);
        float sum[]=floatBuffer.array();
        return sum;
    }

    /**
     * 合并两个int数组
     * @param a int[]
     * @param b int[]
     * @return int[]
     */
    public static int[] getIntArraysSumImprove(int a[],int b[]) {
        if(a==null&&b!=null) return b;
        if(a!=null&&b==null) return a;
        if(a==null&&b==null) return null;
        IntBuffer intBuffer = IntBuffer.allocate(a.length+b.length);
        intBuffer.put(a);
        intBuffer.put(b);
        int sum[]=intBuffer.array();
        return sum;
    }

    /**
     * 合并两个int数组,2021.9.7
     * @param array1    int[]
     * @param array2    int[]
     * @return  int[]
     */
    public static int[] getIntArraysSum(int array1[],int array2[]) {
        int c[]=new int[array1.length+array2.length];
        if (c.length==0) return null;
        for(int i=0;i<array1.length;i++){
            c[i]=array1[i];
        }
        for(int i=0;i<array2.length;i++){
            c[i+array2.length]=array2[i];
        }
//        Log.i(TAG,"c[]:"+Arrays.toString(c));
        return c;
    }
    public static SvStatusArrays getGSV(String []result){


/*
* 伪代码
* 按照$gpgsv分割字符串数组
* for循环获取卫星类的每个数据
* 返回卫星类
* */
        SvStatusArrays svStatusArrays=null;
        int b[]=null;
        int b1[]=null;
        int b2[]=null;
        float c[]=null;
        float d[]=null;
        float e[]=null;
        float f[]=null;
        for(int i=0;i<result.length;i++){
            if(result[i].equals("")){}
        }
        return null;
    }
    /**
     * 解析gsv数据返回SvStatusArrays 类：7个数组,
     * @param result []String，原始数组
     * @return SvStatusArrays类
     */
    public static SvStatusArrays getSvStatusArrays(String []result){
        SvStatusArrays svStatusArrays=null;
        int b[]=null;
        int b1[]=null;
        int b2[]=null;
        float c[]=null;
        float d[]=null;
        float e[]=null;
        float f[]=null;
        if(result.length<=8) Log.i(TAG,"no date");
        else{
            int count= (result.length-8)/4; //卫星数目
            b=new int[count];   //卫星号
            b1=new int[count];      //卫星类型
            b2=new int[count];      //可用卫星
            c=new float[count];     //性噪比
            d=new float[count];     //卫星高度
            e=new float[count];     //方位角
            f=new float[count];     //载波频率
            for(int i=8,j=0;i<result.length;i+=4,j++){
                Log.i(TAG,"id:"+result[i]);
                b[j]=Integer.valueOf(result[i]).intValue();
                if(result[0].indexOf("$PQGSV")!=-1) b1[j]=5;
                else b1[j]=1;//卫星类型，beidou:5,gps:1
                b2[j]=Integer.valueOf(result[3]).intValue();
                if(result[i+3]==null||result[i+3].equals("")) c[j]=0;//信噪比
                else    c[j]=Float.valueOf(result[i+3]).floatValue();
                Log.i(TAG,"result[i+3]"+result[i+3]);
                d[j]=Float.valueOf(result[i+1]).floatValue();
                e[j]=Float.valueOf(result[i+2]).floatValue();
                f[j]=1.57542003E9f;
            }//end for
            svStatusArrays=new SvStatusArrays(
                    b,b1,b2,c,d,e,f
            );
            Log.i(TAG,"b[]="+Arrays.toString(svStatusArrays.getB()));
            Log.i(TAG,"b1[]="+Arrays.toString(svStatusArrays.getB1()));
            Log.i(TAG,"b2[]="+Arrays.toString(svStatusArrays.getB2()));
            Log.i(TAG,"c[]="+Arrays.toString(svStatusArrays.getC()));
            Log.i(TAG,"d[]="+Arrays.toString(svStatusArrays.getD()));
            Log.i(TAG,"e[]="+Arrays.toString(svStatusArrays.getE()));
            Log.i(TAG,"f[]="+Arrays.toString(svStatusArrays.getF()));
        }//end else
        return svStatusArrays;
    }

    /**
     * 返回分割后的字符串数组
     * str="$PQGSV,4,1,16,01,45,122,38,02,47,237,32,03,63,188,32,09,56,248,25*64";
     * 转成[$PQGSV, 4, 1, 16, 01, 45, 122, 38, 02, 47, 237, 32, 03, 63, 188, 32, 09, 56, 248, 25]
     * @param source String 原始字符串
     * @return  String[] 目标数组,可以包含空串“”
     */
    public static String[] splitArrays(String source){
        String[] str1 = source.split(",");
//        Log.i(TAG,"1.lenth:"+str1.length+",str1[]:"+ Arrays.toString(str1));
        for(int i=0;i<str1.length;i++){
            if(str1[i].indexOf('*')!=-1){   //包含*
                String []tmp=str1[i].split("\\*");
                str1[i]=tmp[0];
            }
        }
//        Log.i(TAG,"2.lenth:"+str1.length+",str1[]:"+ Arrays.toString(str1));
        return str1;
    }//end StringUtils
}
