package com.zhuyue.bwie.com.zhuyue20181112.Badapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mList;
    private ArrayList<String> mTitle;

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> title) {
        super(fm);
        this.mList = list;
        this.mTitle = title;
    }

    @Override
    public Fragment getItem(int i) {
        return mList.get(i);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
