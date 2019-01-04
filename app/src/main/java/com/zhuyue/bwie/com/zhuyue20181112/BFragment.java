package com.zhuyue.dell.monilianxi;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuyue.bwie.com.zhuyue20181112.AFragment;
import com.zhuyue.bwie.com.zhuyue20181112.Badapter.MyPagerAdapter;
import com.zhuyue.bwie.com.zhuyue20181112.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {
    private View mView;
    private TabLayout BFage_Tab;
    private ViewPager BFage_Pager;
    private ArrayList<Fragment> mList = new ArrayList<>();
    private ArrayList<String> mTitle = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_b, container, false);
        initData();
        initView(mView);
        return mView;
    }

    private void initData() {
        mList.add(new AFragment());
        mList.add(new AFragment());
        mTitle.add("新闻");
        mTitle.add("娱乐");
    }

    private void initView(View mView) {
        BFage_Tab = mView.findViewById(R.id.BFrag_Tab);
        BFage_Pager = mView.findViewById(R.id.BFrag_Pager);
        BFage_Pager.setAdapter(new MyPagerAdapter(getChildFragmentManager(), mList, mTitle));
        BFage_Tab.setupWithViewPager(BFage_Pager);


    }


}
