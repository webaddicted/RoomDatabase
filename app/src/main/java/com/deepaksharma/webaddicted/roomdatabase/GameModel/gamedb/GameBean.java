package com.deepaksharma.webaddicted.roomdatabase.GameModel.gamedb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

public class GameBean {


    /**
     * success : true
     * message :  Get successfully.
     * result : [{"totalData":3,"page":1,"data":[{"_id":"5bc5c2fcac10672dbc1d186c","template":"Game 2","envObj":[{"_id":"5bc5c2fcac10672dbc1d186d","id":"","name":"beach","height":1,"width":1,"actheight":480,"actwidth":300}],"gameObj":[{"_id":"5bc5c2fcac10672dbc1d186f","id":"","name":"dog","height":0.22916666666666666,"width":0.45,"actheight":110,"actwidth":135,"x":0.27666666666666667,"y":0.41458333333333336,"actx":83,"acty":199},{"_id":"5bc5c2fcac10672dbc1d186e","id":"","name":"fielder","height":0.175,"width":0.36333333333333334,"actheight":84,"actwidth":109,"x":0.11,"y":0.7166666666666667,"actx":33,"acty":344}],"zoneObj":[{"_id":"5bc5c2fcac10672dbc1d1871","id":"","name":"out_zone","height":0.1875,"width":0.49666666666666665,"actheight":90,"actwidth":149,"x":0.07333333333333333,"y":0.7104166666666667,"actx":22,"acty":341,"sequence":1},{"_id":"5bc5c2fcac10672dbc1d1870","id":"","name":"batter-safe-zone","height":0.1875,"width":0.49666666666666665,"actheight":90,"actwidth":149,"x":0.26666666666666666,"y":0.41875,"actx":80,"acty":201,"sequence":2}],"plotWidth":300,"plotHeight":480,"templateSrc":"http://10.11.6.18:3700/profile/lvFetMKi3PBg_1539687164.png"},{"_id":"5bc5c1a8ef4af526245230f8","template":"game 1","envObj":[{"_id":"5bc5c1a8ef4af526245230f9","id":"","name":"background","height":1,"width":1,"actheight":480,"actwidth":300}],"gameObj":[{"_id":"5bc5c1a8ef4af526245230fb","id":"","name":"bowler","height":0.17916666666666667,"width":0.24,"actheight":86,"actwidth":72,"x":0.20666666666666667,"y":0.14583333333333334,"actx":62,"acty":70},{"_id":"5bc5c1a8ef4af526245230fa","id":"","name":"dog","height":0.22916666666666666,"width":0.45,"actheight":110,"actwidth":135,"x":0.20666666666666667,"y":0.47708333333333336,"actx":62,"acty":229}],"zoneObj":[{"_id":"5bc5c1a8ef4af526245230fd","id":"","name":"out_zone","height":0.1875,"width":0.49666666666666665,"actheight":90,"actwidth":149,"x":0.09666666666666666,"y":0.14791666666666667,"actx":29,"acty":71,"sequence":1},{"_id":"5bc5c1a8ef4af526245230fc","id":"","name":"game_winning_zone","height":0.260930739368707,"width":0.6911765362833304,"actheight":125.24675489697935,"actwidth":207.35296088499913,"x":0.09666666666666666,"y":0.4625,"actx":29,"acty":222,"sequence":2}],"plotWidth":300,"plotHeight":480,"templateSrc":"http://10.11.6.18:3700/profile/o5xdxMim4xdG_1539686824.png"}]}]
     * code : 200
     */

