package com.deepaksharma.webaddicted.roomdatabase;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.deepaksharma.webaddicted.roomdatabase.db.DbConstant;
import com.deepaksharma.webaddicted.roomdatabase.db.MyAppDatabase;
import com.deepaksharma.webaddicted.roomdatabase.db.dao.MyDao;
import com.facebook.stetho.Stetho;

/**
 * Created by deepaksharma on 23/8/18.
 */

public class GlobalClass extends Application {
    private static GlobalClass mInstance;
    private static MyDao myDao;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        mInstance = this;
    }

    public static GlobalClass getInstance() {
        return mInstance;
    }

    public static MyDao getDbInstance() {
        if (myDao == null) {
            myDao = Room.databaseBuilder(getInstance(), MyAppDatabase.class, DbConstant.DB_NAME)
                    .allowMainThreadQueries().build().myDao();
        }
        return myDao;
    }

}
