package com.mohaned.androidpaginglibrary.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.mohaned.androidpaginglibrary.model.DataResponse;
import com.mohaned.androidpaginglibrary.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAnswersRepoImpl implements GetAnswerRepo {
    private MutableLiveData<DataResponse> dataResponseMutableLiveData;
    static GetAnswersRepoImpl instance;
    private Context mContext;

    public static GetAnswersRepoImpl getInstance(Context mContext) {
        if (instance == null)
            instance = new GetAnswersRepoImpl(mContext);
        return instance;
    }

    private GetAnswersRepoImpl(Context mContext){
        this.mContext = mContext;
        dataResponseMutableLiveData = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<DataResponse> getAnswers() {
        loadAnswers();
        return dataResponseMutableLiveData;
    }

    @Override
    public void loadAnswers() {
        RetrofitClient.getInsance().getAnswers().enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                dataResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
    }
}