    private boolean success;
    private String message;
    private int code;
    private List<ResultBean> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * totalData : 3
         * page : 1
         * data : [{"_id":"5bc5c2fcac10672dbc1d186c","template":"Game 2","envObj":[{"_id":"5bc5c2fcac10672dbc1d186d","id":"","name":"beach","height":1,"width":1,"actheight":480,"actwidth":300}],"gameObj":[{"_id":"5bc5c2fcac10672dbc1d186f","id":"","name":"dog","height":0.22916666666666666,"width":0.45,"actheight":110,"actwidth":135,"x":0.27666666666666667,"y":0.41458333333333336,"actx":83,"acty":199},{"_id":"5bc5c2fcac10672dbc1d186e","id":"","name":"fielder","height":0.175,"width":0.36333333333333334,"actheight":84,"actwidth":109,"x":0.11,"y":0.7166666666666667,"actx":33,"acty":344}],"zoneObj":[{"_id":"5bc5c2fcac10672dbc1d1871","id":"","name":"out_zone","height":0.1875,"width":0.49666666666666665,"actheight":90,"actwidth":149,"x":0.07333333333333333,"y":0.7104166666666667,"actx":22,"acty":341,"sequence":1},{"_id":"5bc5c2fcac10672dbc1d1870","id":"","name":"batter-safe-zone","height":0.1875,"width":0.49666666666666665,"actheight":90,"actwidth":149,"x":0.26666666666666666,"y":0.41875,"actx":80,"acty":201,"sequence":2}],"plotWidth":300,"plotHeight":480,"templateSrc":"http://10.11.6.18:3700/profile/lvFetMKi3PBg_1539687164.png"},{"_id":"5bc5c1a8ef4af526245230f8","template":"game 1","envObj":[{"_id":"5bc5c1a8ef4af526245230f9","id":"","name":"background","height":1,"width":1,"actheight":480,"actwidth":300}],"gameObj":[{"_id":"5bc5c1a8ef4af526245230fb","id":"","name":"bowler","height":0.17916666666666667,"width":0.24,"actheight":86,"actwidth":72,"x":0.20666666666666667,"y":0.14583333333333334,"actx":62,"acty":70},{"_id":"5bc5c1a8ef4af526245230fa","id":"","name":"dog","height":0.22916666666666666,"width":0.45,"actheight":110,"actwidth":135,"x":0.20666666666666667,"y":0.47708333333333336,"actx":62,"acty":229}],"zoneObj":[{"_id":"5bc5c1a8ef4af526245230fd","id":"","name":"out_zone","height":0.1875,"width":0.49666666666666665,"actheight":90,"actwidth":149,"x":0.09666666666666666,"y":0.14791666666666667,"actx":29,"acty":71,"sequence":1},{"_id":"5bc5c1a8ef4af526245230fc","id":"","name":"game_winning_zone","height":0.260930739368707,"width":0.6911765362833304,"actheight":125.24675489697935,"actwidth":207.35296088499913,"x":0.09666666666666666,"y":0.4625,"actx":29,"acty":222,"sequence":2}],"plotWidth":300,"plotHeight":480,"templateSrc":"http://10.11.6.18:3700/profile/o5xdxMim4xdG_1539686824.png"}]
         */

        private int totalData;
        private int page;
        private List<DataBean> data;

        public int getTotalData() {
            return totalData;
        }

        public void setTotalData(int totalData) {
            this.totalData = totalData;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * _id : 5bc5c2fcac10672dbc1d186c
             * template : Game 2
             * envObj : [{"_id":"5bc5c2fcac10672dbc1d186d","id":"","name":"beach","height":1,"width":1,"actheight":480,"actwidth":300}]
             * gameObj : [{"_id":"5bc5c2fcac10672dbc1d186f","id":"","name":"dog","height":0.22916666666666666,"width":0.45,"actheight":110,"actwidth":135,"x":0.27666666666666667,"y":0.41458333333333336,"actx":83,"acty":199},{"_id":"5bc5c2fcac10672dbc1d186e","id":"","name":"fielder","height":0.175,"width":0.36333333333333334,"actheight":84,"actwidth":109,"x":0.11,"y":0.7166666666666667,"actx":33,"acty":344}]
             * zoneObj : [{"_id":"5bc5c2fcac10672dbc1d1871","id":"","name":"out_zone","height":0.1875,"width":0.49666666666666665,"actheight":90,"actwidth":149,"x":0.07333333333333333,"y":0.7104166666666667,"actx":22,"acty":341,"sequence":1},{"_id":"5bc5c2fcac10672dbc1d1870","id":"","name":"batter-safe-zone","height":0.1875,"width":0.49666666666666665,"actheight":90,"actwidth":149,"x":0.26666666666666666,"y":0.41875,"actx":80,"acty":201,"sequence":2}]
             * plotWidth : 300
             * plotHeight : 480
             * templateSrc : http://10.11.6.18:3700/profile/lvFetMKi3PBg_1539687164.png
             */

            private String _id;
            private String template;
            private int plotWidth;
            private int plotHeight;
            private String templateSrc;
            private List<EnvObjBean> envObj;
            private List<GameObjBean> gameObj;
            private List<ZoneObjBean> zoneObj;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
                this.template = template;
            }

            public int getPlotWidth() {
                return plotWidth;
            }

            public void setPlotWidth(int plotWidth) {
                this.plotWidth = plotWidth;
            }

            public int getPlotHeight() {
                return plotHeight;
            }

            public void setPlotHeight(int plotHeight) {
                this.plotHeight = plotHeight;
            }

            public String getTemplateSrc() {
                return templateSrc;
            }

            public void setTemplateSrc(String templateSrc) {
                this.templateSrc = templateSrc;
            }

            public List<EnvObjBean> getEnvObj() {
                return envObj;
            }

            public void setEnvObj(List<EnvObjBean> envObj) {
                this.envObj = envObj;
            }

            public List<GameObjBean> getGameObj() {
                return gameObj;
            }

            public void setGameObj(List<GameObjBean> gameObj) {
                this.gameObj = gameObj;
            }

            public List<ZoneObjBean> getZoneObj() {
                return zoneObj;
            }

            public void setZoneObj(List<ZoneObjBean> zoneObj) {
                this.zoneObj = zoneObj;
            }

