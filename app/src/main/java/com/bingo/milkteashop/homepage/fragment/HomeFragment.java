package com.bingo.milkteashop.homepage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bingo.milkteashop.BaseFragment;
import com.bingo.milkteashop.R;

/**
 * Created by Bingo on 16/7/8.
 */
public class HomeFragment extends BaseFragment {
    private static final String TAG = HomeFragment.class.getCanonicalName();

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initModel() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View rootView = inflater.inflate(R.layout.home_fragment_layout, container, false);
        return rootView;
    }

    @Override
    protected void renderView() {

    }

    @Override
    public void onOpenDrawerEvent() {

    }
}
