package com.bingo.milkteashop.pay.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bingo.milkteashop.BaseFragment;
import com.bingo.milkteashop.R;

/**
 * Created by Bingo on 16/7/8.
 */
public class PayFragment extends BaseFragment {
    private static final String TAG = PayFragment.class.getCanonicalName();
    private android.support.v7.app.ActionBar mActionBar;
    private TextView mPayBtn;
    private TextView mReloadBtn;
    private TextView mMrgBtn;

    public static PayFragment newInstance() {

        Bundle args = new Bundle();

        PayFragment fragment = new PayFragment();
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
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View rootView = inflater.inflate(R.layout.pay_fragment_layout, container, false);

        //actionBar
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setTitle(R.string.Pay_toolbar);
        mActionBar.setHomeAsUpIndicator(R.drawable.audio_call_record);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeButtonEnabled(true);

        mPayBtn = (TextView)rootView.findViewById(R.id.payBtn);
        mReloadBtn = (TextView)rootView.findViewById(R.id.reloadBtn);
        mMrgBtn = (TextView)rootView.findViewById(R.id.managerBtn);

        return rootView;
    }

    @Override
    protected void initListener() {
        mPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mReloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mMrgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void renderView() {

    }

    @Override
    public void onOpenDrawerEvent() {
        super.onOpenDrawerEvent();
    }
}
