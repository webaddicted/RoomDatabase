package com.deepaksharma.webaddicted.roomdatabase.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.deepaksharma.webaddicted.roomdatabase.GameModel.gamedb.GameBean;
import com.deepaksharma.webaddicted.roomdatabase.GameModel.gamedb.GameInsert;
import com.deepaksharma.webaddicted.roomdatabase.GameModel.gamedb.GameTemp;
import com.deepaksharma.webaddicted.roomdatabase.db.dao.MyDao;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.UserDetailsObj;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.UserInfo;


@Database(entities = {UserInfo.class, UserDetailsObj.class,
//        GameInsert.class,
        GameTemp.class,
        GameBean.ResultBean.DataBean.EnvObjBean.class,
        GameBean.ResultBean.DataBean.GameObjBean.class,
        GameBean.ResultBean.DataBean.ZoneObjBean.class,}, version = DbConstant.DB_VERSION)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}
