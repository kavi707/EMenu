package com.kavi.droid.emenu.services.connections;

import android.util.Log;

import com.kavi.droid.emenu.Constants;

/**
 * Created by kavi707 on 7/28/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class ResponseHandler {

    public void apiResponseHandler(int responseHandlerType, String response) {

        switch (responseHandlerType) {
            case Constants.USER_LOGIN:
                userLoginHandler(response);
                break;
            case Constants.CREATE_USER:
                userCreateHandler(response);
                break;
            case Constants.UPDATE_USER:
                userUpdateHandler(response);
                break;
            case Constants.UPDATE_TABLE_STATUS:
                updateTableStatusHandler(response);
                break;

        }
    }

    private void userLoginHandler(String response) {
        //TODO - Handle the user login async response
    }

    private void userCreateHandler(String response) {
        //TODO - Handle the user create async response
    }

    private void userUpdateHandler(String response) {
        //TODO - Handle the user update async response
    }

    private void updateTableStatusHandler(String response) {
        //TODO - Handle the user update async response
    }
}
