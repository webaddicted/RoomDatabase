package com.deepaksharma.webaddicted.roomdatabase.ui.viewmodel;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.deepaksharma.webaddicted.roomdatabase.GlobalClass;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.Pagination;
import com.deepaksharma.webaddicted.roomdatabase.repository.NEWSBoundaryCallBack;
import com.deepaksharma.webaddicted.roomdatabase.repository.NewsDataSourceFactory;
import com.deepaksharma.webaddicted.roomdatabase.ui.activity.PagingActivity;

public class PagingWithoutDbViewModel extends ViewModel {
    public LiveData<PagedList<Pagination.ArticlesBean>> newsLiveData;
    private NewsDataSourceFactory newsDataSourceFactory;

    public LiveData<PagedList<Pagination.ArticlesBean>> getArticResp() {
        return newsLiveData;
    }

    public void paginationReq(Activity activity) {
        newsDataSourceFactory = new NewsDataSourceFactory(activity);
        newsLiveData = new LivePagedListBuilder<>(newsDataSourceFactory, pagedListConfig())
                .build();
    }

    private PagedList.Config pagedListConfig() {
        return new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(10).build();
    }

}