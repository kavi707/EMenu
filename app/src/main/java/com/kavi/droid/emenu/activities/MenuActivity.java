package com.kavi.droid.emenu.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

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
    private TextView selectedCategoryNameTextView;
    private EditText searchEditText;
    private ImageButton searchImageButton;

    private Context context = this;

    private List<Category> allCategoryList = new ArrayList<>();
    private List<Category> categoryList = new ArrayList<>();
    private CategoryListItemAdapter categoryListItemAdapter;

    private List<FoodItem> allFoodItemList = new ArrayList<>();
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
        selectedCategoryNameTextView = (TextView) findViewById(R.id.selectedCategoryNameTextView);
        searchEditText = (EditText) findViewById(R.id.searchEditText);
        searchImageButton = (ImageButton) findViewById(R.id.searchImageButton);

        loadCategoryItems();
        loadFoodItems();
        initFoodItemList();

        categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CategoryListItemAdapter.selectedItemPosition = position;
                categoryListItemAdapter.notifyDataSetChanged();

                Category selectedCat = categoryList.get(position);

                selectedCategoryNameTextView.setText(selectedCat.getCategoryName());

                List<FoodItem> filterFoodItemList = new ArrayList<>();
                for (FoodItem foodItem: allFoodItemList) {
                    if (foodItem.getCategoryId().equals(selectedCat.getId())) {
                        filterFoodItemList.add(foodItem);
                    }
                }
                loadFoodItemListView(filterFoodItemList);
            }
        });
    }

    private void loadCategoryListView(List<Category> categoryList) {
        this.categoryList = categoryList;
        categoryListItemAdapter = new CategoryListItemAdapter(categoryList, this);
        categoryListView.setAdapter(categoryListItemAdapter);
    }

    private void loadFoodItemListView(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
        foodListItemAdapter = new FoodListItemAdapter(foodItemList, context);
        foodItemListView.setAdapter(foodListItemAdapter);
    }

    private void loadCategoryItems() {

        // TODO - Replace with server values
        Category sampleCategory;
        for (int i = 0; i < 3; i++) {
            sampleCategory = new Category();
            sampleCategory.setId("cat00" + i);
            sampleCategory.setCategoryName("Category " + i);

            allCategoryList.add(sampleCategory);
        }
        loadCategoryListView(allCategoryList);
    }

    private void loadFoodItems() {
        // TODO - Replace with server values
        FoodItem sampleFoodItem;
        for (int j = 0; j < 8; j++) {
            sampleFoodItem = new FoodItem();
            sampleFoodItem.setId("food00" + j);
            sampleFoodItem.setName("Food " + j);
            if (j < 3)
                sampleFoodItem.setCategoryId("cat000");
            else if (j >= 3 && j < 5)
                sampleFoodItem.setCategoryId("cat001");
            else
                sampleFoodItem.setCategoryId("cat002");

            sampleFoodItem.setPrice(1500);
            if (j < 5)
                sampleFoodItem.setRating(j);
            else
                sampleFoodItem.setRating(j - 5);

            allFoodItemList.add(sampleFoodItem);
        }
    }

    private void initFoodItemList() {

        CategoryListItemAdapter.selectedItemPosition = 0;
        categoryListItemAdapter.notifyDataSetChanged();

        Category selectedCat = allCategoryList.get(0);

        selectedCategoryNameTextView.setText(selectedCat.getCategoryName());

        List<FoodItem> filterFoodItemList = new ArrayList<>();
        for (FoodItem foodItem: allFoodItemList) {
            if (foodItem.getCategoryId().equals(selectedCat.getId())) {
                filterFoodItemList.add(foodItem);
            }
        }
        loadFoodItemListView(filterFoodItemList);
    }
}
