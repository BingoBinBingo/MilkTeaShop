package com.bingo.milkteashop.goods.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bingo.milkteashop.BaseFragment;
import com.bingo.milkteashop.R;

/**
 * Created by Bingo on 16/7/12.
 */
public class AllGoodsFragment extends BaseFragment{

    private RecyclerView mAllGoodsView;

    public static AllGoodsFragment newInstance() {

        Bundle args = new Bundle();

        AllGoodsFragment fragment = new AllGoodsFragment();
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
        View rootView = inflater.inflate(R.layout.all_goods_layout, container, false);
        mAllGoodsView = (RecyclerView)rootView.findViewById(R.id.allGoodsView);
        return null;
    }

    @Override
    protected void renderView() {

    }
}
