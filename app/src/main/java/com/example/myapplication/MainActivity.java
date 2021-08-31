package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.myapplication.TimeUtils.showTimeNow;

public class MainActivity extends AppCompatActivity {
    private String TAG="MainActivity:xwg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       String string2=Integer.toHexString((0x23&0xff));
//        Log.i(TAG,"0x2300|0x30:"+Integer.toHexString((0x2300|0x30)));
//        String hex="4D 44 2E 2E 02 8F 00 06 02 62 30 01 00 03 24 47 50 47 47 41 2C 31 32 32 32 31 32 2E 30 30 2C 32 32 33 36 2E 31 39 36 32 37 31 2C 4E 2C 31 31 33 35 30 2E 35 38 33 36 30 38 2C 45 2C 31 2C 30 38 2C 31 2E 30 2C 2D 33 32 2E 34 2C 4D 2C 2D 32 2E 30 2C 4D 2C 2C 2A 36 42 0D 0A 24 47 50 52 4D 43 2C 31 32 32 32 31 32 2E 30 30 2C 41 2C 32 32 33 36 2E 31 39 36 32 37 31 2C 4E 2C 31 31 33 35 30 2E 35 38 33 36 30 38 2C 45 2C 30 2E 30 2C 2C 31 39 30 38 32 31 2C 32 2E 32 2C 57 2C 41 2A 30 33 0D 0A 24 47 50 47 53 56 2C 33 2C 31 2C 31 31 2C 31 30 2C 38 32 2C 31 38 30 2C 33 38 2C 31 32 2C 32 38 2C 30 35 33 2C 33 31 2C 32 33 2C 34 35 2C 31 34 39 2C 33 32 2C 32 35 2C 35 34 2C 30 38 34 2C 32 34 2A 37 45 0D 0A 24 47 50 47 53 56 2C 33 2C 32 2C 31 31 2C 32 36 2C 31 30 2C 32 30 31 2C 31 38 2C 33 31 2C 34 30 2C 32 35 38 2C 32 33 2C 33 32 2C 34 36 2C 33 34 35 2C 33 37 2C 31 38 2C 30 33 2C 31 37 34 2C 2A 37 32 0D 0A 24 47 50 47 53 56 2C 33 2C 33 2C 31 31 2C 32 31 2C 30 33 2C 33 30 32 2C 2C 32 34 2C 30 30 2C 30 30 30 2C 2C 32 39 2C 30 31 2C 31 33 33 2C 2A 34 35 0D 0A 24 50 51 47 53 56 2C 34 2C 31 2C 31 35 2C 30 31 2C 34 35 2C 31 32 32 2C 32 37 2C 30 32 2C 34 36 2C 32 33 36 2C 32 39 2C 30 33 2C 36 31 2C 31 38 38 2C 32 37 2C 30 34 2C 33 30 2C 31 31 31 2C 32 37 2A 36 35 0D 0A 24 50 51 47 53 56 2C 34 2C 32 2C 31 35 2C 30 35 2C 32 33 2C 32 35 35 2C 32 39 2C 30 36 2C 35 31 2C 33 34 33 2C 32 32 2C 30 39 2C 34 35 2C 33 31 37 2C 32 30 2C 31 30 2C 32 36 2C 31 38 34 2C 31 31 2A 36 31 0D 0A 24 50 51 47 53 56 2C 34 2C 33 2C 31 35 2C 31 33 2C 34 32 2C 32 32 30 2C 32 36 2C 31 36 2C 35 31 2C 33 35 31 2C 31 36 2C 31 39 2C 36 38 2C 30 30 34 2C 32 36 2C 32 30 2C 34 35 2C 31 31 33 2C 32 32 2A 36 39 0D 0A 24 50 51 47 53 56 2C 34 2C 34 2C 31 35 2C 30 37 2C 33 35 2C 31 36 31 2C 2C 30 38 2C 32 38 2C 31 39 31 2C 2C 32 32 2C 32 30 2C 33 32 32 2C 2A 35 36 0D 0A 24 47 50 47 53 41 2C 41 2C 33 2C 31 30 2C 31 32 2C 32 33 2C 32 35 2C 33 31 2C 33 32 2C 2C 2C 2C 2C 2C 2C 31 2E 33 2C 31 2E 30 2C 30 2E 39 2A 33 46 0D 0A 89";
//        String hex2="4D442E2E02B700061523300100032447504747412C3032333031322E30302C333131372E3438313133342C4E2C31323132362E3234373234332C452C312C31322C312E312C33302E322C4D2C31302E302C4D2C2C2A35300D0A244750524D432C3032333031322E30302C412C333131372E3438313133342C4E2C31323132362E3234373234332C452C302E302C2C3137303832312C342E362C572C412A30390D0A2447504753562C332C312C31302C30322C33332C3239352C33322C30342C32302C3036342C31322C30362C35352C3334302C33382C31322C31392C3331302C33302A37300D0A2447504753562C332C322C31302C31342C31342C3137372C31392C31392C37332C3036372C32312C32302C32392C3233302C33312C30332C30312C3034302C2A37320D0A2447504753562C332C332C31302C30392C33332C3130342C2C31372C35332C3131322C2A37360D0A2450514753562C342C312C31362C30322C33342C3233342C32372C30332C35322C3230312C33342C30352C31332C3235342C32372C30372C30302C3030302C33312A36430D0A2450514753562C342C322C31362C30382C35392C3332362C32372C31302C35362C3232372C32352C31332C34362C3238342C32382C32302C34372C3138352C32322A36330D0A2450514753562C342C332C31362C32392C33302C3331332C32352C30312C34352C3133392C2C30342C33342C3132302C2C30362C30302C3030302C2A36430D0A2450514753562C342C342C31362C31362C30312C3137372C2C31392C30322C3230362C2C32372C32382C3039392C2C33302C36372C3033322C2A36440D0A2447504753412C412C332C30322C30362C31322C31342C31392C32302C2C2C2C2C2C2C312E342C312E312C302E392A33360D0A2450514753412C412C332C30382C31302C31332C32392C2C2C2C2C2C2C2C2C312E342C312E312C302E392A32380D0AFD";
//        String hex2="";
//        Log.i(TAG,"hex2 leng:"+hex2.length());
//        AdanGPS.decodeMsg(hex2);
        String timenow=showTimeNow();
        Log.i(TAG,"time now:"+timenow);
    }

}