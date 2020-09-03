package com.example.tianmei.myapplication.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.greendaosimple.db.AppSortBean;
import com.example.greendaosimple.db.AppItemBeam;

import com.example.tianmei.myapplication.greendao.gen.AppSortBeanDao;
import com.example.tianmei.myapplication.greendao.gen.AppItemBeamDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig appSortBeanDaoConfig;
    private final DaoConfig appItemBeamDaoConfig;

    private final AppSortBeanDao appSortBeanDao;
    private final AppItemBeamDao appItemBeamDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        appSortBeanDaoConfig = daoConfigMap.get(AppSortBeanDao.class).clone();
        appSortBeanDaoConfig.initIdentityScope(type);

        appItemBeamDaoConfig = daoConfigMap.get(AppItemBeamDao.class).clone();
        appItemBeamDaoConfig.initIdentityScope(type);

        appSortBeanDao = new AppSortBeanDao(appSortBeanDaoConfig, this);
        appItemBeamDao = new AppItemBeamDao(appItemBeamDaoConfig, this);

        registerDao(AppSortBean.class, appSortBeanDao);
        registerDao(AppItemBeam.class, appItemBeamDao);
    }
    
    public void clear() {
        appSortBeanDaoConfig.clearIdentityScope();
        appItemBeamDaoConfig.clearIdentityScope();
    }

    public AppSortBeanDao getAppSortBeanDao() {
        return appSortBeanDao;
    }

    public AppItemBeamDao getAppItemBeamDao() {
        return appItemBeamDao;
    }

}