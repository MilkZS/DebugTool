package com.milkzs.debugtool;

import android.util.Log;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

public class DebugLog {

   // private static String TAG = Thread.currentThread().getStackTrace()[1].getClassName();



    public static void d(String sLog){
//        Log.d(TAG,sLog);
    }

    /**
     * 遍历一个类中的所有属性和属性值
     *
     * @param obj 目标类
     */
    public static void d(Object obj){
        String TAG = obj.getClass().getSimpleName();
        d(TAG,obj);
    }

    public static void d(String TAG,Object obj){
        Field[] fields = obj.getClass().getDeclaredFields(); // 获取属性
        Log.d(TAG,"======== show class " + obj.getClass().getCanonicalName() + " ========");
        for (Field field : fields) {
            String name = field.getName();
            boolean saveState = field.isAccessible();
            field.setAccessible(true);
            try {
                Object oVal = field.get(obj);
                if (oVal instanceof String[] || oVal instanceof int[]){
                    Log.d(TAG,"==> " + name + " -> " + Arrays.toString((Object[]) oVal));
                }else{
                    Log.d(TAG,"==> " + name + " -> " + oVal);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }finally {
                field.setAccessible(saveState);
            }
        }
    }



}
