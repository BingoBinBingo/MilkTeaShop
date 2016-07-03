package com.bingo.milkteashop;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.bingo.milkteashop.utils.ToastThread;
import com.squareup.okhttp.MediaType;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initModel();
        initView();
        initListener();
    }

    private void initModel() {

    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("肿菜的CSDN");
        actionBar.setHomeAsUpIndicator(R.drawable.audio_call_record);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    private void initListener() {
        //Toolbar
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(mNavigationView);
            }
        });

        //DrawerLayout
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.audio_call_contact);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.audio_call_record);
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
                if (menuItem.getItemId() == R.id.men2) {
                    ToastThread.showMsg("账号的点击");
                }
                return true;
            }
        });

    }

}
