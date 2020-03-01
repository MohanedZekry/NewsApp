package com.mohaned.androidpaginglibrary.repository;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import com.mohaned.androidpaginglibrary.model.DataResponse;
import com.mohaned.androidpaginglibrary.model.Item;
import com.mohaned.androidpaginglibrary.remote.RetrofitClient;
import com.mohaned.androidpaginglibrary.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, Item> {

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Item> callback) {
        RetrofitClient.getInsance().getAnswers(Constants.FIRST_PAGE, Constants.PAGE_SIZE, Constants.SITE_NAME)
                .enqueue(new Callback<DataResponse>() {
                    @Override
                    public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                        if (response.body() != null) {
                            callback.onResult(response.body().getItems(), null, Constants.FIRST_PAGE + 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<DataResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {
        RetrofitClient.getInsance().getAnswers(Constants.FIRST_PAGE, Constants.PAGE_SIZE, Constants.SITE_NAME)
                .enqueue(new Callback<DataResponse>() {
                    @Override
                    public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {


                        Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
                        if (response.body() != null) {

                            callback.onResult(response.body().getItems(), adjacentKey);
                        }
                    }

                    @Override
                    public void onFailure(Call<DataResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {
        RetrofitClient.getInsance()
                .getAnswers(Constants.FIRST_PAGE, Constants.PAGE_SIZE, Constants.SITE_NAME)
                .enqueue(new Callback<DataResponse>() {
                    @Override
                    public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                        if (response.body() != null) {
                            Integer key = response.body().isHas_more() ? params.key + 1 : null;
                            callback.onResult(response.body().getItems(), key);
                        }
                    }
                    @Override
                    public void onFailure(Call<DataResponse> call, Throwable t) {

                    }
                });
    }
}