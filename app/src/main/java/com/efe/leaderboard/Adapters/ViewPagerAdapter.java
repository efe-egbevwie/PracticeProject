package com.efe.leaderboard.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.efe.leaderboard.Fragments.LeaderBoardFragment;
import com.efe.leaderboard.Fragments.SkillIqFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] tabTitles = new String[]{"Learning Leaders", "Skill Iq Leaders"};
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LeaderBoardFragment();

            case 1:
                return new SkillIqFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
