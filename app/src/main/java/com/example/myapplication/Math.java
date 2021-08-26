package com.example.myapplication;

/**
 * build 2021.8.26  Thursday
 * 数学算法
 */
public class Math {
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
