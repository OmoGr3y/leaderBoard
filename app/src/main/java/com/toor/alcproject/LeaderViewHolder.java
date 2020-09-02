package com.toor.alcproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LeaderViewHolder extends RecyclerView.ViewHolder {

    TextView name, score, country;
    ImageView badgeUrl;

    public LeaderViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.item_name);
        score = itemView.findViewById(R.id.item_detail_1);
        country = itemView.findViewById(R.id.item_detail_2);
        badgeUrl = itemView.findViewById(R.id.badgeUrl);
    }
}
