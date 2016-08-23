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
        // TODO - Uncomment this after service integration
        //imageLoadingManager.loadImageToImageView(category.getCategoryImageUrl(), categoryImageView);
        // TODO - Remove this after service integration
        if (category.getCategoryImageUrl().equals("icon_category_toppick"))
            categoryImageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_category_toppick));
        else if (category.getCategoryImageUrl().equals("icon_category_appertizer"))
            categoryImageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_category_appertizer));
        else if (category.getCategoryImageUrl().equals("icon_category_pizza"))
            categoryImageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_category_pizza));
        else if (category.getCategoryImageUrl().equals("icon_category_rice"))
            categoryImageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_category_rice));
        else if (category.getCategoryImageUrl().equals("icon_category_noodle"))
            categoryImageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_category_noodle));
        else if (category.getCategoryImageUrl().equals("icon_category_soup"))
            categoryImageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_category_soup));
        else
            categoryImageView.setImageDrawable(null);
    }
}
