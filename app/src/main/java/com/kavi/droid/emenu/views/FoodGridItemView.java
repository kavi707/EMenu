package com.kavi.droid.emenu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.models.FoodItem;
import com.kavi.droid.emenu.services.imageLoader.ImageLoadingManager;

/**
 * Created by kavi707 on 8/15/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class FoodGridItemView extends RelativeLayout {

    private ImageView foodItemImageView;
    private TextView foodNameTextView;
    private TextView priceTextView;
    private RatingBar itemRatingBar;

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
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;

        foodNameTextView.setText(foodItem.getName());
        priceTextView.setText(String.valueOf(foodItem.getPrice()));
        itemRatingBar.setRating(foodItem.getRating());
        imageLoadingManager.loadImageToImageView(foodItem.getThumbImgUrlOne(), foodItemImageView);
    }
}
