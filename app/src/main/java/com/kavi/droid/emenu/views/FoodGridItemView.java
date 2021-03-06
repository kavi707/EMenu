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

    private RelativeLayout gridItemRelativeLayout;
    private ImageView foodItemImageView;
    private ImageView selectedRightImageView;
    private TextView foodNameTextView;
    private TextView priceTextView;
    private RatingBar itemPurpleRatingBar;
    private RatingBar itemWhiteRatingBar;
    private TextView separatorTextView;

    private FoodItem foodItem;
    private ImageLoadingManager imageLoadingManager = new ImageLoadingManager();

    public FoodGridItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        gridItemRelativeLayout = (RelativeLayout) findViewById(R.id.gridItemRelativeLayout);
        foodItemImageView = (ImageView) findViewById(R.id.foodItemImageView);
        selectedRightImageView = (ImageView) findViewById(R.id.selectedRightImageView);
        foodNameTextView = (TextView) findViewById(R.id.itemNameTextView);
        itemPurpleRatingBar = (RatingBar) findViewById(R.id.itemPurpleRatingBar);
        itemWhiteRatingBar = (RatingBar) findViewById(R.id.itemWhiteRatingBar);
        priceTextView = (TextView) findViewById(R.id.itemPriceTextView);
        separatorTextView = (TextView) findViewById(R.id.separatorTextView);
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;

        foodNameTextView.setText(foodItem.getName());
        priceTextView.setText("Rs. " + (int)foodItem.getItemPrices().getSmallPrice());
        itemPurpleRatingBar.setRating(foodItem.getRating());
        itemWhiteRatingBar.setRating(foodItem.getRating());

        if (isSelectedItem()) {
            changeView(true);
        } else {
            changeView(false);
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
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_036"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_036));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_037"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_037));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_038"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_038));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_039"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_039));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_040"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_040));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_041"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_041));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_042"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_042));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_043"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_043));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_044"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_044));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_045"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_045));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_046"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_046));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_047"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_047));
        else if (foodItem.getThumbImgUrlOne().equals("img_itm_048"))
            foodItemImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_itm_048));
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

    private void changeView(boolean isSelected) {

        if (isSelected) {
            selectedRightImageView.setVisibility(VISIBLE);
            gridItemRelativeLayout.setBackgroundColor(getResources().getColor(R.color.lighterPurple));
            foodNameTextView.setTextColor(getResources().getColor(R.color.white));
            priceTextView.setTextColor(getResources().getColor(R.color.white));
            separatorTextView.setBackgroundColor(getResources().getColor(R.color.white));
            itemPurpleRatingBar.setVisibility(INVISIBLE);
            itemWhiteRatingBar.setVisibility(VISIBLE);
        } else {
            selectedRightImageView.setVisibility(INVISIBLE);
            gridItemRelativeLayout.setBackgroundColor(getResources().getColor(R.color.white));
            foodNameTextView.setTextColor(getResources().getColor(R.color.colorDarkGrey));
            priceTextView.setTextColor(getResources().getColor(R.color.lightOrange));
            separatorTextView.setBackgroundColor(getResources().getColor(R.color.colorGrey));
            itemPurpleRatingBar.setVisibility(VISIBLE);
            itemWhiteRatingBar.setVisibility(INVISIBLE);
        }
    }
}
