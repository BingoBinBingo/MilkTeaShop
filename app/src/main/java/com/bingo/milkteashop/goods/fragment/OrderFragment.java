package com.bingo.milkteashop.goods.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.bingo.milkteashop.R;
import com.bingo.milkteashop.BaseFragment;

/**
 * Created by Bingo on 16/7/8.
 */
public class OrderFragment extends BaseFragment {
    public static OrderFragment newInstance() {

        Bundle args = new Bundle();

        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private static final String TAG = OrderFragment.class.getCanonicalName();

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
        View rootView = inflater.inflate(R.layout.order_fragment_layout, container, false);
        ((Spinner)rootView.findViewById(R.id.mySpinner)).setDropDownVerticalOffset(50);
        ((Spinner)rootView.findViewById(R.id.mySpinner)).setEnabled(true);
        return rootView;
    }

    @Override
    protected void renderView() {

    }
}
