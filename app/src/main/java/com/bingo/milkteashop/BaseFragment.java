package com.bingo.milkteashop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bingo.milkteashop.event.OpenDrawerEvent;
import com.bingo.milkteashop.utils.ToastThread;

import de.greenrobot.event.EventBus;

/**
 * Created by Bingo on 16/7/8.
 */
public abstract class BaseFragment extends Fragment implements ToolBarBtnEvent{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        initModel();
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = initView(inflater, container);
        initListener();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        renderView();
    }

    /**
     *  初始化与界面元素无关的数据
     */
    protected abstract void initModel();

    protected abstract void initData();

    /**
     * 给控件注册监听
     */
    protected abstract void initListener();

    /**
     * 从.xml文件中获取控件元素
     */
    protected abstract View initView(LayoutInflater inflater, @Nullable ViewGroup container);

    /**
     * 给initView出来的控件渲染数据
     */
    protected abstract void renderView();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ToastThread.showMsg(item.getItemId() + "");
        if (item.getItemId() == android.R.id.home) {
            //actionbar  左边的按钮
            onOpenDrawerEvent();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOpenDrawerEvent() {
        EventBus.getDefault().post(new OpenDrawerEvent());
    }

    @Override
    public void onFragBackEvent() {
    }
}
