package com.toor.alcproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearnerApi {
    @GET("hours")
    Call<List<Learner>> getHours();
}

