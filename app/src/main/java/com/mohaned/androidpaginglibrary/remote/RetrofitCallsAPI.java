package com.mohaned.androidpaginglibrary.remote;

import com.mohaned.androidpaginglibrary.model.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitCallsAPI {

    @GET("answers")
    Call<DataResponse> getAnswers(
            @Query("page") int page,
            @Query("pagesize") int pagesize,
            @Query("site") String site);

}
