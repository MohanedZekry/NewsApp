package com.mohaned.androidpaginglibrary.remote;

import com.mohaned.androidpaginglibrary.model.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitCallsAPI {

    @GET("answer")
    Call<DataResponse> getAnswers(
            @Query("page") int page,
            @Query("pagesize") int size,
            @Query("site") String site);

}
