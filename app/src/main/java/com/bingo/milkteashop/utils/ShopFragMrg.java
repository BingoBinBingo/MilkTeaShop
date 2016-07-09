package com.bingo.milkteashop.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.bingo.milkteashop.BaseFragment;
import com.bingo.milkteashop.R;
import com.bingo.milkteashop.gift.fragment.GiftFragment;
import com.bingo.milkteashop.goods.fragment.OrderFragment;
import com.bingo.milkteashop.history.fragment.HistoryFragment;
import com.bingo.milkteashop.homepage.fragment.HomeFragment;
import com.bingo.milkteashop.message.fragment.MessagesFragment;
import com.bingo.milkteashop.music.fragment.MusicFragment;
import com.bingo.milkteashop.pay.fragment.PayFragment;
import com.bingo.milkteashop.stores.fragment.StoresFragment;

import java.util.HashMap;
import java.util.Map;
import static com.bingo.milkteashop.utils.ShopFragType.*;

/**
 * Created by Bingo on 16/7/9.
 */
public final class ShopFragMrg {
    private FragmentManager mSysFragMrg;
    private static ShopFragMrg sInstance;
    /**
     * 用来保存当前正在显示的Fragment
     */
    private String mCurrFragTag = "";
    private Map<String, BaseFragment> mFragMap = new HashMap<>();
    private static final int FRAG_CONTAINER_ID = R.id.fragContainer;

    public static ShopFragMrg getInstance(FragmentManager fragMrg) {
        if(sInstance == null) {
            synchronized (ShopFragMrg.class) {
                if(sInstance == null) {
                    sInstance = new ShopFragMrg(fragMrg);        
                }               
            }
        }
        return sInstance;
    }
    
    private ShopFragMrg(FragmentManager fragMrg) {
        mSysFragMrg = fragMrg;
        initFrag();
    }

    private void initFrag() {
        mFragMap.put(HOME_FRAG, HomeFragment.newInstance());
        mFragMap.put(PAY_FRAG, PayFragment.newInstance());
        mFragMap.put(ORDER_FRAG, OrderFragment.newInstance());
        mFragMap.put(HISTORY_FRAG, HistoryFragment.newInstance());
        mFragMap.put(MESSAGE_FRAG, MessagesFragment.newInstance());
        mFragMap.put(STORES_FRAG, StoresFragment.newInstance());
        mFragMap.put(GIFT_FRAG, GiftFragment.newInstance());
        mFragMap.put(MUSIC_FRAG, MusicFragment.newInstance());
    }


    public void switchFragment(String fragTag) {
        // 隐藏之前
        Fragment prevFrag = mSysFragMrg.findFragmentByTag(mCurrFragTag);
        if(prevFrag != null) {
            mSysFragMrg.beginTransaction().hide(prevFrag).commit();
        }

        // 添加现在
        mCurrFragTag = fragTag;
        if(isFragAdded(mCurrFragTag)) {
            //show
            mSysFragMrg.beginTransaction().show(mFragMap.get(fragTag)).commit();
        } else {
            //add
            mSysFragMrg.beginTransaction().add(FRAG_CONTAINER_ID, mFragMap.get(fragTag), fragTag).commit();
        }
    }

    private boolean isFragAdded(String fragType) {
        if(mSysFragMrg.findFragmentByTag(fragType) != null) {
            return true;
        }
        return false;
    }
    
}
