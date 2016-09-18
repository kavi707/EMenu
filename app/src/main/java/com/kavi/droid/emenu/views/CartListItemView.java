package com.kavi.droid.emenu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kavi.droid.emenu.Constants;
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
    private TextView cartItemCategoryTextView;
    private TextView cartItemSubCategoryTextView;
    private TextView cartItemAmountTextView;
    private TextView cartItemPortionTextView;
    private TextView alphaLabelTextView;

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
        cartItemCategoryTextView = (TextView) findViewById(R.id.cartItemCategoryTextView);
        cartItemSubCategoryTextView = (TextView) findViewById(R.id.cartItemSubCategoryTextView);
        cartItemAmountTextView = (TextView) findViewById(R.id.cartItemAmountTextView);
        cartItemPortionTextView = (TextView) findViewById(R.id.cartItemPortionTextView);
        alphaLabelTextView = (TextView) findViewById(R.id.alphaLabelTextView);
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;

        cartItemNameTextView.setText(cartItem.getName());
        cartItemCategoryTextView.setText(cartItem.getFoodItem().getCategory().getCategoryName());
        if (cartItem.getFoodItem().getSubCategory() != null) {
            cartItemSubCategoryTextView.setVisibility(VISIBLE);
            cartItemSubCategoryTextView.setText(cartItem.getFoodItem().getSubCategory().getSubCategoryName());
        } else {
            cartItemSubCategoryTextView.setVisibility(INVISIBLE);
        }
        cartListItemQtyTextView.setText("x" + String.valueOf(cartItem.getQty()));
        cartItemAmountTextView.setText(String.valueOf((int)cartItem.getAmount()));

        if (cartItem.getPortion() == Constants.ITEM_PORTION_SMALL) {
            cartItemPortionTextView.setText("SMALL");
        } else if (cartItem.getPortion() == Constants.ITEM_PORTION_MEDIUM) {
            cartItemPortionTextView.setText("MEDIUM");
        } else if (cartItem.getPortion() == Constants.ITEM_PORTION_LARGE) {
            cartItemPortionTextView.setText("LARGE");
        }

        switch (cartItem.getState()) {
            case Constants.CART_ITEM_STATE_NEW:
                alphaLabelTextView.setVisibility(INVISIBLE);
                break;
            case Constants.CART_ITEM_STATE_ORDERED:
                alphaLabelTextView.setText("PREPARING");
                alphaLabelTextView.setVisibility(VISIBLE);
                break;
            case Constants.CART_ITEM_STATE_READY:
                alphaLabelTextView.setText("READY");
                alphaLabelTextView.setVisibility(VISIBLE);
                break;
            case Constants.CART_ITEM_STATE_DELIVERED:
                alphaLabelTextView.setText("ENJOYING");
                alphaLabelTextView.setVisibility(VISIBLE);
                break;
        }

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
        else if (cartItem.getImageUrl().equals("img_cart_itm_016"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_016));
        else if (cartItem.getImageUrl().equals("img_cart_itm_017"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_017));
        else if (cartItem.getImageUrl().equals("img_cart_itm_018"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_018));
        else if (cartItem.getImageUrl().equals("img_cart_itm_019"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_019));
        else if (cartItem.getImageUrl().equals("img_cart_itm_020"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_020));
        else if (cartItem.getImageUrl().equals("img_cart_itm_021"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_021));
        else if (cartItem.getImageUrl().equals("img_cart_itm_022"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_022));
        else if (cartItem.getImageUrl().equals("img_cart_itm_023"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_023));
        else if (cartItem.getImageUrl().equals("img_cart_itm_024"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_024));
        else if (cartItem.getImageUrl().equals("img_cart_itm_025"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_025));
        else if (cartItem.getImageUrl().equals("img_cart_itm_026"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_026));
        else if (cartItem.getImageUrl().equals("img_cart_itm_027"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_027));
        else if (cartItem.getImageUrl().equals("img_cart_itm_028"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_028));
        else if (cartItem.getImageUrl().equals("img_cart_itm_029"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_029));
        else if (cartItem.getImageUrl().equals("img_cart_itm_030"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_030));
        else if (cartItem.getImageUrl().equals("img_cart_itm_031"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_031));
        else if (cartItem.getImageUrl().equals("img_cart_itm_032"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_032));
        else if (cartItem.getImageUrl().equals("img_cart_itm_033"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_033));
        else if (cartItem.getImageUrl().equals("img_cart_itm_034"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_034));
        else if (cartItem.getImageUrl().equals("img_cart_itm_035"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_035));
        else if (cartItem.getImageUrl().equals("img_cart_itm_036"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_036));
        else if (cartItem.getImageUrl().equals("img_cart_itm_037"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_037));
        else if (cartItem.getImageUrl().equals("img_cart_itm_038"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_038));
        else if (cartItem.getImageUrl().equals("img_cart_itm_039"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_039));
        else if (cartItem.getImageUrl().equals("img_cart_itm_040"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_040));
        else if (cartItem.getImageUrl().equals("img_cart_itm_041"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_041));
        else if (cartItem.getImageUrl().equals("img_cart_itm_042"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_042));
        else if (cartItem.getImageUrl().equals("img_cart_itm_043"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_043));
        else if (cartItem.getImageUrl().equals("img_cart_itm_044"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_044));
        else if (cartItem.getImageUrl().equals("img_cart_itm_045"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_045));
        else if (cartItem.getImageUrl().equals("img_cart_itm_046"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_046));
        else if (cartItem.getImageUrl().equals("img_cart_itm_047"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_047));
        else if (cartItem.getImageUrl().equals("img_cart_itm_048"))
            cartListItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_cart_itm_048));
        else
            cartListItemImageView.setImageDrawable(null);
    }
}
