package com.zhongwls.ijkplayer.util;

import android.util.Log;

/**
 * Created by zwl on 2019/3/1.
 */
public class L {

    private static final String TAG = "DKPlayer";

    private static boolean isDebug = false;


    public static void d(String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.e(TAG, msg);
        }
    }

    public static void i(String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }

    public static void setDebug(boolean isDebug) {
        L.isDebug = isDebug;
    }
}
