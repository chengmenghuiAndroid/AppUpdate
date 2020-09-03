package com.example.greendaosimple.db;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class AppSortBean {

    @Id(autoincrement = true)
    private Long autoId;
    private String appId;
    private String name;
    private int sort;
    @Generated(hash = 78171463)
    public AppSortBean(Long autoId, String appId, String name, int sort) {
        this.autoId = autoId;
        this.appId = appId;
        this.name = name;
        this.sort = sort;
    }
    @Generated(hash = 1276826811)
    public AppSortBean() {
    }
    public Long getAutoId() {
        return this.autoId;
    }
    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }
    public String getAppId() {
        return this.appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSort() {
        return this.sort;
    }
    public void setSort(int sort) {
        this.sort = sort;
    }
}
