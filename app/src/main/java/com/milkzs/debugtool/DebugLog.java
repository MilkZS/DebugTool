package com.milkzs.debugtool;

import android.util.Log;

public class DebugLog {

    private static String TAG = Thread.currentThread().getStackTrace()[1].getClassName();

    public static void d(String sLog){
        Log.d(TAG,sLog);
    }


}
