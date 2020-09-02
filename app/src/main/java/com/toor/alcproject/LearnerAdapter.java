package com.toor.alcproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class LearnerAdapter extends RecyclerView.Adapter<LeaderViewHolder> {

    private List<Learner> mLearnerList;
    private Context mContext;






    public LearnerAdapter(List<Learner> learnerList, Context context) {
        mLearnerList = learnerList;
        mContext = context;
    }

    @NonNull
    @Override
    public LeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_leaders,parent, false);
        return new LeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderViewHolder holder, int position) {
        String url ="https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png";
        Learner learner = mLearnerList.get(position);
        holder.name.setText(learner.getName());
        holder.score.setText(learner.getHours().toString());
        holder.country.setText(learner.getCountry());
        Glide.with(mContext).load(url).into(holder.badgeUrl);


    }

    @Override
    public int getItemCount() {
        return mLearnerList.size();
    }
}
