package com.kavi.droid.emenu.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.adapters.CategoryListItemAdapter;
import com.kavi.droid.emenu.adapters.FoodListItemAdapter;
import com.kavi.droid.emenu.models.Category;
import com.kavi.droid.emenu.models.FoodItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kavi707 on 7/28/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class MenuActivity extends Activity {

    private ListView foodItemListView;
    private ListView categoryListView;
    private ListView checkoutItemListView;

    private Context context = this;

    private List<Category> categoryList = new ArrayList<>();
    private CategoryListItemAdapter categoryListItemAdapter;

    private List<FoodItem> foodItemList = new ArrayList<>();
    private FoodListItemAdapter foodListItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setUpViews();
    }

    private void setUpViews() {

        categoryListView = (ListView) findViewById(R.id.categoryListView);
        foodItemListView = (ListView) findViewById(R.id.foodItemListView);

        // TODO - Replace with server values
        Category sampleCategory;
        for (int i = 0; i < 3; i++) {
            sampleCategory = new Category();
            sampleCategory.setId("cat00" + i);
            sampleCategory.setCategoryName("Category " + i);

            categoryList.add(sampleCategory);
        }
        categoryListItemAdapter = new CategoryListItemAdapter(categoryList, this);
        categoryListView.setAdapter(categoryListItemAdapter);

        // TODO - Replace with server values
        FoodItem sampleFoodItem;
        for (int j = 0; j < 6; j++) {
            sampleFoodItem = new FoodItem();
            sampleFoodItem.setId("food00" + j);
            sampleFoodItem.setName("Food " + j);
            if (j < 3)
                sampleFoodItem.setCategoryId("cat001");
            else
                sampleFoodItem.setCategoryId("cat002");
            sampleFoodItem.setPrice(1500);
            if (j < 5)
                sampleFoodItem.setRating(j);
            else
                sampleFoodItem.setRating(j - 5);

            foodItemList.add(sampleFoodItem);
        }
        foodListItemAdapter = new FoodListItemAdapter(foodItemList, context);
        foodItemListView.setAdapter(foodListItemAdapter);
    }
}
