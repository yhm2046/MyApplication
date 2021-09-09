package com.example.myapplication.io;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * 卫星类，2021.9.4 Saturday，Serializable序列化可以用广播传输
 */
public class SvStatus implements Serializable {
    int b;
    int b1;
    int b2;
    float c;
    float d;
    float e;
    float f;

    public SvStatus(){}

    public SvStatus(int b, int b1, int b2,
                    float c, float d, float e, float f) {
        this.b=b;
        this.b1=b1;
        this.b2=b2;
        this.c=c;
        this.d=d;
        this.e=e;
        this.f=f;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getB1() {
        return b1;
    }

    public void setB1(int b1) {
        this.b1 = b1;
    }

    public int getB2() {
        return b2;
    }

    public void setB2(int b2) {
        this.b2 = b2;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    public float getD() {
        return d;
    }

    public void setD(float d) {
        this.d = d;
    }

    public float getE() {
        return e;
    }

    public void setE(float e) {
        this.e = e;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(b);
//    }
//    protected SvStatus(Parcel in){
//        b=in.readInt();
//    }
//    public static final Creator<SvStatus>CREATOR =new Creator<SvStatus>() {
//        @Override
//        public SvStatus createFromParcel(Parcel source) {
//            return new SvStatus(source);
//        }
//
//        @Override
//        public SvStatus[] newArray(int size) {
//            return new SvStatus[size];
//        }
//    };
}
