package com.bingo.milkteashop.goods.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Bingo on 16/7/10.
 */
public class GoodsAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragList;

    public GoodsAdapter(FragmentManager fragmentManager, List<Fragment> fragList) {
        super(fragmentManager);
        mFragList = fragList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragList.get(position);
    }

    @Override
    public int getCount() {
        return mFragList.size();
    }
}
