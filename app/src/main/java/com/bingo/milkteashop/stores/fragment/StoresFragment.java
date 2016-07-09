package com.bingo.milkteashop.stores.fragment;

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
public class StoresFragment extends BaseFragment {
    private static final String TAG = StoresFragment.class.getCanonicalName();

    public static StoresFragment newInstance() {

        Bundle args = new Bundle();

        StoresFragment fragment = new StoresFragment();
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
        View rootView = inflater.inflate(R.layout.stores_fragment_layout, container, false);
        return rootView;
    }

    @Override
    protected void renderView() {

    }
}
