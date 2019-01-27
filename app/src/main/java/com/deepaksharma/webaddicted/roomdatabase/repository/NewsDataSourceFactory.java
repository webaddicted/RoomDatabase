package com.deepaksharma.webaddicted.roomdatabase.repository;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import com.deepaksharma.webaddicted.roomdatabase.db.entity.Pagination;
public class NewsDataSourceFactory extends DataSource.Factory<Integer, Pagination.ArticlesBean> {

    private MutableLiveData<NewsDataSourceClass> liveData;
    Activity mActivity;

    public NewsDataSourceFactory(Activity activity) {
        this.mActivity = activity;
        liveData = new MutableLiveData<>();
    }

    public MutableLiveData<NewsDataSourceClass> getMutableLiveData() {
        return liveData;
    }

    @Override
    public DataSource<Integer, Pagination.ArticlesBean> create() {
        NewsDataSourceClass dataSourceClass = new NewsDataSourceClass(mActivity);
        liveData.postValue(dataSourceClass);
        return dataSourceClass;
    }
}
