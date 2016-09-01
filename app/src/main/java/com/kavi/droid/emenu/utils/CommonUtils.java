package com.kavi.droid.emenu.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Display;

import com.kavi.droid.emenu.models.CartItem;
import com.kavi.droid.emenu.models.FoodItem;

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
}
