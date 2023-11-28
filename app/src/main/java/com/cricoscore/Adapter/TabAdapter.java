package com.cricoscore.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.cricoscore.Fragment.MatchFragment;
import com.cricoscore.Fragment.TournamentFragment;

public class TabAdapter extends FragmentStateAdapter {



    public TabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return new MatchFragment();
        }
        return new TournamentFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}