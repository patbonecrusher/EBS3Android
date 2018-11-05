package com.example.pat.ebs3_android;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    Activity mActivity;

    public MyPagerAdapter(FragmentManager fm, int NumOfTabs, Activity activity) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.mActivity = activity;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TestFragment tab1 = new TestFragment("TAB1");
                return tab1;
            case 1:
                TestFragment tab2 = new TestFragment("TAB2");
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;//mNumOfTabs;
    }
}
