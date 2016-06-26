package com.i906.mpt.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.i906.mpt.main.mosque.MosqueFragment;
import com.i906.mpt.main.prayer.PrayerFragment;
import com.i906.mpt.main.qibla.QiblaFragment;

import java.util.ArrayList;
import java.util.List;

class MainAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    MainAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new QiblaFragment());
        mFragmentList.add(new PrayerFragment());
        mFragmentList.add(new MosqueFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
