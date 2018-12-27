package com.deepaksharma.webaddicted.roomdatabase.api;


import com.deepaksharma.webaddicted.roomdatabase.db.entity.Pagination;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Anish Sharma on 17-04-2018.
 */

public interface ApiLists {
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ApiConstant.SERVER_PATH)
            .client(okHttpClient)
            .addConverterFactory(new NullOnEmptyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET()
    Call<Pagination> getChannelListName(@Url String strUrl);

//    @GET()
//    Call<HomeNewsModel> getChannelName(@Url String url);
//
//    @GET()
//    Call<CategoryDetails> getChannelListName(@Url String strUrl);
//    @GET()
//    Call<ChannelArticleModel> getChannelArticleApi(@Url String strUrl);
}
