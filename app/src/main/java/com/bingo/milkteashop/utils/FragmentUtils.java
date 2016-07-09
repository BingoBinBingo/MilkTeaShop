package com.bingo.milkteashop.utils;

import android.support.v4.app.FragmentManager;

/**
 * Created by Bingo on 16/7/9.
 */
public class FragmentUtils {

    public static boolean isFragAdded(FragmentManager fragMrg, int fragId) {
        if(fragMrg.findFragmentById(fragId) != null) {
            return true;
        }
        return false;
    }
}
