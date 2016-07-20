package com.bingo.milkteashop.goods.callback;

/**
 * Created by Bingo on 16/7/12.
 */
public interface ItemTouchHelperCallback {
    void onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
