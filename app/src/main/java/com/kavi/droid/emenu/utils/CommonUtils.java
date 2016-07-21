package com.kavi.droid.emenu.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Display;

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
     * This is object keep all user selected results in each places.
     * This use to created final survey submission request.
     *
     * @key industry: Industry Object
     * @key selectedBrand: Brand Object
     * @key selectedChannel: Channel Object
     * @key customerJourney: Journey Object
     * @key productId: String value
     * @key effortRating: int value
     * @key sentimentRating: int value
     * @key recommendationRating: int value
     * @key satisfactionRating: int value
     * @key ratingList: ArrayList
     * @key comments: String value
     */
    public static Map<String, Object> userSurveyValues = new HashMap<>();

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
}
