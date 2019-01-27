package com.deepaksharma.webaddicted.roomdatabase.repository;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import com.deepaksharma.webaddicted.roomdatabase.api.APIResponse;
import com.deepaksharma.webaddicted.roomdatabase.api.ApiClient;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.Pagination;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;

public class NewsDataSourceClass extends PageKeyedDataSource<Integer, Pagination.ArticlesBean> implements APIResponse.ApiListener {
    public static final String TAG = NewsDataSourceClass.class.toString();
    private final Activity mPagingActivity;
    private int sourceIndex = 1;
    private LoadInitialCallback<Integer, Pagination.ArticlesBean> loadInitCallback;
    private LoadCallback<Integer, Pagination.ArticlesBean> loadAfterCallback;

    public NewsDataSourceClass(Activity mPagingActivity) {
        this.mPagingActivity = mPagingActivity;
    }


    @SuppressLint("CheckResult")
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Pagination.ArticlesBean> callback) {
        Log.d(TAG, "okHttp: loadInitial: " + params.requestedLoadSize);
        loadInitCallback = callback;
        NEWSChannelListApi(sourceIndex);
//        repository.executeNewsApi(sourceIndex)
//                .doOnSubscribe(disposable ->
//                {
//                    compositeDisposable.add(disposable);
//                    progressLiveStatus.postValue(Constant.LOADING);
//                })
//                .subscribe(
//                        (JsonElement result) ->
//                        {
//                            progressLiveStatus.postValue(Constant.LOADED);
//
//                            JSONObject object = new JSONObject(gson.toJson(result));
//                            JSONArray array = object.getJSONArray("articles");
//
//                            ArrayList<NewsModelClass> arrayList = new ArrayList<>();
//
//                            for (int i = 0; i < array.length(); i++) {
//                                arrayList.add(new NewsModelClass(array.getJSONObject(i).optString("title"),
//                                        array.getJSONObject(i).optString("urlToImage")));
//                            }
//
//                            sourceIndex++;
//                            callback.onResult(arrayList, null, sourceIndex);
//                        },
//                        throwable ->
//                                progressLiveStatus.postValue(Constant.LOADED)
//
//                );

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Pagination.ArticlesBean> callback) {
        Log.d(TAG, "okHttp: loadBefore: " + params.requestedLoadSize);
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Pagination.ArticlesBean> callback) {
        Log.d(TAG, "okHttp: loadAfter: " + params.requestedLoadSize);
        loadAfterCallback = callback;
        NEWSChannelListApi(sourceIndex);
//        repository.executeNewsApi(params.key)
//                .doOnSubscribe(disposable ->
//                {
//                    compositeDisposable.add(disposable);
//                    progressLiveStatus.postValue(Constant.LOADING);
//                })
//                .subscribe(
//                        (JsonElement result) ->
//                        {
//                            progressLiveStatus.postValue(Constant.LOADED);
//
//                            JSONObject object = new JSONObject(gson.toJson(result));
//                            JSONArray array = object.getJSONArray("articles");
//
//                            ArrayList<NewsModelClass> arrayList = new ArrayList<>();
//
//                            for (int i = 0; i < array.length(); i++) {
//                                arrayList.add(new NewsModelClass(array.getJSONObject(i).optString("title"),
//                                        array.getJSONObject(i).optString("urlToImage")));
//                            }
//
//                            callback.onResult(arrayList, params.key == 3 ? null : params.key + 1);
//
//                        },
//                        throwable ->
//                                progressLiveStatus.postValue(Constant.LOADED)
//                );
    }

    private void NEWSChannelListApi(int pagNo) {
        String url = "https://newsapi.org/v2/everything?q=Aditya    birla&pageSize=20&page=" + pagNo + "&apiKey=e5e212cc147343cb9389cfb497c52bc2";
        Call<Pagination> tyreSelectedInfoBeanCall = ApiClient.getApis("").getChannelListName(url);
        APIResponse.callRetrofit(tyreSelectedInfoBeanCall, "url", mPagingActivity, this);
    }

    @Override
    public void success(String strApiName, Object response) {
        sourceIndex++;
        Pagination pagination = (Pagination) response;
        List<Pagination.ArticlesBean> articles = pagination.getArticles();
        if (loadAfterCallback != null) {
            loadAfterCallback.onResult(articles, sourceIndex + 1);
        }
        if (loadInitCallback != null) {
            loadInitCallback.onResult(articles, null, sourceIndex);
        }
        loadInitCallback = null;
        loadAfterCallback = null;
    }

    @Override
    public void error(String strApiName, String error) {
        Log.d(TAG, "okHttp: error: " + error);
    }

    @Override
    public void failure(String strApiName, String message) {
        Log.d(TAG, "okHttp: failure: " + message);
    }
}
