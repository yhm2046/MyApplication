package com.example.myapplication.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * 权限相关工具类
 * date：2021.9.2    Thursday
 */
public class PermissionUtils {
    private static final String TAG="PermissionUtils:azj";
    /**
     * reference：https://blog.csdn.net/ERP_LXKUN_JAK/article/details/108265128
     * 动态申请权限
     * @param context    上下文
     * @param permission 要申请的一个权限，列如写的权限：Manifest.permission.WRITE_EXTERNAL_STORAGE
     * @return  是否有当前权限
     */

    public static boolean RequestPermissions(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG,": 【 " + permission + " 】没有授权，申请权限");
            ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, 100);
            return false;
        } else {
            Log.i(TAG,": 【 " + permission + " 】有权限");
            return true;
        }
    }

}
