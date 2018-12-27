package com.deepaksharma.webaddicted.roomdatabase.ui;

import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import android.util.Log;

import com.deepaksharma.webaddicted.roomdatabase.GlobalClass;
import com.deepaksharma.webaddicted.roomdatabase.api.ApiLists;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.Pagination;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class NEWSBoundaryCallBack extends PagedList.BoundaryCallback<Pagination.ArticlesBean> {
    private boolean isRequestRunning = false;
    private int pagNo = 1;
    String TAG = NEWSBoundaryCallBack.class.getSimpleName();


    public NEWSBoundaryCallBack() {
        Log.d(TAG, "onZeroItemsLoaded: ");
        String url = "https://newsapi.org/v2/everything?q=Aditya    birla&pageSize=20&page=" + pagNo + "&apiKey=e5e212cc147343cb9389cfb497c52bc2";
        NEWSChannelListApi(url);
    }

    // Requests initial data from the network, replacing all content currently
    // in the database.
    @Override
    public void onZeroItemsLoaded() {
        Log.d(TAG, "onZeroItemsLoaded: ");
        String url = "https://newsapi.org/v2/everything?q=Aditya    birla&pageSize=20&page=" + pagNo + "&apiKey=e5e212cc147343cb9389cfb497c52bc2";
        NEWSChannelListApi(url);
    }

    @Override
    public void onItemAtEndLoaded(@NonNull Pagination.ArticlesBean itemAtEnd) {
        Log.d(TAG, "onItemAtEndLoaded: ");
        String url = "https://newsapi.org/v2/everything?q=Aditya    birla&pageSize=2&page=" + pagNo + "&apiKey=e5e212cc147343cb9389cfb497c52bc2";
        NEWSChannelListApi(url);
    }

    public void NEWSChannelListApi(final String strUrl) {
//        final ProgressDialog progressDialog = ProgressDialog.show(ChannelListActivity.this, getString(R.string.please_wait), getString(R.string.loading));
        Retrofit retrofit = ApiLists.retrofit;
        ApiLists apiLists = retrofit.create(ApiLists.class);
        Call<Pagination> channelName = apiLists.getChannelListName(strUrl);
        Log.d(TAG, "onResponse: channelList: url===>" + channelName.request());
        channelName.enqueue(new Callback<Pagination>() {
            @Override
            public void onResponse(Call<Pagination> call, Response<Pagination> response) {
                Log.d(TAG, "onResponse: success code===>" + response.code());
                Log.d(TAG, "onResponse: success body===>" + response.body());
                Log.d(TAG, "onResponse: success ===>" + response.isSuccessful());
                List<Pagination.ArticlesBean> artist = response.body().getArticles();
//                if (initLoad)
//                    GlobalClass.getDbInstance().clearSData();
                GlobalClass.getDbInstance().insertArtist(artist);
                pagNo++;
//                if (initLoad) {
//                    initCallback.onResult(artist, null, artist.size() + 1);
//                } else {
//                    int nextKey = params + artist.size();
//                    loadCallback.onResult(artist, nextKey);
//                }

                if (response.errorBody() != null) {
                    Log.d(TAG, "onResponse: error body= nameOfNews==>" + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Pagination> call, Throwable t) {
//                if (progressDialog != null) {
//                    progressDialog.dismiss();
//                }
//                mainSwipe.setRefreshing(false);
                Log.d(TAG, "onResponse: onFailure: " + t.getMessage());
//                Utility.apiError(ChannelListActivity.this);
            }
        });
    }
}
