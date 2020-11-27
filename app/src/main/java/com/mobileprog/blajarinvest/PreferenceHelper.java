package com.mobileprog.blajarinvest;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;

import java.util.ArrayList;

public class PreferenceHelper {

    public static void setUsername(Context context, String username){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_key), context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", username);
        editor.apply();
    }

    public static String getUsername(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_key), context.MODE_PRIVATE);
        String username = sharedPref.getString("username", "");
        return username;
    }

}
