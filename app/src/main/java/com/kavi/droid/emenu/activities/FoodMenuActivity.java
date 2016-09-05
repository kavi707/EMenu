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
import android.widget.Toast;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.adapters.CategoryListItemAdapter;
import com.kavi.droid.emenu.adapters.FoodGridItemAdapter;
import com.kavi.droid.emenu.dialogs.CartListDialog;
import com.kavi.droid.emenu.dialogs.SingleItemDialog;
import com.kavi.droid.emenu.models.Category;
import com.kavi.droid.emenu.models.FoodItem;
import com.kavi.droid.emenu.models.Price;
import com.kavi.droid.emenu.utils.CommonUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
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
    private RelativeLayout greenRelativeLayout;
    private RelativeLayout redRelativeLayout;
    private TextView tableNumTextView;
    private TextView seatedTextView;
    private TextView orderAmtTextView;

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
        greenRelativeLayout = (RelativeLayout) findViewById(R.id.greenRelativeLayout);
        redRelativeLayout = (RelativeLayout) findViewById(R.id.redRelativeLayout);
        tableNumTextView = (TextView) findViewById(R.id.tableNumTextView);
        seatedTextView = (TextView) findViewById(R.id.seatedTextView);
        orderAmtTextView = (TextView) findViewById(R.id.orderAmtTextView);

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
                singleItemDialog.setFoodItem(foodItemList.get(position));
                singleItemDialog.setSingleItemDialogResult(new SingleItemDialog.OnSingleItemDialogResult() {
                    @Override
                    public void addItemToCart(boolean isItemAddedToCart) {
                        if (isItemAddedToCart)
                            orderAmtTextView.setText("NET TOTAL Rs. " + (int) commonUtils.getItemTotalAmt());
                    }
                });
                singleItemDialog.show();
                Window window = singleItemDialog.getWindow();

                Double dialogWidth = deviceDimensions.get("width") * 0.7;
                Double dialogHeight = deviceDimensions.get("height") * 0.9;

                window.setLayout(dialogWidth.intValue(), dialogHeight.intValue());
            }
        });

        greenRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartListDialog cartListDialog = new CartListDialog(context);
                cartListDialog.show();
            }
        });

        redRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Calling to waiter", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showsCurrentTime() {

        newTimer = new CountDownTimer(1000000000, 1000) {
            @Override
            public void onTick(long l) {
                Calendar calendar = Calendar.getInstance();
                seatedTextView.setText("SEATED " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE));
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
        String jsonString = loadJsonStringFromAssets("category_items.json");
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonData;
            Category sampleCategory;
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonData = jsonArray.getJSONObject(i);

                sampleCategory = new Category();
                sampleCategory.setId(jsonData.getString("CategoryId"));
                sampleCategory.setCategoryName(jsonData.getString("CategoryName"));
                sampleCategory.setCategoryImageUrl(jsonData.getString("iconUrl"));

                allCategoryList.add(sampleCategory);
            }

            loadCategoryListView(allCategoryList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void loadFoodItems() {
        // TODO - Replace with server values
        String jsonString = loadJsonStringFromAssets("food_items.json");
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonData;
            FoodItem sampleFoodItem;
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonData = jsonArray.getJSONObject(i);

                sampleFoodItem = new FoodItem();
                sampleFoodItem.setId(jsonData.getString("ItemCode"));
                sampleFoodItem.setName(jsonData.getString("ItemName"));
                sampleFoodItem.setDescription(jsonData.getString("Description"));
                sampleFoodItem.setCategoryId(jsonData.getString("MainCategoryId"));
                sampleFoodItem.setImgUrl(jsonData.getString("ImageUrl"));
                sampleFoodItem.setThumbImgUrlOne(jsonData.getString("ThumbImgUrlOne"));
                sampleFoodItem.setThumbImgUrlTwo(jsonData.getString("ThumbImgUrlTwo"));

                JSONObject priceJsonObj = jsonData.getJSONObject("Price");
                Price price = new Price();
                price.setSmallPrice(priceJsonObj.getDouble("Small"));
                price.setMediumPrice(priceJsonObj.getDouble("Medium"));
                price.setLargePrice(priceJsonObj.getDouble("Large"));
                sampleFoodItem.setItemPrices(price);

                sampleFoodItem.setRating(jsonData.getInt("Rating"));

                allFoodItemList.add(sampleFoodItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
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

    /**
     * TODO - This method must remove after service integration
     * This read json file in assets and return json string
     * @param fileName json file name
     * @return JsonString
     */
    private String loadJsonStringFromAssets(String fileName) {
        String jsonString = null;

        try {
            InputStream is = getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return jsonString;
    }
}
