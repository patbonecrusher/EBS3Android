package com.example.pat.ebs3_android;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class EBPagerAdapter extends FragmentStatePagerAdapter {
    Activity mActivity;
    List<EBSplitViewFragment> fragments = new ArrayList<>();

    public EBPagerAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        this.mActivity = activity;
    }

    public void addFragment(EBSplitViewFragment fragment) {
        this.fragments.add(fragment);
        this.notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
