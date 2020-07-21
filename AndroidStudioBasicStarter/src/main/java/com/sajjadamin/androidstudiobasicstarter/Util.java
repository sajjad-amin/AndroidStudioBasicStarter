package com.sajjadamin.androidstudiobasicstarter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public class Util {

    public static String enToBnInt(int n){
        return Integer.toString(n).replaceAll("1","১").replaceAll("2","২")
                .replaceAll("3","৩").replaceAll("4","৪").replaceAll("5","৫")
                .replaceAll("6","৬").replaceAll("7","৭").replaceAll("8","৮")
                .replaceAll("9","৯").replaceAll("0","০");
    }

    public static String unixToNormalDate(long timestamp, String format){
        Date date = new Date(timestamp * 1000L);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+6"));
        return sdf.format(date);
    }

    public static String secondToClockTime(int second){
        int sec = 0, min = 0, hour = 0;
        if (second < 60) {
            sec = second;
        } else if (second < 3599) {
            min = (int) second / 60;
            sec = second % 60;
        } else {
            hour = (int) second / 3600;
            if (second % 3600 < 60) {
                sec = second % 3600;
            } else {
                min = (int) (second % 3600) / 60;
                sec = (second % 3600) % 60;
            }
        }
        String s = (sec <= 9) ? "0"+sec : Integer.toString(sec);
        String m = (min <= 9) ? "0"+min : Integer.toString(min);
        String h = (hour <= 9) ? "0"+hour : Integer.toString(hour);
        return h+":"+m+":"+s;
    }
}