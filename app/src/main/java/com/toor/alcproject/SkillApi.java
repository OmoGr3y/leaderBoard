package com.toor.alcproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillApi {

    @GET("skilliq")
        Call<List<Skill>> getSkillsiq();
}