            @Entity
            public static class EnvObjBean {
                /**
                 * _id : 5bc5c2fcac10672dbc1d186d
                 * id :
                 * name : beach
                 * height : 1
                 * width : 1
                 * actheight : 480
                 * actwidth : 300
                 */
                @NonNull
                @PrimaryKey(autoGenerate = true)
                private int id_env;
                private String _id;
                private String id_parent;
                private String id;
                private String name;
                private int height;
                private int width;
                private double actheight;
                private double actwidth;

                @NonNull
                public int getId_env() {
                    return id_env;
                }

                public void setId_env(@NonNull int id_env) {
                    this.id_env = id_env;
                }

                @NonNull
                public String getid() {
                    return _id;
                }

                public void setid(@NonNull String _id) {
                    this._id = _id;
                }

                public String getId_parent() {
                    return id_parent;
                }

                public void setId_parent(String id_parent) {
                    this.id_parent = id_parent;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public double getActheight() {
                    return actheight;
                }

                public void setActheight(double actheight) {
                    this.actheight = actheight;
                }

                public double getActwidth() {
                    return actwidth;
                }

                public void setActwidth(double actwidth) {
                    this.actwidth = actwidth;
                }
            }

            @Entity
            public static class GameObjBean {
                /**
                 * _id : 5bc5c2fcac10672dbc1d186f
                 * id :
                 * name : dog
                 * height : 0.22916666666666666
                 * width : 0.45
                 * actheight : 110
                 * actwidth : 135
                 * x : 0.27666666666666667
                 * y : 0.41458333333333336
                 * actx : 83
                 * acty : 199
                 */

                @NonNull
                @PrimaryKey(autoGenerate = true)
                private int ides;
                private String _id;
                private String id_parent;
                @ColumnInfo(name = "in_nor")
                private String id;
                private String name;
                private double height;
                private double width;
                private double actheight;
                private double actwidth;
                private double x;
                private double y;
                private int actx;
                private int acty;

                @NonNull
                public int getIdes() {
                    return ides;
                }

                public void setIdes(@NonNull int ides) {
                    this.ides = ides;
                }

                public String getid() {
                    return _id;
                }

                public void setid(String _id) {
                    this._id = _id;
                }

                public String getId_parent() {
                    return id_parent;
                }

                public void setId_parent(String id_parent) {
                    this.id_parent = id_parent;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public double getHeight() {
                    return height;
                }

                public void setHeight(double height) {
                    this.height = height;
                }

                public double getWidth() {
                    return width;
                }

                public void setWidth(double width) {
                    this.width = width;
                }

                public double getActheight() {
                    return actheight;
                }

                public void setActheight(double actheight) {
                    this.actheight = actheight;
                }

                public double getActwidth() {
                    return actwidth;
                }

                public void setActwidth(double actwidth) {
                    this.actwidth = actwidth;
                }

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }

                public int getActx() {
                    return actx;
                }

                public void setActx(int actx) {
                    this.actx = actx;
                }

                public int getActy() {
                    return acty;
                }

                public void setActy(int acty) {
                    this.acty = acty;
                }
            }

            @Entity
            public static class ZoneObjBean {
                /**
                 * _id : 5bc5c2fcac10672dbc1d1871
                 * id :
                 * name : out_zone
                 * height : 0.1875
                 * width : 0.49666666666666665
                 * actheight : 90
                 * actwidth : 149
                 * x : 0.07333333333333333
                 * y : 0.7104166666666667
                 * actx : 22
                 * acty : 341
                 * sequence : 1
                 */

                @NonNull
                @PrimaryKey(autoGenerate = true)
                private int idease;
                private String _id;
                                private String id_parent;
                @ColumnInfo(name = "id_zone_info")
                private String id;
                private String name;
                private double height;
                private double width;
                private double actheight;
                private double actwidth;
                private double x;
                private double y;
                private int actx;
                private int acty;
                private int sequence;

                @NonNull
                public int getIdease() {
                    return idease;
                }

                public void setIdease(@NonNull int idease) {
                    this.idease = idease;
                }

                @NonNull
                public String getid() {
                    return _id;
                }

                public void setid(@NonNull String id) {
                    this._id = id;
                }

                public String getId_parent() {
                    return id_parent;
                }

                public void setId_parent(String id_parent) {
                    this.id_parent = id_parent;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public double getHeight() {
                    return height;
                }

                public void setHeight(double height) {
                    this.height = height;
                }

                public double getWidth() {
                    return width;
                }

                public void setWidth(double width) {
                    this.width = width;
                }

                public double getActheight() {
                    return actheight;
                }

                public void setActheight(double actheight) {
                    this.actheight = actheight;
                }

                public double getActwidth() {
                    return actwidth;
                }

                public void setActwidth(double actwidth) {
                    this.actwidth = actwidth;
                }

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }

                public int getActx() {
                    return actx;
                }

                public void setActx(int actx) {
                    this.actx = actx;
                }

                public int getActy() {
                    return acty;
                }

                public void setActy(int acty) {
                    this.acty = acty;
                }

                public int getSequence() {
                    return sequence;
                }

                public void setSequence(int sequence) {
                    this.sequence = sequence;
                }
            }
        }
    }
}
