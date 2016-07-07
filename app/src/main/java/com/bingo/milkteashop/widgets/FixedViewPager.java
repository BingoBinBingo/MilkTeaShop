package com.bingo.milkteashop.widgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Bingo on 16/7/1.
 */
public class FixedViewPager extends ViewPager {
    private boolean mIsCanScroll = false;
    public FixedViewPager(Context context) {
        super(context);
    }

    public FixedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollState(boolean isCanScroll) {
        mIsCanScroll = isCanScroll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!mIsCanScroll) {
            return false;
        } else {
            return super.onTouchEvent(ev);
        }

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (!mIsCanScroll) {
            return false;
        } else {
            return super.onInterceptTouchEvent(ev);
        }

    }
}
