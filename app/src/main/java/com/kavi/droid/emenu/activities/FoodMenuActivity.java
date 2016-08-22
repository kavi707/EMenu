package com.kavi.droid.emenu.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.adapters.CategoryListItemAdapter;
import com.kavi.droid.emenu.adapters.FoodGridItemAdapter;
import com.kavi.droid.emenu.adapters.FoodListItemAdapter;
import com.kavi.droid.emenu.dialogs.CartListDialog;
import com.kavi.droid.emenu.dialogs.SingleItemDialog;
import com.kavi.droid.emenu.models.Category;
import com.kavi.droid.emenu.models.FoodItem;
import com.kavi.droid.emenu.utils.CommonUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class FoodMenuActivity extends AppCompatActivity {

    private GridView foodItemGridView;
    private ListView categoryListView;
    private TextView selectedCategoryNameTextView;
    private EditText searchEditText;
    private ImageButton searchImageButton;
    private RelativeLayout checkListRelativeLayout;
    private TextView tableNumTextView;
    private TextView seatedTextView;

    private Context context = this;

    private List<Category> allCategoryList = new ArrayList<>();
    private List<Category> categoryList = new ArrayList<>();
    private List<FoodItem> allFoodItemList = new ArrayList<>();
    private List<FoodItem> foodItemList = new ArrayList<>(); // showing food items list in the grid
    private CommonUtils commonUtils = new CommonUtils();

    private FoodGridItemAdapter foodGridItemAdapter;
    private CategoryListItemAdapter categoryListItemAdapter;
    private Map<String, Integer> deviceDimensions;
    private String selectedTableNumber;
    private CountDownTimer newTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        extractIntentExtras(savedInstanceState);
        setUpViews();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (newTimer != null)
            newTimer.cancel();
    }

    private void extractIntentExtras(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                selectedTableNumber = null;
            } else {
                selectedTableNumber = extras.getString("SELECTED_TABLE_NUMBER");
            }
        }

        Log.d("BSLog","FoodMenuActivity:extractIntentExtras / selectedTableNumber: " + selectedTableNumber);
    }

    private void setUpViews() {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        categoryListView = (ListView) findViewById(R.id.categoryListView);
        foodItemGridView = (GridView) findViewById(R.id.foodItemGridView);
        selectedCategoryNameTextView = (TextView) findViewById(R.id.selectedCategoryNameTextView);
        searchEditText = (EditText) findViewById(R.id.searchEditText);
        searchImageButton = (ImageButton) findViewById(R.id.searchImageButton);
        checkListRelativeLayout = (RelativeLayout) findViewById(R.id.checkListRelativeLayout);
        tableNumTextView = (TextView) findViewById(R.id.tableNumTextView);
        seatedTextView = (TextView) findViewById(R.id.seatedTextView);

        tableNumTextView.setText("TABLE " + selectedTableNumber);
        showsCurrentTime();

        deviceDimensions = commonUtils.getDeviceWidthAndHeight(FoodMenuActivity.this);
        Log.d("Width", String.valueOf(deviceDimensions.get("width")));
        Log.d("Height", String.valueOf(deviceDimensions.get("height")));

        // Load all food categories from server and show those in list view
        loadCategoryItems();

        // Load all food items from server
        loadFoodItems();

        // Initiate first load food grid view
        initFoodItemGrid();

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
                loadFoodItemGridView(filterFoodItemList);
            }
        });

        foodItemGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingleItemDialog singleItemDialog = new SingleItemDialog(context);
                singleItemDialog.show();
                Window window = singleItemDialog.getWindow();

                Double dialogWidth = deviceDimensions.get("width") * 0.75;
                Double dialogHeight = deviceDimensions.get("height") * 0.9;

                window.setLayout(dialogWidth.intValue(), dialogHeight.intValue());
            }
        });

        checkListRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartListDialog cartListDialog = new CartListDialog(context);
                cartListDialog.show();
            }
        });
    }

    private void showsCurrentTime() {

        newTimer = new CountDownTimer(1000000000, 1000) {
            @Override
            public void onTick(long l) {
                Calendar calendar = Calendar.getInstance();
                seatedTextView.setText("SEATED " + Calendar.HOUR + ":" + calendar.get(Calendar.MINUTE));
            }

            @Override
            public void onFinish() {

            }
        };
        newTimer.start();
    }

    private void loadCategoryListView(List<Category> categoryList) {
        this.categoryList = categoryList;
        categoryListItemAdapter = new CategoryListItemAdapter(categoryList, this);
        categoryListView.setAdapter(categoryListItemAdapter);
    }

    private void loadFoodItemGridView(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
        foodGridItemAdapter = new FoodGridItemAdapter(foodItemList, context);
        foodItemGridView.setAdapter(foodGridItemAdapter);
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
        for (int j = 0; j < 16; j++) {
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

    private void initFoodItemGrid() {

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
        loadFoodItemGridView(filterFoodItemList);
    }
}
