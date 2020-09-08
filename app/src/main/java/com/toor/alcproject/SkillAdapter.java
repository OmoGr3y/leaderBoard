package com.toor.alcproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SkillAdapter extends RecyclerView.Adapter<LeaderViewHolder> {

    private List<Skill> mSkillList;
    private Context mContext;






    public SkillAdapter(List<Skill> skillList, Context context) {
        mSkillList = skillList;
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
        String url = "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png";
        Skill skill = mSkillList.get(position);
        int score = mSkillList.get(position).getScore();
        String country = mSkillList.get(position).getCountry();
        holder.name.setText(skill.getName());
//        holder.score.setText(skill.getScore().toString() + " " + mContext.getString(R.string.skills));
//        holder.country.setText(skill.getCountry());
        holder.score.setText(new StringBuilder().append(score).append(" Skill IQ Score, ").append(country).toString());
        Glide.with(mContext).load(url).into(holder.badgeUrl);


    }

    @Override
    public int getItemCount() {
        return mSkillList.size();
    }
}
