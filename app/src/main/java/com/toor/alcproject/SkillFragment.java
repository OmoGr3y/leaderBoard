package com.toor.alcproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SkillFragment extends Fragment {

    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    RecyclerView mRecyclerView;

    public SkillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skills, container, false);
        mRecyclerView = view.findViewById(R.id.skill_leader);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SkillApi skillApi = retrofit.create(SkillApi.class);

        Call<List<Skill>> listCall = skillApi.getSkillsiq();

        listCall.enqueue(new Callback<List<Skill>>() {
            @Override
            public void onResponse(Call<List<Skill>> call, Response<List<Skill>> response) {
                ShowIt(response.body());

            }

            @Override
            public void onFailure(Call<List<Skill>> call, Throwable t) {

            }
        });
        return view;


    }
    private void ShowIt(List<Skill> response) {

        SkillAdapter skillAdapter = new SkillAdapter(response, getActivity());
        mRecyclerView.setAdapter(skillAdapter);
    }


}