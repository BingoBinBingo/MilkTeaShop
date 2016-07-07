package com.bingo.milkteashop;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.bingo.milkteashop.goods.fragment.GiftFragment;
import com.bingo.milkteashop.goods.fragment.HistoryFragment;
import com.bingo.milkteashop.goods.fragment.HomeFragment;
import com.bingo.milkteashop.goods.fragment.MessagesFragment;
import com.bingo.milkteashop.goods.fragment.MusicFragment;
import com.bingo.milkteashop.goods.fragment.OrderFragment;
import com.bingo.milkteashop.goods.fragment.PayFragment;
import com.bingo.milkteashop.goods.fragment.StoresFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bingo.milkteashop.utils.FragmentType.GIFT_FRAG;
import static com.bingo.milkteashop.utils.FragmentType.HISTORY_FRAG;
import static com.bingo.milkteashop.utils.FragmentType.HOME_FRAG;
import static com.bingo.milkteashop.utils.FragmentType.MESSAGE_FRAG;
import static com.bingo.milkteashop.utils.FragmentType.MUSIC_FRAG;
import static com.bingo.milkteashop.utils.FragmentType.ORDER_FRAG;
import static com.bingo.milkteashop.utils.FragmentType.PAY_FRAG;
import static com.bingo.milkteashop.utils.FragmentType.STORES_FRAG;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ViewPager mViewPager;
    private ShopViewPagerAdapter mAdapter;
    private Map<Integer, Integer> mFragTypeMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initModel();
        initData();
        initView();
        initListener();
    }

    private void initModel() {

    }

    private void initData() {
        mFragTypeMap.put(R.id.men1, HOME_FRAG);
        mFragTypeMap.put(R.id.men2, PAY_FRAG);
        mFragTypeMap.put(R.id.men3, ORDER_FRAG);
        mFragTypeMap.put(R.id.men4, HISTORY_FRAG);
        mFragTypeMap.put(R.id.men5, MESSAGE_FRAG);
        mFragTypeMap.put(R.id.men6, STORES_FRAG);
        mFragTypeMap.put(R.id.men7, GIFT_FRAG);
        mFragTypeMap.put(R.id.men8, MUSIC_FRAG);

        List<BaseFragment> fragList = new ArrayList<>();
        fragList.add(HomeFragment.newInstance());
        fragList.add(PayFragment.newInstance());
        fragList.add(OrderFragment.newInstance());
        fragList.add(HistoryFragment.newInstance());
        fragList.add(MessagesFragment.newInstance());
        fragList.add(StoresFragment.newInstance());
        fragList.add(GiftFragment.newInstance());
        fragList.add(MusicFragment.newInstance());

        mAdapter = new ShopViewPagerAdapter(getSupportFragmentManager(), fragList);

    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mViewPager = (ViewPager) findViewById(R.id.fragViewPager);

        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(HOME_FRAG);
    }

    private void initListener() {
        //Toolbar

        //DrawerLayout
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        //NavigationView
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                // TODO: 16/7/3  点击不同的Tab，在FrameLayout中显示不同的内容
                switchFragment( mFragTypeMap.get(menuItem.getItemId()) );
                return true;
            }
        });
    }

    private void switchFragment(int fragType) {
        mViewPager.setCurrentItem(fragType);
    }





}
