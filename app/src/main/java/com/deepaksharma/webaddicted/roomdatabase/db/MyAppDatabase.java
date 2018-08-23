package com.deepaksharma.webaddicted.roomdatabase.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.deepaksharma.webaddicted.roomdatabase.db.dao.MyDao;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.UserInfo;


@Database(entities = {UserInfo.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDao myDao();

}
