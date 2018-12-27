package com.deepaksharma.webaddicted.roomdatabase.ui.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.deepaksharma.webaddicted.roomdatabase.GlobalClass;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.Pagination;
import com.deepaksharma.webaddicted.roomdatabase.ui.NEWSBoundaryCallBack;

public class PagingViewModel extends ViewModel {
    public LiveData<PagedList<Pagination.ArticlesBean>> newsLiveData;

    public void init() {
        LivePagedListBuilder<Integer, Pagination.ArticlesBean> livePagedListBuilder = new LivePagedListBuilder(GlobalClass.getDbInstance().newsssss(), 25);
        livePagedListBuilder.setBoundaryCallback(new NEWSBoundaryCallBack());
        newsLiveData = livePagedListBuilder.build();
    }
}