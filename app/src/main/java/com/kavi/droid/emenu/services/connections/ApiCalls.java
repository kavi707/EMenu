package com.kavi.droid.emenu.services.connections;

import com.kavi.droid.emenu.Constants;
import com.kavi.droid.emenu.models.Table;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    /**
     * TODO - This is for demo purpose
     * Add given table as active table
     * @param taskMethod Guide the interface to select Sync or Async style
     * @param accessToken UserGrid Authentication access token
     * @param activatedTable Table object relevant to activating table
     * @return JsonString Return string json response
     */
    public String addNewActiveTable(String taskMethod, String accessToken, Table activatedTable) {

        String response = null;
        IApiConnector apiConnector;

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("TableNumber", activatedTable.getNumber());
        requestParams.put("TableId", activatedTable.getId());
        requestParams.put("Status", String.valueOf(activatedTable.getStatus()));

        String url = Constants.BASE_URL + Constants.ADD_NEW_ACTIVE_TABLE_URL +
                "?access_token=" + accessToken;

        if (taskMethod.equals(Constants.ASYNC_METHOD)) {
            apiConnector = new AsyncApiConnector();
            response = apiConnector.sendHttpJsonPostRequest(url, null, requestParams, Constants.ADD_NEW_ACTIVE_TABLE);
        } else if (taskMethod.equals(Constants.SYNC_METHOD)) {
            apiConnector = new SyncApiConnector();
            response = apiConnector.sendHttpJsonPostRequest(url, null, requestParams, Constants.ADD_NEW_ACTIVE_TABLE);
        }

        return response;
    }

    /**
     * TODO - This is for demo purpose
     * Update the given table status
     * @param taskMethod Guide the interface to select Sync or Async style
     * @param accessToken UserGrid Authentication access token
     * @param tableUUID Collection entry UUID
     * @param tableStatus Updating values for table status
     * @return JsonString Return string json response
     */
    public String updateTableStatus(String taskMethod, String accessToken, String tableUUID, int tableStatus) {

        String response = null;
        IApiConnector apiConnector;

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("Status", String.valueOf(tableStatus));

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Authorization", "Bearer " + accessToken);

        String url = Constants.BASE_URL + Constants.UPDATE_TABLE_STATUS_URL +
                tableUUID;

        if (taskMethod.equals(Constants.ASYNC_METHOD)) {
            apiConnector = new AsyncApiConnector();
            response = apiConnector.sendHttpJsonPutRequest(url, requestHeaders, requestParams, Constants.UPDATE_TABLE_STATUS);
        } else if (taskMethod.equals(Constants.SYNC_METHOD)) {
            apiConnector = new SyncApiConnector();
            response = apiConnector.sendHttpJsonPutRequest(url, requestHeaders, requestParams, Constants.UPDATE_TABLE_STATUS);
        }

        return response;
    }
}
