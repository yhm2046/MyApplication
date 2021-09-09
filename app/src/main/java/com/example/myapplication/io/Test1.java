package com.example.myapplication.io;

import java.io.Serializable;

public class Test1 implements Serializable {
    public Test1(){}
    public Test1(int a,String b){
        this.a=a;
        this.b=b;
    }
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    private String b;
}
