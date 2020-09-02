package com.toor.alcproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LearnerFragment extends Fragment {

    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    LearnerAdapter mLearnerAdapter;

    public LearnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learner, container, false);
        mRecyclerView = view.findViewById(R.id.learner_leader);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LearnerApi learnerApi = retrofit.create(LearnerApi.class);

        Call<List<Learner>> listCall = learnerApi.getHours();

        listCall.enqueue(new Callback<List<Learner>>() {
            @Override
            public void onResponse(Call<List<Learner>> call, Response<List<Learner>> response) {
                ShowIt(response.body());
            }

            @Override
            public void onFailure(Call<List<Learner>> call, Throwable t) {

            }
        });
        return view;


    }
    private void ShowIt(List<Learner> response) {

         mLearnerAdapter = new LearnerAdapter(response, getActivity());
        mRecyclerView.setAdapter(mLearnerAdapter);
    }
}