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

    public static void addPoints(Context context, int points){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_key), context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("points", getPoints(context) + points);
        editor.apply();
    }

    public static int getPoints(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_key), context.MODE_PRIVATE);
        int points = sharedPref.getInt("points", 0);
        return points;
    }

    public static void setDoneInitDatabase(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_key), context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("init", true);
        editor.apply();
    }

    public static boolean checkDatabaseInit(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_key), context.MODE_PRIVATE);
        boolean init = sharedPref.getBoolean("init", false);
        return init;
    }

}
