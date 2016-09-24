package com.kavi.droid.emenu.services.connections;

import com.kavi.droid.emenu.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kavi707 on 9/24/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */

public class ApiCalls {

    /**
     * TODO - This is for demo purpose
     * Retrieve access token from UserGrid
     * @param taskMethod Guide the interface to select Sync or Async style
     * @param username User's username
     * @param password User's password
     * @return JsonString Return string json response
     */
    public String getUserGridAccessToken(String taskMethod, String username, String password) {

        String response = null;
        IApiConnector apiConnector;

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("username", username);
        requestParams.put("password", password);
        requestParams.put("grant_type", "password");

        String url = Constants.BASE_URL + Constants.GET_TOKEN_URL;

        if (taskMethod.equals(Constants.ASYNC_METHOD)) {
            apiConnector = new AsyncApiConnector();
            response = apiConnector.sendHttpJsonPostRequest(url, null, requestParams, Constants.GET_TOKEN);
        } else if (taskMethod.equals(Constants.SYNC_METHOD)) {
            apiConnector = new SyncApiConnector();
            response = apiConnector.sendHttpJsonPostRequest(url, null, requestParams, Constants.GET_TOKEN);
        }

        return response;
    }

    /**
     * TODO - This is for demo purpose
     * Get defined tables in UserGrid
     * @param taskMethod Guide the interface to select Sync or Async style
     * @param accessToken UserGrid Authentication access token
     * @param entityLimit Entity count limitation
     * @return JsonString Return string json response
     */
    public String getTables(String taskMethod, String accessToken, int entityLimit) {

        String response = null;
        IApiConnector apiConnector;

        String url = Constants.BASE_URL + Constants.GET_TABLES_URL +
                "?access_token=" + accessToken + "&limit=" + entityLimit;

        if (taskMethod.equals(Constants.ASYNC_METHOD)) {
            apiConnector = new AsyncApiConnector();
            response = apiConnector.sendHttpGetRequest(url, null, Constants.GET_TABLES);
        } else if (taskMethod.equals(Constants.SYNC_METHOD)) {
            apiConnector = new SyncApiConnector();
            response = apiConnector.sendHttpGetRequest(url, null, Constants.GET_TABLES);
        }

        return response;
    }
}
