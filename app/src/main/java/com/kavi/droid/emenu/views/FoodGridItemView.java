package com.kavi.droid.emenu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.models.CartItem;
import com.kavi.droid.emenu.models.FoodItem;
import com.kavi.droid.emenu.services.imageLoader.ImageLoadingManager;
import com.kavi.droid.emenu.utils.CommonUtils;

/**
 * Created by kavi707 on 8/15/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class FoodGridItemView extends RelativeLayout {

    private ImageView foodItemImageView;
    private TextView foodNameTextView;
    private TextView priceTextView;
    private RatingBar itemRatingBar;
    private TextView selectIndicateTextView;

    private FoodItem foodItem;
    private ImageLoadingManager imageLoadingManager = new ImageLoadingManager();

    public FoodGridItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        foodItemImageView = (ImageView) findViewById(R.id.foodItemImageView);
        foodNameTextView = (TextView) findViewById(R.id.itemNameTextView);
        itemRatingBar = (RatingBar) findViewById(R.id.itemRatingBar);
        priceTextView = (TextView) findViewById(R.id.itemPriceTextView);
        selectIndicateTextView = (TextView) findViewById(R.id.selectIndicateTextView);
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;

        foodNameTextView.setText(foodItem.getName());
        priceTextView.setText("Rs. " + (int)foodItem.getItemPrices().getSmallPrice());
        itemRatingBar.setRating(foodItem.getRating());

        if (isSelectedItem()) {
            selectIndicateTextView.setVisibility(VISIBLE);
        } else {
            selectIndicateTextView.setVisibility(INVISIBLE);
        }

        // TODO - Uncomment this after service integration
        //imageLoadingManager.loadImageToImageView(foodItem.getThumbImgUrlOne(), foodItemImageView);

        // TODO - Remove this after service integration
        if (foodItem.getThumbImgUrlOne().equals("img_itm_001"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_001));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_002"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_002));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_003"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_003));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_004"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_004));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_005"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_005));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_006"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_006));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_007"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_007));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_008"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_008));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_009"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_009));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_010"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_010));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_011"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_011));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_012"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_012));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_013"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_013));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_014"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_014));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_015"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_015));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_016"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_016));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_017"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_017));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_018"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_018));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_019"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_019));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_020"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_020));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_021"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_021));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_022"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_022));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_023"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_023));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_024"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_024));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_025"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_025));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_026"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_026));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_027"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_027));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_028"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_028));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_029"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_029));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_030"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_030));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_031"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_031));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_032"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_032));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_033"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_033));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_034"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_034));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_035"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_035));
        else
            foodItemImageView.setImageDrawable(null);
    }

    /**
     * Check this item is selected Item or not
     * @return Boolean value
     */
    private boolean isSelectedItem() {
        boolean isSelectedItem = false;

        if (!CommonUtils.selectedCartItemList.isEmpty()) {
            for (CartItem cartItem : CommonUtils.selectedCartItemList) {
                if (foodItem.getId().equals(cartItem.getFoodItem().getId())) {
                    isSelectedItem = true;
                }
            }
        }
        return isSelectedItem;
    }
}
