package com.mohaned.androidpaginglibrary.repository;

import androidx.lifecycle.MutableLiveData;
import com.mohaned.androidpaginglibrary.model.DataResponse;
import com.mohaned.androidpaginglibrary.remote.RetrofitClient;
import com.mohaned.androidpaginglibrary.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAnswersRepoImpl implements GetAnswerRepo {
    private MutableLiveData<DataResponse> dataResponseMutableLiveData;
    static GetAnswersRepoImpl instance;

    public static GetAnswersRepoImpl getInstance() {
        if (instance == null)
            instance = new GetAnswersRepoImpl();
        return instance;
    }

    private GetAnswersRepoImpl(){
        dataResponseMutableLiveData = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<DataResponse> getAnswers() {
        loadAnswers();
        return dataResponseMutableLiveData;
    }

    @Override
    public void loadAnswers() {
        RetrofitClient.getInsance().getAnswers(Constants.FIRST_PAGE, Constants.PAGE_SIZE, Constants.SITE_NAME)
                .enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.body() != null) {
//                    callback.onResult(response.body().getItems(), null, FIRST_PAGE + 1);
                }

                dataResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
    }
}
