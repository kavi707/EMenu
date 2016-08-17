package com.kavi.droid.emenu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.models.CartItem;
import com.kavi.droid.emenu.services.imageLoader.ImageLoadingManager;

/**
 * Created by kavi707 on 8/17/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class CartListItemView extends RelativeLayout {

    private ImageView cartListItemImageView;
    private TextView cartListItemQtyTextView;
    private TextView cartItemNameTextView;
    private TextView cartItemDescriptionTextView;
    private TextView cartItemAmountTextView;

    private CartItem cartItem;
    private ImageLoadingManager imageLoadingManager = new ImageLoadingManager();

    public CartListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        cartListItemImageView = (ImageView) findViewById(R.id.cartListItemImageView);
        cartListItemQtyTextView = (TextView) findViewById(R.id.cartListItemQtyTextView);
        cartItemNameTextView = (TextView) findViewById(R.id.cartItemNameTextView);
        cartItemDescriptionTextView = (TextView) findViewById(R.id.cartItemDescriptionTextView);
        cartItemAmountTextView = (TextView) findViewById(R.id.cartItemAmountTextView);
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;

        cartItemNameTextView.setText(cartItem.getName());
        cartItemDescriptionTextView.setText(cartItem.getComments());
        cartListItemQtyTextView.setText("x" + String.valueOf(cartItem.getQty()));
        cartItemAmountTextView.setText(String.valueOf(cartItem.getAmount()));
        imageLoadingManager.loadImageToImageView(cartItem.getImageUrl(), cartListItemImageView);
    }
}
