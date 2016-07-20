package com.bingo.milkteashop.message.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bingo.milkteashop.BaseFragment;
import com.bingo.milkteashop.R;
import com.bingo.milkteashop.goods.adapter.AllGoodsAdapter;
import com.bingo.milkteashop.goods.bean.Food;
import com.bingo.milkteashop.goods.callback.SimpleItemTouchHelperCallback;
import com.bingo.milkteashop.utils.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bingo on 16/7/8.
 */
public class MessagesFragment extends BaseFragment {
    private static final String TAG = MessagesFragment.class.getCanonicalName();

    private RecyclerView mView;
    private AllGoodsAdapter mGoodsAdapter;

    public static MessagesFragment newInstance() {

        Bundle args = new Bundle();

        MessagesFragment fragment = new MessagesFragment();
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
        View rootView = inflater.inflate(R.layout.messages_fragment_layout, container, false);
        mView = (RecyclerView) rootView.findViewById(R.id.myRc);
        Food f1 = new Food("香蕉");
        Food f2 = new Food("苹果");
        Food f3 = new Food("西瓜");
        List<Food> foodList = new ArrayList<>();
        foodList.add(f1);
        foodList.add(f2);
        foodList.add(f3);

        //
        mGoodsAdapter = new AllGoodsAdapter(foodList);

        //touch事件
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mGoodsAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mView);

        //item的方向
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mView.setLayoutManager(layoutManager);

        //item的装饰
        RecyclerView.ItemDecoration itemDecoration = new AllGoodsAdapter.SimpleItemDecoration();
        mView.addItemDecoration(itemDecoration);
        mView.setAdapter(mGoodsAdapter);

        return rootView;
    }

    @Override
    protected void renderView() {
        obtainDataFromNetwork();
    }

    private void obtainDataFromNetwork() {
        //1-创建 队列
        RequestQueue queue = Volley.newRequestQueue(getContext());

//        //2-创建请求
//        JsonObjectRequest request = new JsonObjectRequest(
//                "http://192.168.1.105:8080/login",
//                null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d(TAG, "--huangbin--jsonObject--response=" + response.toString());
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d(TAG, "--huangbin--jsonObject--onErrorResponse-" + error.toString());
//                    }
//                }
//
//        );


        //2-创建请求
        StringRequest request = new StringRequest(
                "http://192.168.1.105:8080/login",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        //当服务端，使用{name:dsds}的形式，只能获取到当个
                        //当服务端，使用[{},{}]的形式，则要用获取List列表的形式
                        List<Food> foods = gson.fromJson(response, new TypeToken<List<Food>>(){}.getType());
                        Log.d(TAG, "---huangbin---json--success--food.size=" + foods.size());
                        mGoodsAdapter.updateDatas(foods);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "---huangbin---json--failed--error=" + error.toString());
                    }
                });

        //3-请求进队列
        queue.add(request);
    }

    @Override
    public void onOpenDrawerEvent() {

    }
}
