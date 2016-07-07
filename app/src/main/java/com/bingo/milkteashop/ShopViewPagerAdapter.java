package com.bingo.milkteashop;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Bingo on 16/7/8.
 */
public class ShopViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = ShopViewPagerAdapter.class.getCanonicalName();
    private List<BaseFragment> mFragmentList;

    public ShopViewPagerAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        mFragmentList = fragmentList;
    }

    @Override
    public BaseFragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
