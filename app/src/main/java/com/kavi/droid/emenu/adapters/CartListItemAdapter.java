package com.kavi.droid.emenu.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.models.CartItem;
import com.kavi.droid.emenu.views.CartListItemView;

import java.util.List;

/**
 * Created by kavi707 on 8/17/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class CartListItemAdapter extends BaseAdapter {

    private List<CartItem> cartItemList;
    private Context context;

    public CartListItemAdapter(List<CartItem> cartItemList, Context context) {
        this.cartItemList = cartItemList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cartItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return (cartItemList == null)?null:cartItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CartListItemView cartListItemView;
        if (convertView == null) {
            cartListItemView = (CartListItemView) View.inflate(context, R.layout.view_cart_list_item, null);
        } else {
            cartListItemView = (CartListItemView) convertView;
        }

        cartListItemView.setCartItem(cartItemList.get(position));
        return cartListItemView;
    }
}
