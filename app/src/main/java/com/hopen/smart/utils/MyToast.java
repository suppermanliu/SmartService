package com.hopen.smart.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/2/15.
 */

public final class MyToast {

    public static void show(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
