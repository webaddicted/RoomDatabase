package com.deepaksharma.webaddicted.roomdatabase.GameModel.gamedb;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class GameInsert {
    @Embedded
    GameTemp gameTemp;
    @Relation(parentColumn = "id_temmmp", entityColumn = "id_parent", entity = GameBean.ResultBean.DataBean.EnvObjBean.class)
    private List<GameBean.ResultBean.DataBean.EnvObjBean> envObj;
    @Relation(parentColumn = "id_temmmp", entityColumn = "id_parent", entity = GameBean.ResultBean.DataBean.GameObjBean.class)
    private List<GameBean.ResultBean.DataBean.GameObjBean> gameObj;
    @Relation(parentColumn = "id_temmmp", entityColumn = "id_parent", entity = GameBean.ResultBean.DataBean.ZoneObjBean.class)
    private List<GameBean.ResultBean.DataBean.ZoneObjBean> zoneObj;


    public GameTemp getGameTemp() {
        return gameTemp;
    }

    public void setGameTemp(GameTemp gameTemp) {
        this.gameTemp = gameTemp;
    }

    public List<GameBean.ResultBean.DataBean.EnvObjBean> getEnvObj() {
        return envObj;
    }

    public void setEnvObj(List<GameBean.ResultBean.DataBean.EnvObjBean> envObj) {
        this.envObj = envObj;
    }

    public List<GameBean.ResultBean.DataBean.GameObjBean> getGameObj() {
        return gameObj;
    }

    public void setGameObj(List<GameBean.ResultBean.DataBean.GameObjBean> gameObj) {
        this.gameObj = gameObj;
    }

    public List<GameBean.ResultBean.DataBean.ZoneObjBean> getZoneObj() {
        return zoneObj;
    }

    public void setZoneObj(List<GameBean.ResultBean.DataBean.ZoneObjBean> zoneObj) {
        this.zoneObj = zoneObj;
    }
}
