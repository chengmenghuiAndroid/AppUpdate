package com.example.greendaosimple.db;

import android.content.Context;
import android.util.Log;

import com.example.greendaosimple.BuildConfig;
import com.example.tianmei.myapplication.greendao.gen.DaoMaster;
import com.example.tianmei.myapplication.greendao.gen.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class DaoManager {
    private static final String TAG = DaoManager.class.getSimpleName();
    private static final String DB_NAME = "greendaotest";

    private Context context;

    //多线程中要被共享的使用volatile关键字修饰
    private volatile static DaoManager manager = new DaoManager();
    private static DaoMaster sDaoMaster;
    private static DaoMaster.DevOpenHelper sHelper;
    private static DaoSession sDaoSession;

    /**
     * 单例模式获得操作数据库对象
     *
     * @return
     */
    public static DaoManager getInstance() {
        return manager;
    }

    private DaoManager() {
        setDebug();
    }

    public void init(Context context) {
        this.context = context;
    }

    /**
     * 判断是否有存在数据库，如果没有则创建
     *
     * @return
     */
    public DaoMaster getDaoMaster() {
        if (sDaoMaster == null) {
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
            sDaoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return sDaoMaster;
    }

    /**
     * 完成对数据库的添加、删除、修改、查询操作，仅仅是一个接口
     *
     * @return
     */
    public DaoSession getDaoSession() {
        if (sDaoSession == null) {
            if (sDaoMaster == null) {
                sDaoMaster = getDaoMaster();
            }
            sDaoSession = sDaoMaster.newSession();
        }
        return sDaoSession;
    }

    /**
     * 打开输出日志，默认关闭
     */
    public void setDebug() {
        if (BuildConfig.DEBUG) {
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
        }
    }

    /**
     * 关闭所有的操作，数据库开启后，使用完毕要关闭
     */
    public void closeConnection() {
        closeHelper();
        closeDaoSession();
    }

    public void closeHelper() {
        if (sHelper != null) {
            sHelper.close();
            sHelper = null;
        }
    }

    public void closeDaoSession() {
        if (sDaoSession != null) {
            sDaoSession.clear();
            sDaoSession = null;
        }
    }

    /**
     * 完成meizi记录的插入，如果表未创建，先创建Meizi表
     * @param sortBean
     * @return
     */
    public boolean insertMeizi(AppSortBean sortBean){
        boolean flag = false;
        flag = getDaoSession().getAppSortBeanDao().insert(sortBean) == -1 ? false : true;
        Log.i(TAG, "insert Meizi :" + flag + "-->" + sortBean.toString());
        return flag;
    }


    /**
     * 删除所有记录
     * @return
     */
    public boolean deleteAll(){
        boolean flag = false;
        try {
            //按照id删除
            getDaoSession().deleteAll(AppSortBean.class);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 插入多条数据，在子线程操作
     * @param appSortBeans
     * @return
     */
    public boolean insertMultAppSortBeans(final List<AppSortBean> appSortBeans) {
        boolean flag = false;
        try {
            getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (AppSortBean meizi : appSortBeans) {
                        getDaoSession().insertOrReplace(meizi);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 修改一条数据
     * @param appSortBeans
     * @return
     */
    public boolean updateAppSortBean(AppSortBean appSortBeans){
        boolean flag = false;
        try {
            getDaoSession().update(appSortBeans);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 查询所有记录
     * @return
     */
    public List<AppSortBean> queryAllAppSortBean(){
        return getDaoSession().loadAll(AppSortBean.class);
    }


}
