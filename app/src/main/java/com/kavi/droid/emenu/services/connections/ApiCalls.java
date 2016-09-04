package com.kavi.droid.emenu.services.connections;

import com.kavi.droid.emenu.Constants;
import com.loopj.android.http.RequestParams;

/**
 * Created by kavi707 on 9/3/16.
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

        RequestParams requestParams = new RequestParams();
        requestParams.add("username", username);
        requestParams.add("password", password);
        requestParams.add("grant_type", "password");

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

        RequestParams requestParams = new RequestParams();
        requestParams.put("Status", tableStatus);

        String url = Constants.BASE_URL + Constants.UPDATE_TABLE_STATUS_URL +
                tableUUID + "?access_token=" + accessToken;

        if (taskMethod.equals(Constants.ASYNC_METHOD)) {
            apiConnector = new AsyncApiConnector();
            response = apiConnector.sendHttpJsonPutRequest(url, null, requestParams, Constants.UPDATE_TABLE_STATUS);
        } else if (taskMethod.equals(Constants.SYNC_METHOD)) {
            apiConnector = new SyncApiConnector();
            response = apiConnector.sendHttpJsonPutRequest(url, null, requestParams, Constants.UPDATE_TABLE_STATUS);
        }

        return response;
    }
}
