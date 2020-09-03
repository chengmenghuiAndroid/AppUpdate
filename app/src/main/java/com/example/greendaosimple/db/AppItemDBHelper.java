package com.example.greendaosimple.db;

import android.util.Log;

import com.example.tianmei.myapplication.greendao.gen.DaoSession;

public class AppItemDBHelper {

    private static final String TAG = AppItemDBHelper.class.getSimpleName();

    private volatile static AppItemDBHelper appItemDBHelper = null;
    private AppItemDBHelper () {}

    public static AppItemDBHelper getInstance() {
        if (appItemDBHelper == null) {
            synchronized (AppItemDBHelper.class) {
                if (appItemDBHelper == null) {
                    appItemDBHelper = new AppItemDBHelper();
                }
            }
        }
        return appItemDBHelper;

    }

    public DaoSession getAppItemDaoSession() {
        return DaoManager.getInstance().getDaoSession();
    }


    /**
     * 完成appItemBeam记录的插入，如果表未创建，先创建appItemBeam表
     * @param appItemBeam
     * @return
     */
    public boolean insertAppItemBeam(AppItemBeam appItemBeam){
        boolean flag = getAppItemDaoSession().insert(appItemBeam) != -1;
        return flag;
    }
}
