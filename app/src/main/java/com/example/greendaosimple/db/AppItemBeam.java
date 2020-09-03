package com.example.greendaosimple.db;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class AppItemBeam {
    @Id(autoincrement = true)
    private Long autoId;

    private String itemName;
    @Generated(hash = 2023094758)
    public AppItemBeam(Long autoId, String itemName) {
        this.autoId = autoId;
        this.itemName = itemName;
    }
    @Generated(hash = 1314428550)
    public AppItemBeam() {
    }
    public Long getAutoId() {
        return this.autoId;
    }
    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }
    public String getItemName() {
        return this.itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
