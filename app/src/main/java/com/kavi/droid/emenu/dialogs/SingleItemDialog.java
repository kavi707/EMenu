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

import org.w3c.dom.Text;

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
        amountTextView.setText("Rs. " + (int)foodItem.getPrice());
        qtyTextView.setText(qty + "X");

        plusImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty = qty + 1;
                qtyTextView.setText(qty + "X");
                amountTextView.setText("Rs. " + (int)(foodItem.getPrice() * qty));
            }
        });

        minusImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qty > 1) {
                    qty = qty - 1;
                    qtyTextView.setText(qty + "X");
                    amountTextView.setText("Rs. " + (int)(foodItem.getPrice() * qty));
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
                cartItem.setName(foodItem.getName());
                cartItem.setAmount(foodItem.getPrice() * qty);
                cartItem.setImageUrl(foodItem.getThumbImgUrlTwo());
                cartItem.setPortion(itemPortion);
                cartItem.setQty(qty);

                CommonUtils.selectedCartItemList.add(cartItem);
                mSingleItemDialogResult.addItemToCart(true);
                dismiss();
            }
        });

        smallRadioLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemPortion = Constants.ITEM_PORTION_SMALL;
                smallRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected));
                mediumRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected_non));
                largeRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected_non));
            }
        });

        mediumRadioLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemPortion = Constants.ITEM_PORTION_MEDIUM;
                smallRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected_non));
                mediumRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected));
                largeRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected_non));
            }
        });

        largeRadioLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemPortion = Constants.ITEM_PORTION_LARGE;
                smallRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected_non));
                mediumRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected_non));
                largeRadioImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_tick_selected));
            }
        });
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
