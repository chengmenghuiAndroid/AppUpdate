package com.example.greendaosimple;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.example.greendaosimple.db.DaoManager;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
    }

    private void initGreenDao() {
        DaoManager mManager = DaoManager.getInstance();
        mManager.init(this);
        Log.e("MyApplication", "initGreenDao");

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

}
