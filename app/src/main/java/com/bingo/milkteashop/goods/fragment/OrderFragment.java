package com.bingo.milkteashop.goods.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bingo.milkteashop.BaseFragment;
import com.bingo.milkteashop.R;
import com.bingo.milkteashop.goods.adapter.GoodsAdapter;
import com.bingo.milkteashop.history.fragment.HistoryFragment;
import com.bingo.milkteashop.message.fragment.MessagesFragment;
import com.bingo.milkteashop.music.fragment.MusicFragment;
import com.bingo.milkteashop.pay.fragment.PayFragment;
import com.bingo.milkteashop.utils.ToastThread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bingo on 16/7/8.
 */
public class OrderFragment extends BaseFragment {
    private static final String TAG = OrderFragment.class.getCanonicalName();
    private android.support.v7.app.ActionBar mActionBar;
    private TabLayout mTabLayout;
    private ViewPager mGoodsViewPager;
    private GoodsAdapter mGoodsAdapter;

    public static OrderFragment newInstance() {

        Bundle args = new Bundle();

        OrderFragment fragment = new OrderFragment();
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
        //// TODO: 16/5/30 以下两个监听，将Tab和ViewPager 一一对应起来
        mTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mGoodsViewPager));
        mGoodsViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View rootView = inflater.inflate(R.layout.order_fragment_layout, container, false);

        //actionBar
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setTitle(R.string.Menu_toolbar);
        mActionBar.setHomeAsUpIndicator(R.drawable.audio_call_record);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeButtonEnabled(true);

        mTabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        mGoodsViewPager = (ViewPager) rootView.findViewById(R.id.goodsViewPager);
        initTabs();
        initViewPager();
        return rootView;
    }

    private void initTabs() {
        TabLayout.Tab categories = mTabLayout.newTab();
        TabLayout.Tab recents = mTabLayout.newTab();
        TabLayout.Tab features = mTabLayout.newTab();
        TabLayout.Tab all = mTabLayout.newTab();

        categories.setText("CATAGORIE");
        recents.setText("RECENTS");
        features.setText("FEATURES");
        all.setText("ALL");

        mTabLayout.addTab(categories);
        mTabLayout.addTab(recents);
        mTabLayout.addTab(features);
        mTabLayout.addTab(all);
    }

    private void initViewPager() {
        List<Fragment> fragList = new ArrayList<>();
        fragList.add(MusicFragment.newInstance());
        fragList.add(MessagesFragment.newInstance());
        fragList.add(HistoryFragment.newInstance());
        fragList.add(PayFragment.newInstance());

        mGoodsAdapter = new GoodsAdapter(getActivity().getSupportFragmentManager(), fragList);
        mGoodsViewPager.setAdapter(mGoodsAdapter);
    }

    @Override
    protected void renderView() {
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.order_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ToastThread.showMsg("searchItem clicked");
        if(item.getItemId() == R.id.searchItem) {

        }
        return super.onOptionsItemSelected(item);
    }

}
