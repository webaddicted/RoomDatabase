package com.deepaksharma.webaddicted.roomdatabase.api;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Deepak Sharma
 */

public class APIResponse {
    private static String TAG = APIResponse.class.getSimpleName();
//    Step 1-> for call api

//    private void loginAppi() {
//        Retrofit retrofit = ApiLists.retrofit;
//        ApiLists apiList = retrofit.create(ApiLists.class);
//        Call<JsonElement> loginApiCall = apiList.loginApi("kjdf", "fkldngdkl");
//        APIResponse.callRetrofit(loginApiCall, "LoginApi", LoginActivity.this, this);
//    }

//    Step 2-> make a listener & implement in calling api Activity

    public interface ApiListener {
        void success(String strApiName, Object response);

        void error(String strApiName, String error);

        void failure(String strApiName, String message);
    }

//    Step 3-> implement interface response

//    @Override
//    public void success(String strApiName, String response) {
//        if (strApiName.equals("LoginApi")) {
//            Log.d(TAG, "onResponse: success: LoginApi response===>"+response);
////            NearByNurse nearByNurse = (NearByNurse) response.body(); // use the user object for the other fields
//        }
//    }
//
//    @Override
//    public void error(String strApiName, String error) {
//        Log.d(TAG, "onResponse: Error: "+strApiName +"  Error Response===>"+error);
//    }
//
//    @Override
//    public void failure(String strApiName, String message) {
//        Log.d(TAG, "onResponse: Failure: "+strApiName +"  Failure Response===>"+message);
//    }

    static ProgressDialog progressDialog;

    public static <T> void callRetrofit(Call<T> call, final String strApiName, Activity context, final ApiListener apiListener) {
        context.runOnUiThread(new Runnable() {
            public void run() {
                progressDialog = new ProgressDialog(context);
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        });

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                Log.d(TAG, "onResponse: Api Name===>" + strApiName +
                        "\n Response code===>" + response.code() +
                        "\n Response success===>" + response.isSuccessful() +
                        "\n Response body===>" + response.body().toString());

                if (response.body() != null) {
//                          NearByNurse nearByNurse = (NearByNurse) response.body(); // use the user object for the other fields
                    apiListener.success(strApiName, response.body());
                    progressDialog.dismiss();
                } else {
                    try {
                        Log.d(TAG, "onResponse: Api Name --" + strApiName +
                                "\n error===>" + response.errorBody().string());
                        apiListener.error(strApiName, response.errorBody().string());
                        progressDialog.dismiss();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (response.errorBody() != null) {
                    Log.d(TAG, "onResponse: response.errorBody()===>" + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.d(TAG, "onResponse: onFailure: " + t.toString());
                apiListener.failure(strApiName, t.toString());
                progressDialog.dismiss();
            }
        });
    }
}
