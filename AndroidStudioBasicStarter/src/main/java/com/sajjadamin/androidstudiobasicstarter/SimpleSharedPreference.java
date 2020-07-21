package com.sajjadamin.androidstudiobasicstarter;

import android.content.Context;
import android.content.SharedPreferences;

public class SimpleSharedPreference {

    private Context context;

    public SimpleSharedPreference(Context context) {
        this.context = context;
    }

    public void setSharedPreferences(String SharedPreferencesName, String key, String data){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,data);
        editor.apply();
    }
    public String getSharedPreferences(String SharedPreferencesName, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }
}
