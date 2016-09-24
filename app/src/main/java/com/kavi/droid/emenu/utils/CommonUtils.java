package com.kavi.droid.emenu.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Display;

import com.kavi.droid.emenu.models.CartItem;
import com.kavi.droid.emenu.models.Category;
import com.kavi.droid.emenu.models.FoodItem;
import com.kavi.droid.emenu.models.Price;
import com.kavi.droid.emenu.models.SubCategory;
import com.kavi.droid.emenu.models.Table;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kavi707 on 6/11/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class CommonUtils {

    /**
     * Selected food item list added to cart
     */
    public static List<CartItem> selectedCartItemList = new ArrayList<>();

    /**
     * Selected table
     */
    public static Table selectedTable;

    /**
     * check the internet connection in the device for running application
     * @param context
     * @return boolean
     */
    public boolean isOnline(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        }

        return false;
    }

    /**
     * return the device screen width and height
     * @param activity
     * @return
     */
    public Map<String, Integer> getDeviceWidthAndHeight(Activity activity) {
        Map<String, Integer> deviceWidthHeight = new HashMap<String, Integer>();

        Display mDisplay = activity.getWindowManager().getDefaultDisplay();
        int width  = mDisplay.getWidth();
        int height = mDisplay.getHeight();

        deviceWidthHeight.put("width", width);
        deviceWidthHeight.put("height", height);

        Log.d("Device width : ", String.valueOf(width));
        Log.d("Device height : ", String.valueOf(height));

        return deviceWidthHeight;
    }

    /**
     * Calculate food amount total
     * @return double value
     */
    public double getItemTotalAmt() {

        double totalAmt = 0;
        if (selectedCartItemList != null) {
            for(CartItem cartItem: selectedCartItemList) {
                totalAmt = totalAmt + cartItem.getAmount();
            }
        }

        return totalAmt;
    }

    /**
     * Generate Category object from given json string
     * @param jsonString Json string
     * @return Category Object
     */
    public Category getCategoryFromJsonString(String jsonString) {

        Category category = null;

        if (jsonString != null) {
            try {
                JSONObject categoryJsonObj = new JSONObject(jsonString);

                category = new Category();
                category.setId(categoryJsonObj.getString("CategoryId"));
                category.setCategoryName(categoryJsonObj.getString("CategoryName"));
                category.setCategoryImageUrl(categoryJsonObj.getString("iconUrl"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return category;
    }

    /**
     * Generate SubCategory object from given json string
     * @param jsonString Json string
     * @return SubCategory Object
     */
    public SubCategory getSubCategoryFromJsonString(String jsonString) {

        SubCategory subCategory = null;
        if (jsonString != null && !jsonString.equals("null")) {
            try {
                JSONObject subCategoryJsonObj = new JSONObject(jsonString);

                subCategory = new SubCategory();
                subCategory.setId(subCategoryJsonObj.getString("SubCategoryId"));
                subCategory.setSubCategoryName(subCategoryJsonObj.getString("SubCatName"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return subCategory;
    }

    /**
     * Generate FoodItem Object from given json string
     * @param jsonString Json string
     * @return FoodItem Object
     */
    public FoodItem getFoodItemFromJsonString(String jsonString) {

        FoodItem sampleFoodItem = null;
        if (jsonString != null) {
            try {
                JSONObject jsonData = new JSONObject(jsonString);

                sampleFoodItem = new FoodItem();
                sampleFoodItem.setId(jsonData.getString("ItemCode"));
                sampleFoodItem.setName(jsonData.getString("ItemName"));
                sampleFoodItem.setDescription(jsonData.getString("Description"));

                sampleFoodItem.setCategoryId(jsonData.getString("MainCategoryId"));
                String categoryJsonString = jsonData.getString("MainCategory");
                sampleFoodItem.setCategory(getCategoryFromJsonString(categoryJsonString));

                sampleFoodItem.setSubCategoryId(jsonData.getString("SubcategoryId"));
                String subCategoryJsonString = jsonData.getString("Subcategory");
                sampleFoodItem.setSubCategory(getSubCategoryFromJsonString(subCategoryJsonString));

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
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return sampleFoodItem;
    }
}
