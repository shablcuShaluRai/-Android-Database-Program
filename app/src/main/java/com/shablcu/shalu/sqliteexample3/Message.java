package com.shablcu.shalu.sqliteexample3;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by shalu on 12/7/16.
 */
public class Message {
    public static void message(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
