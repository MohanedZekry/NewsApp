package com.mohaned.androidpaginglibrary.repository;

import androidx.lifecycle.MutableLiveData;

import com.mohaned.androidpaginglibrary.model.DataResponse;

public interface GetAnswerRepo {
    MutableLiveData<DataResponse> getAnswers();
    void loadAnswers();
}
