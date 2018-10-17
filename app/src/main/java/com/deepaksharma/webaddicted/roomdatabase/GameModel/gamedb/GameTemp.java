package com.deepaksharma.webaddicted.roomdatabase.GameModel.gamedb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class GameTemp {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id_temmmp")
    private String _id;
    private String template;
    private int plotWidth;
    private int plotHeight;
    private String templateSrc;

    @NonNull
    public String get_id() {
        return _id;
    }

    public void set_id(@NonNull String _id) {
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
}
