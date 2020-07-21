package com.sajjadamin.androidstudiobasicstarter;

import android.app.Activity;
import android.content.Context;

public abstract class AsyncTask<T> extends Thread {
    private Activity activity;
    protected AsyncTask(Context context){
        this.activity = (Activity) context;
    }
    @Override
    public void run(){
        final T data = doInBackground();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onPostExecute(data);
            }
        });
    }
    public abstract T doInBackground();
    public abstract void onPostExecute(T data);
}
