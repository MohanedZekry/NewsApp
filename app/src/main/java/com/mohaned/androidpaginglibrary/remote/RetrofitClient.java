package com.mohaned.androidpaginglibrary.remote;

import com.mohaned.androidpaginglibrary.model.DataResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static RetrofitClient insance;
    private static final String BASE_URL = "https://api.stackexchange.com/2.2/";
    private RetrofitCallsAPI retrofitCallsAPI;

    public static synchronized RetrofitClient getInsance() {
        if (insance == null)
            insance = new RetrofitClient();
        return insance;
    }

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitCallsAPI = retrofit.create(RetrofitCallsAPI.class);
    }

    public Call<DataResponse> getAnswers(){
        return retrofitCallsAPI.getAnswers(1,50, "stackoverflow");
    }

}
