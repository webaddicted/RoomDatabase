package com.deepaksharma.webaddicted.roomdatabase.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.deepaksharma.webaddicted.roomdatabase.GameModel.gamedb.GameBean;
import com.deepaksharma.webaddicted.roomdatabase.GameModel.gamedb.GameInsert;
import com.deepaksharma.webaddicted.roomdatabase.GameModel.gamedb.GameTemp;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.UserDetailsObj;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.UserInfo;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addUser(UserInfo userInfo);

    @Insert
    public void insertUserObj(UserDetailsObj userDetails);

    @Query("SELECT * FROM user_info")
    public List<UserInfo> getUserInfo();

    @Query("SELECT * FROM user_details_obj")
    public List<UserDetailsObj> getUserObj();

    @Delete
    public void deleteUser(UserInfo userInfo);

    @Update
    public void updateUserInfo(UserInfo userInfo);

    @Insert
    void insertGame(GameTemp gameTemp, List<GameBean.ResultBean.DataBean.EnvObjBean> envObjBean,
                    List<GameBean.ResultBean.DataBean.GameObjBean> gameObjBean,
                    List<GameBean.ResultBean.DataBean.ZoneObjBean> zoneObjBean);


//    @Query("SELECT * FROM GameTemp")
    @Query("SELECT * FROM GameTemp gt inner join EnvObjBean et on gt.id_temmmp = et.id_parent inner join ZoneObjBean zt on et.id_parent = zt.id_parent")
    public List<GameInsert> getGameInfo();

//    @Insert//(onConflict = OnConflictStrategy.REPLACE)
//    public void gameInsert( gameInsert);



//    @Query("SELECT * FROM user_info where user_name LIKE  :name")
//    UserInfo findByName(String firstName, String lastName);
////    @Query("SELECT * FROM user where user_name LIKE  :name AND last_name LIKE :lastName")
////    UserInfo findByName(String firstName, String lastName);
//
//    @Query("SELECT COUNT(*) from user_info")
//    int countUsers();
}
