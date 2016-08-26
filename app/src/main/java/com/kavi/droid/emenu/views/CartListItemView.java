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

        // TODO - Uncomment this after service integration
        //imageLoadingManager.loadImageToImageView(cartItem.getImageUrl(), cartListItemImageView);

        // TODO - Remove this after service integration
        if (cartItem.getImageUrl().equals("img_cart_itm_001"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_001));
        else if (cartItem.getImageUrl().equals("img_cart_itm_002"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_002));
        else if (cartItem.getImageUrl().equals("img_cart_itm_003"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_002));
        else if (cartItem.getImageUrl().equals("img_cart_itm_004"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_004));
        else if (cartItem.getImageUrl().equals("img_cart_itm_005"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_005));
        else if (cartItem.getImageUrl().equals("img_cart_itm_006"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_006));
        else if (cartItem.getImageUrl().equals("img_cart_itm_007"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_007));
        else if (cartItem.getImageUrl().equals("img_cart_itm_008"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_008));
        else if (cartItem.getImageUrl().equals("img_cart_itm_009"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_009));
        else if (cartItem.getImageUrl().equals("img_cart_itm_010"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_010));
        else if (cartItem.getImageUrl().equals("img_cart_itm_011"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_011));
        else if (cartItem.getImageUrl().equals("img_cart_itm_012"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_012));
        else if (cartItem.getImageUrl().equals("img_cart_itm_013"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_013));
        else if (cartItem.getImageUrl().equals("img_cart_itm_014"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_014));
        else if (cartItem.getImageUrl().equals("img_cart_itm_015"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_015));
        else
            cartListItemImageView.setImageDrawable(null);
    }
}
