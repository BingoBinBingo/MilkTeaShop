package com.bingo.milkteashop;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.bingo.milkteashop.utils.ShopFragMrg;

import java.util.HashMap;
import java.util.Map;

import static com.bingo.milkteashop.utils.ShopFragType.GIFT_FRAG;
import static com.bingo.milkteashop.utils.ShopFragType.HISTORY_FRAG;
import static com.bingo.milkteashop.utils.ShopFragType.HOME_FRAG;
import static com.bingo.milkteashop.utils.ShopFragType.MESSAGE_FRAG;
import static com.bingo.milkteashop.utils.ShopFragType.MUSIC_FRAG;
import static com.bingo.milkteashop.utils.ShopFragType.ORDER_FRAG;
import static com.bingo.milkteashop.utils.ShopFragType.PAY_FRAG;
import static com.bingo.milkteashop.utils.ShopFragType.STORES_FRAG;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Map<Integer, String> mFragTypeMap = new HashMap<>();
    private ShopFragMrg mFragMrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initModel();
        initData();
        initView();
        initListener();
        renderView();
    }

    private void initModel() {
        mFragMrg = ShopFragMrg.getInstance(getSupportFragmentManager());
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
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
    }

    private void initListener() {

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
                mFragMrg.switchFragment(mFragTypeMap.get(menuItem.getItemId()));
                return true;
            }
        });
    }

    private void renderView() {
        mFragMrg.switchFragment(HOME_FRAG);
    }


}
