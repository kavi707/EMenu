package com.kavi.droid.emenu.services.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kavi707 on 6/11/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class SharedPreferenceManager {

    private static final String BRANDSMACKER_SHARED_PREFERENCES = "BRANDSMACKER_SHARED_PREFERENCES";

    //Shared Preference constants
    private static final String IS_USER_LOGGED_IN = "IS_USER_LOGGED_IN";
    private static final String CURRENT_USER_EMAIL = "CURRENT_USER_EMAIL";
    private static final String CURRENT_USER_NAME = "CURRENT_USER_NAME";
    private static final String CURRENT_USER_ID = "CURRENT_USER_ID";
    private static final String CURRENT_USER_TOKEN = "CURRENT_USER_TOKEN";

    /**
     * Store boolean shared preference value
     * @param preferenceKey preference key
     * @param preferenceValue preference value
     */
    private static void writeBooleanSharePreference(Context context, String preferenceKey, boolean preferenceValue) {

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = context.getSharedPreferences(BRANDSMACKER_SHARED_PREFERENCES, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(preferenceKey, preferenceValue);

        // Commit the edits!
        editor.commit();
    }

    /**
     * Get boolean share preference value
     * @param preferenceKey preference key
     * @return boolean value
     */
    private static boolean readBooleanSharePreference(Context context, String preferenceKey) {
        SharedPreferences settings = context.getSharedPreferences(BRANDSMACKER_SHARED_PREFERENCES, 0);
        return settings.getBoolean(preferenceKey, false);
    }

    /**
     * Store String shared preference value
     * @param preferenceKey preference key
     * @param preferenceValue preference value
     */
    private static void writeStringSharePreference(Context context, String preferenceKey, String preferenceValue) {

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = context.getSharedPreferences(BRANDSMACKER_SHARED_PREFERENCES, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(preferenceKey, preferenceValue);

        // Commit the edits!
        editor.commit();
    }

    /**
     * Get String share preference value
     * @param preferenceKey preference key
     * @return String value
     */
    public static String readStringSharePreference(Context context, String preferenceKey) {
        SharedPreferences settings = context.getSharedPreferences(BRANDSMACKER_SHARED_PREFERENCES, 0);
        return settings.getString(preferenceKey, "NULL");
    }

    /**********************************************************************************************/
    /************************ Shared Preference Getters & Setters *********************************/
    /**********************************************************************************************/

    public static void setIsLogIn(Context context, boolean value){
        writeBooleanSharePreference(context, IS_USER_LOGGED_IN, value);
    }

    public static boolean isUserLogIn(Context context){
        return readBooleanSharePreference(context, IS_USER_LOGGED_IN);
    }

    public static void setCurrentUserEmail(Context context, String value){
        writeStringSharePreference(context, CURRENT_USER_EMAIL, value);
    }

    public static String getCurrentUserEmail(Context context){
        return readStringSharePreference(context, CURRENT_USER_EMAIL);
    }

    public static void setCurrentUserName(Context context, String value){
        writeStringSharePreference(context, CURRENT_USER_NAME, value);
    }

    public static String getCurrentUserName(Context context){
        return readStringSharePreference(context, CURRENT_USER_NAME);
    }

    public static void setCurrentUserId(Context context, String value){
        writeStringSharePreference(context, CURRENT_USER_ID, value);
    }

    public static String getCurrentUserId(Context context){
        return readStringSharePreference(context, CURRENT_USER_ID);
    }

    public static void setCurrentUserToken(Context context, String value){
        writeStringSharePreference(context, CURRENT_USER_TOKEN, value);
    }

    public static String getCurrentUserToken(Context context){
        return readStringSharePreference(context, CURRENT_USER_TOKEN);
    }
}
