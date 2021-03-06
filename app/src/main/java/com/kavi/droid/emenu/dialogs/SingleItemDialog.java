package com.kavi.droid.emenu.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kavi.droid.emenu.Constants;
import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.models.CartItem;
import com.kavi.droid.emenu.models.FoodItem;
import com.kavi.droid.emenu.utils.CommonUtils;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by kavi707 on 8/16/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class SingleItemDialog extends Dialog {

    private ImageButton closeImageButton;
    private ImageView singleItemImageView;
    private TextView itemNameTextView;
    private TextView itemDescriptionTextView;
    private TextView amountTextView;
    private TextView qtyTextView;
    private Button addToCartBtn;
    private ImageButton plusImageButton;
    private ImageButton minusImageButton;

    private LinearLayout smallRadioLinearLayout;
    private ImageView smallRadioImageView;
    private LinearLayout mediumRadioLinearLayout;
    private ImageView mediumRadioImageView;
    private LinearLayout largeRadioLinearLayout;
    private ImageView largeRadioImageView;

    private Context context;
    private FoodItem foodItem;
    OnSingleItemDialogResult mSingleItemDialogResult;

    private int qty = 1;
    private int itemPortion = Constants.ITEM_PORTION_SMALL;
    private boolean isSizeAvailable = false;
    private CommonUtils commonUtils = new CommonUtils();

    public SingleItemDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_single_item);

        setUpView();
    }

    // Callback Interface
    public interface OnSingleItemDialogResult {
        void addItemToCart(boolean isItemAddedToCart);
    }

    public void setSingleItemDialogResult (OnSingleItemDialogResult dialogResult) {
        mSingleItemDialogResult = dialogResult;
    }

    private void setUpView() {

        closeImageButton = (ImageButton) findViewById(R.id.closeImageButton);
        singleItemImageView = (ImageView) findViewById(R.id.singleItemImageView);
        itemNameTextView = (TextView) findViewById(R.id.itemNameTextView);
        itemDescriptionTextView = (TextView) findViewById(R.id.itemDescriptionTextView);
        amountTextView = (TextView) findViewById(R.id.amountTextView);
        qtyTextView = (TextView) findViewById(R.id.qtyTextView);
        addToCartBtn = (Button) findViewById(R.id.addToCartBtn);
        plusImageButton = (ImageButton) findViewById(R.id.plusImageButton);
        minusImageButton = (ImageButton) findViewById(R.id.minusImageButton);

        smallRadioLinearLayout = (LinearLayout) findViewById(R.id.smallRadioLinearLayout);
        mediumRadioLinearLayout = (LinearLayout) findViewById(R.id.mediumRadioLinearLayout);
        largeRadioLinearLayout = (LinearLayout) findViewById(R.id.largeRadioLinearLayout);

        smallRadioImageView = (ImageView) findViewById(R.id.smallRadioImageView);
        mediumRadioImageView = (ImageView) findViewById(R.id.mediumRadioImageView);
        largeRadioImageView = (ImageView) findViewById(R.id.largeRadioImageView);

        itemNameTextView.setText(foodItem.getName());
        itemDescriptionTextView.setText(foodItem.getDescription());
        amountTextView.setText("Rs. " + (int)foodItem.getItemPrices().getSmallPrice());
        qtyTextView.setText(qty + "X");

        if (foodItem.getItemPrices().getSmallPrice() == foodItem.getItemPrices().getMediumPrice()
                && foodItem.getItemPrices().getMediumPrice() == foodItem.getItemPrices().getLargePrice()) {
            isSizeAvailable = false;

            smallRadioLinearLayout.setVisibility(View.GONE);
            mediumRadioLinearLayout.setVisibility(View.GONE);
            largeRadioLinearLayout.setVisibility(View.GONE);
        } else {
            isSizeAvailable = true;
        }

        plusImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty = qty + 1;
                qtyTextView.setText(qty + "X");
                if (itemPortion == Constants.ITEM_PORTION_SMALL)
                    amountTextView.setText("Rs. " + (int)(foodItem.getItemPrices().getSmallPrice() * qty));
                else if (itemPortion == Constants.ITEM_PORTION_MEDIUM)
                    amountTextView.setText("Rs. " + (int)(foodItem.getItemPrices().getMediumPrice() * qty));
                else if (itemPortion == Constants.ITEM_PORTION_LARGE)
                    amountTextView.setText("Rs. " + (int)(foodItem.getItemPrices().getLargePrice() * qty));
            }
        });

        minusImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qty > 1) {
                    qty = qty - 1;
                    qtyTextView.setText(qty + "X");
                    if (itemPortion == Constants.ITEM_PORTION_SMALL)
                        amountTextView.setText("Rs. " + (int)(foodItem.getItemPrices().getSmallPrice() * qty));
                    else if (itemPortion == Constants.ITEM_PORTION_MEDIUM)
                        amountTextView.setText("Rs. " + (int)(foodItem.getItemPrices().getMediumPrice() * qty));
                    else if (itemPortion == Constants.ITEM_PORTION_LARGE)
                        amountTextView.setText("Rs. " + (int)(foodItem.getItemPrices().getLargePrice() * qty));
                } else {
                    Toast.makeText(context, "Please selecte valid quantity", Toast.LENGTH_LONG).show();
                }
            }
        });

        // TODO - Remove this after service integration
        if (foodItem.getImgUrl().equals("img_itm_full_001"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_001));
        else if (foodItem.getImgUrl().equals("img_itm_full_002"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_002));
        else if (foodItem.getImgUrl().equals("img_itm_full_003"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_003));
        else if (foodItem.getImgUrl().equals("img_itm_full_004"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_004));
        else if (foodItem.getImgUrl().equals("img_itm_full_005"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_005));
        else if (foodItem.getImgUrl().equals("img_itm_full_006"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_006));
        else if (foodItem.getImgUrl().equals("img_itm_full_007"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_007));
        else if (foodItem.getImgUrl().equals("img_itm_full_008"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_008));
        else if (foodItem.getImgUrl().equals("img_itm_full_009"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_009));
        else if (foodItem.getImgUrl().equals("img_itm_full_010"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_010));
        else if (foodItem.getImgUrl().equals("img_itm_full_011"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_011));
        else if (foodItem.getImgUrl().equals("img_itm_full_012"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_012));
        else if (foodItem.getImgUrl().equals("img_itm_full_013"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_013));
        else if (foodItem.getImgUrl().equals("img_itm_full_014"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_014));
        else if (foodItem.getImgUrl().equals("img_itm_full_015"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_015));
        else if (foodItem.getImgUrl().equals("img_itm_full_016"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_016));
        else if (foodItem.getImgUrl().equals("img_itm_full_017"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_017));
        else if (foodItem.getImgUrl().equals("img_itm_full_018"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_018));
        else if (foodItem.getImgUrl().equals("img_itm_full_019"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_019));
        else if (foodItem.getImgUrl().equals("img_itm_full_020"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_020));
        else if (foodItem.getImgUrl().equals("img_itm_full_021"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_021));
        else if (foodItem.getImgUrl().equals("img_itm_full_022"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_022));
        else if (foodItem.getImgUrl().equals("img_itm_full_023"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_023));
        else if (foodItem.getImgUrl().equals("img_itm_full_024"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_024));
        else if (foodItem.getImgUrl().equals("img_itm_full_025"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_025));
        else if (foodItem.getImgUrl().equals("img_itm_full_026"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_026));
        else if (foodItem.getImgUrl().equals("img_itm_full_027"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_027));
        else if (foodItem.getImgUrl().equals("img_itm_full_028"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_028));
        else if (foodItem.getImgUrl().equals("img_itm_full_029"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_029));
        else if (foodItem.getImgUrl().equals("img_itm_full_030"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_030));
        else if (foodItem.getImgUrl().equals("img_itm_full_031"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_031));
        else if (foodItem.getImgUrl().equals("img_itm_full_032"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_032));
        else if (foodItem.getImgUrl().equals("img_itm_full_033"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_033));
        else if (foodItem.getImgUrl().equals("img_itm_full_034"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_034));
        else if (foodItem.getImgUrl().equals("img_itm_full_035"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_035));
        else if (foodItem.getImgUrl().equals("img_itm_full_036"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_036));
        else if (foodItem.getImgUrl().equals("img_itm_full_037"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_037));
        else if (foodItem.getImgUrl().equals("img_itm_full_038"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_038));
        else if (foodItem.getImgUrl().equals("img_itm_full_039"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_039));
        else if (foodItem.getImgUrl().equals("img_itm_full_040"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_040));
        else if (foodItem.getImgUrl().equals("img_itm_full_041"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_041));
        else if (foodItem.getImgUrl().equals("img_itm_full_042"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_042));
        else if (foodItem.getImgUrl().equals("img_itm_full_043"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_043));
        else if (foodItem.getImgUrl().equals("img_itm_full_044"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_044));
        else if (foodItem.getImgUrl().equals("img_itm_full_045"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_045));
        else if (foodItem.getImgUrl().equals("img_itm_full_046"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_046));
        else if (foodItem.getImgUrl().equals("img_itm_full_047"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_047));
        else if (foodItem.getImgUrl().equals("img_itm_full_048"))
            singleItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.img_itm_full_048));
        else
            singleItemImageView.setImageDrawable(null);

        closeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSingleItemDialogResult.addItemToCart(false);
                dismiss();
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CartItem cartItem = new CartItem();
                cartItem.setTempHashId(createTempCartId());
                cartItem.setName(foodItem.getName());
                cartItem.setAmount(foodItem.getItemPrices().getSmallPrice() * qty);
                cartItem.setImageUrl(foodItem.getThumbImgUrlTwo());
                if (isSizeAvailable)
                    cartItem.setPortion(itemPortion);
                else
                    cartItem.setPortion(Constants.ITEM_PORTION_NOT_AVAILABLE);
                cartItem.setQty(qty);
                cartItem.setState(Constants.CART_ITEM_STATE_NEW);
                cartItem.setFoodItem(foodItem);

                CommonUtils.selectedCartItemList.add(cartItem);
                mSingleItemDialogResult.addItemToCart(true);
                dismiss();
            }
        });

        smallRadioLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemPortion = Constants.ITEM_PORTION_SMALL;
                amountTextView.setText("Rs. " + (int)foodItem.getItemPrices().getSmallPrice() * qty);
                smallRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected));
                mediumRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected_non));
                largeRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected_non));
            }
        });

        mediumRadioLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemPortion = Constants.ITEM_PORTION_MEDIUM;
                amountTextView.setText("Rs. " + (int)foodItem.getItemPrices().getMediumPrice() * qty);
                smallRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected_non));
                mediumRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected));
                largeRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected_non));
            }
        });

        largeRadioLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemPortion = Constants.ITEM_PORTION_LARGE;
                amountTextView.setText("Rs. " + (int)foodItem.getItemPrices().getLargePrice() * qty);
                smallRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected_non));
                mediumRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected_non));
                largeRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected));
            }
        });
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    private String createTempCartId() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }
}
