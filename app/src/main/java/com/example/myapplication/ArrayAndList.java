package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Array and List conversion 数组和list互相转换
 */
public class ArrayAndList<I extends Number> extends AppCompatActivity {
    private static final String TAG="ArrayAndList:xwg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        test getListToArray
/*        ArrayList intList=new ArrayList();
        intList.add(0);
        intList.add(1);
        intList.add(2);
        intList.add(3);
        getListToArray(intList);    */
/*******************************************************/
        int test1[]={2,4,6};
        getArray2List(test1);

    }

    /**
     * array conversion to list
     * @param array
     * @return
     */
    public ArrayList<Integer> getArray2List(int[] array){
        if(array.length==0||array==null)
            return null;
        else{
            ArrayList<Integer>integerList=new ArrayList<>();
            for (int i=0;i<array.length;i++)
                integerList.add(array[i]);
            Log.i(TAG,"ArrayList is :"+ Arrays.toString(integerList.toArray()));    //using array format:使用数组格式打印list
            return integerList;
        }
    }

    /**
     * Arraylist conversion to Array
     * @param list
     * @return
     */
    public int[] getListToArray(ArrayList<Integer> list){
        if(list==null||list.size()==0)
            return null;
        else{
        int[] array=new int[list.size()];
        int i=0;
        for(Integer tmp:list)
            array[i++]=tmp;
            Log.i(TAG,"array is:"+ Arrays.toString(array));
        return array;
        }
    }
}