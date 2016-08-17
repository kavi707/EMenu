package com.kavi.droid.emenu.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.adapters.CartListItemAdapter;
import com.kavi.droid.emenu.adapters.CategoryListItemAdapter;
import com.kavi.droid.emenu.models.CartItem;
import com.kavi.droid.emenu.models.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kavi707 on 8/16/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class CartListDialog extends Dialog {

    private ListView cartListView;
    private RelativeLayout drinksRelativeLayout;
    private TextView totalAmtTextView;
    private ImageButton placeOrderImageBtn;

    private Context context;
    private List<CartItem> cartItemList = new ArrayList<>();
    private CartListItemAdapter cartListItemAdapter;

    public CartListDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_cart_list);

        setUpViews();
    }

    private void setUpViews() {

        cartListView = (ListView) findViewById(R.id.cartItemListView);
        drinksRelativeLayout = (RelativeLayout) findViewById(R.id.drinksRelativeLayout);
        totalAmtTextView = (TextView) findViewById(R.id.totalAmtTextView);
        placeOrderImageBtn = (ImageButton) findViewById(R.id.placeOrderImageBtn);

        // Load the cart items
        loadCartListItems();
    }

    private void loadCartItemListView(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
        cartListItemAdapter = new CartListItemAdapter(cartItemList, context);
        cartListView.setAdapter(cartListItemAdapter);
    }

    private void loadCartListItems() {

        // TODO - Replace with selected item list from menu
        CartItem sampleCartItem;
        for (int i = 0; i < 3; i++) {
            sampleCartItem = new CartItem();
            sampleCartItem.setQty(i+1);
            sampleCartItem.setName("Cart Item " + i);
            sampleCartItem.setComments("Cart Item comments " + i);
            sampleCartItem.setAmount(3000);

            cartItemList.add(sampleCartItem);
        }
        loadCartItemListView(cartItemList);
    }
}
