package com.deepaksharma.webaddicted.roomdatabase.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.deepaksharma.webaddicted.roomdatabase.db.dao.MyDao;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.UserDetailsObj;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.UserInfo;


@Database(entities = {UserInfo.class, UserDetailsObj.class}, version = DbConstant.DB_VERSION)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDao myDao();

}
