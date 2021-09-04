package com.example.myapplication.io;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.example.myapplication.permission.PermissionUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021.9.4 Saturday，json原生解析
 */
public class JSONActivity extends AppCompatActivity {
    private String TAG="JSONActivity:xwg";
    List<SvStatus>list; //json
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"oncreate");
        PermissionUtils.RequestPermissions(JSONActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        PermissionUtils.RequestPermissions(JSONActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        String filePath= Environment.getExternalStorageDirectory().getAbsolutePath()
                +"/gps/json1.xml";
        String jsonStr=IOUtils.getSDCardString(filePath);
        try {
            JSONObject jb=new JSONObject(jsonStr);
            JSONArray jsonArray=jb.getJSONArray("svstatus");
            list=new ArrayList<SvStatus>();
            /*
            * {"SvStatus":[
{"b":"2","b1":"1","b2":"1","c":"32.0f","d":"33.0f","e":"295.0f","f":"1.57542003E9f"},
"b":"4","b1":"1","b2":"1","c":"12.0f","d":"20.0f","e":"64.0f","f":"1.57542003E9f"},
"b":"6","b1":"1","b2":"1","c":"38.0f","d":"55.0f","e":"340.0f","f":"1.57542003E9f"},
]}
* Jasonobject = new JSONObject(builder.toString());
jarray = Jasonobject.getJSONArray("table2");
            * */
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                if(jsonObject!=null){
                    int b=jsonObject.optInt("b");
                    int b1=jsonObject.optInt("b1");
                    int b2=jsonObject.optInt("b2");
                    float c=jsonObject.optInt("c");
                    int d=jsonObject.optInt("d");
                    int e=jsonObject.optInt("e");
                    int f=jsonObject.optInt("f");
                    SvStatus svStatus=new SvStatus(b,b1,b2,c,d,e,f);
                    list.add(svStatus);
                }
            }//for
            for(int i=0;i<list.size();i++){
                SvStatus ss=list.get(i);
                Log.i(TAG,"b:"+ss.getB()+
                        ",b1:"+ss.getB1()+
                        ",b2:"+ss.getB2()+
                        ",c:"+ss.getC()+
                        ",d"+ss.getD()+
                        ",e"+ss.getE()+
                        ",f"+ss.getF());
            }
        }catch (JSONException e){
            e.printStackTrace();
            Log.i(TAG,"json read error:"+e.toString());

        }
    }
}