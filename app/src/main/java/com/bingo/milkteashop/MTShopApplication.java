package com.bingo.milkteashop;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by Bingo on 16/7/3.
 */
public class MTShopApplication extends Application {
    private static final String TAG = MTShopApplication.class.getCanonicalName();
    private static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        Log.v(TAG, "-DemoApplication-我被创建--onCreate-");
    }

    public static Context getContext() {
        return sContext;
    }
}
