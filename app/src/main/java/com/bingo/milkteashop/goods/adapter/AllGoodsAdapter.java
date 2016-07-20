package com.bingo.milkteashop.goods.adapter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bingo.milkteashop.R;
import com.bingo.milkteashop.goods.bean.Food;
import com.bingo.milkteashop.goods.callback.ItemTouchHelperCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bingo on 16/7/12.
 */
public class AllGoodsAdapter extends RecyclerView.Adapter<AllGoodsAdapter.GoodsItemViewHolder>
    implements ItemTouchHelperCallback {

    private List<Food> mFoodList = new ArrayList<>();

    public AllGoodsAdapter(List<Food> foodList) {
        mFoodList = foodList;
    }

    public void updateDatas(List<Food> foodList) {
        mFoodList.clear();
        mFoodList.addAll(foodList);
        notifyDataSetChanged();
    }

    @Override
    public GoodsItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.goods_item_layout, parent, false);
        return new GoodsItemViewHolder(rootView);
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    @Override
    public void onBindViewHolder(GoodsItemViewHolder holder, int position) {
        holder.foodName.append(mFoodList.get(position).id + "");
        holder.foodName.append(",");
        holder.foodName.append(mFoodList.get(position).name);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mFoodList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        mFoodList.remove(position);
        notifyItemRemoved(position);
    }

    public class GoodsItemViewHolder extends RecyclerView.ViewHolder {
        private TextView foodName;
        public GoodsItemViewHolder(View itemView) {
            super(itemView);
            foodName = (TextView) itemView.findViewById(R.id.foodName);
        }
    }

    public static class SimpleItemDecoration extends RecyclerView.ItemDecoration {
        private Paint mPaint;

        public SimpleItemDecoration() {
            mPaint = new Paint();
            mPaint.setColor(Color.YELLOW);
            mPaint.setStrokeWidth(0.1f);
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.set(0, 0, 0, 0);
        }

        /**
         * 先执行 onDraw -> view.onDraw -> onDrawOver
         * @param c
         * @param parent
         * @param state
         */
        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDraw(c, parent, state);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            final int left = parent.getPaddingLeft();
            final int right = parent.getWidth() - parent.getPaddingRight();
            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int top1 = child.getTop() ;
                final int bottom1 = top1 + child.getHeight();
                c.drawRect(left, top1, right, top1+1, mPaint);
//                if (i == 0) {
//                    c.drawRect(left, top1, right, bottom1, mPaint);
//                }
                if(i == childCount -1) {
                    //画最后一个
                    c.drawRect(left, bottom1, right, bottom1 +1, mPaint);
                }
            }
        }
    }
}
