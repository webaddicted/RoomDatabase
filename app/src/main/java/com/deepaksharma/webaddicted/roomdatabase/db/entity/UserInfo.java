package com.deepaksharma.webaddicted.roomdatabase.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.deepaksharma.webaddicted.roomdatabase.db.DbConstant;


@Entity(tableName = DbConstant.USER_INFO_TABLE)
public class UserInfo {
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "user_name")
    private String name;
    @ColumnInfo(name = "user_mobile")
    private String mobileno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}
