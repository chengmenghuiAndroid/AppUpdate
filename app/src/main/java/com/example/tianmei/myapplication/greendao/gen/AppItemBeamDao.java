package com.example.tianmei.myapplication.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.greendaosimple.db.AppItemBeam;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "APP_ITEM_BEAM".
*/
public class AppItemBeamDao extends AbstractDao<AppItemBeam, Long> {

    public static final String TABLENAME = "APP_ITEM_BEAM";

    /**
     * Properties of entity AppItemBeam.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property AutoId = new Property(0, Long.class, "autoId", true, "_id");
        public final static Property ItemName = new Property(1, String.class, "itemName", false, "ITEM_NAME");
    }


    public AppItemBeamDao(DaoConfig config) {
        super(config);
    }
    
    public AppItemBeamDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"APP_ITEM_BEAM\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: autoId
                "\"ITEM_NAME\" TEXT);"); // 1: itemName
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"APP_ITEM_BEAM\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AppItemBeam entity) {
        stmt.clearBindings();
 
        Long autoId = entity.getAutoId();
        if (autoId != null) {
            stmt.bindLong(1, autoId);
        }
 
        String itemName = entity.getItemName();
        if (itemName != null) {
            stmt.bindString(2, itemName);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AppItemBeam entity) {
        stmt.clearBindings();
 
        Long autoId = entity.getAutoId();
        if (autoId != null) {
            stmt.bindLong(1, autoId);
        }
 
        String itemName = entity.getItemName();
        if (itemName != null) {
            stmt.bindString(2, itemName);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public AppItemBeam readEntity(Cursor cursor, int offset) {
        AppItemBeam entity = new AppItemBeam( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // autoId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // itemName
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AppItemBeam entity, int offset) {
        entity.setAutoId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setItemName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(AppItemBeam entity, long rowId) {
        entity.setAutoId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(AppItemBeam entity) {
        if(entity != null) {
            return entity.getAutoId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(AppItemBeam entity) {
        return entity.getAutoId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
