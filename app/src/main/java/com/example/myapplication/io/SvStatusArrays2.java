package com.example.myapplication.io;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * 卫星数组类，2021.9.5 Sunday
 */
public class SvStatusArrays2 implements Serializable {
    int b[];
    int b1[];
    int b2[];
    float c[];
    float d[];
    float e[];
    float f[];

    public SvStatusArrays2(){}

    public SvStatusArrays2(int b[], int b1[], int b2[],
                           float c[], float d[], float e[], float f[]) {
        this.b=b;
        this.b1=b1;
        this.b2=b2;
        this.c=c;
        this.d=d;
        this.e=e;
        this.f=f;
    }



    /**
     * 获取卫星数量
     * @return
     */
    public int getSvCount(){
        if(b==null) return 0;
        return b.length;
    }
    public int[] getB() {
        return b;
    }

    public void setB(int[] b) {
        this.b = b;
    }

    public int[] getB1() {
        return b1;
    }

    public void setB1(int[] b1) {
        this.b1 = b1;
    }

    public int[] getB2() {
        return b2;
    }

    public void setB2(int[] b2) {
        this.b2 = b2;
    }

    public float[] getC() {
        return c;
    }

    public void setC(float[] c) {
        this.c = c;
    }

    public float[] getD() {
        return d;
    }

    public void setD(float[] d) {
        this.d = d;
    }

    public float[] getE() {
        return e;
    }

    public void setE(float[] e) {
        this.e = e;
    }

    public float[] getF() {
        return f;
    }

    public void setF(float[] f) {
        this.f = f;
    }

}
