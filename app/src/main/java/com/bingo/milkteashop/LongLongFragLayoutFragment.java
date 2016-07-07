package com.bingo.milkteashop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class LongLongFragLayoutFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initModel();
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = initView(inflater, container);
        initListener();
        return rootView;
    }

    private void initModel() {
    }

    private void initData() {
    }

    private View initView(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.long_long_frag_layout, container, false);
        return rootView;
    }

    private void initListener() {
    }

    private void setView() {
    }

}
