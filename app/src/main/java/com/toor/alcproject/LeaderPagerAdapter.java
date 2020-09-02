package com.toor.alcproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LeaderPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public LeaderPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.tabCount = behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LearnerFragment();
            case 1:
                return  new SkillFragment();
            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
