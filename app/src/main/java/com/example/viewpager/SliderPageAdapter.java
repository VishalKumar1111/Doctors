package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.ListFragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderPageAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentsList;

    public SliderPageAdapter(FragmentManager fm, List<Fragment> fragmentsList ) {
        super(fm);
        this.fragmentsList=fragmentsList;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}
