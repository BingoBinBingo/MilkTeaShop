package com.bingo.milkteashop.pay.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListPopupWindow;

import com.bingo.milkteashop.BaseFragment;
import com.bingo.milkteashop.R;

/**
 * Created by Bingo on 16/7/8.
 */
public class PayFragment extends BaseFragment {
    private static final String TAG = PayFragment.class.getCanonicalName();

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
    protected void initListener() {

    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View rootView = inflater.inflate(R.layout.pay_fragment_layout, container, false);
        rootView.findViewById(R.id.showPoppupWindow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
                String[] datas = {"1", "2", "3", "4", "5", "6"};
                ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, datas);
                listPopupWindow.setAdapter(adapter);
                listPopupWindow.setAnchorView(v);
                listPopupWindow.show();
            }
        });

        return rootView;
    }

    @Override
    protected void renderView() {

    }

    @Override
    public void onOpenDrawerEvent() {
    }
}
