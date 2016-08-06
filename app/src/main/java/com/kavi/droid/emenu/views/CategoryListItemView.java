package com.kavi.droid.emenu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.models.Category;
import com.kavi.droid.emenu.services.imageLoader.ImageLoadingManager;

/**
 * Created by kavi707 on 8/6/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class CategoryListItemView extends RelativeLayout {

    private ImageView categoryImageView;
    private TextView categoryNameTextView;

    private Category category;
    private ImageLoadingManager imageLoadingManager = new ImageLoadingManager();

    public CategoryListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        categoryImageView = (ImageView) findViewById(R.id.categoryImageView);
        categoryNameTextView = (TextView) findViewById(R.id.categoryNameTextView);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;

        categoryNameTextView.setText(category.getCategoryName());
        imageLoadingManager.loadImageToImageView(category.getCategoryImageUrl(), categoryImageView);
    }
}
