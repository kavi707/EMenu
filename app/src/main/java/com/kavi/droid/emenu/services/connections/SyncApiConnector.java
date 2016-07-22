package com.kavi.droid.emenu.services.connections;

import android.util.Log;

import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONObject;

import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by kwijewardana on 7/22/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class SyncApiConnector implements IApiConnector {

    private String requestUrl;
    private Map<String, String> getAdditionalHeaders;
    private JSONObject reqParams;
    private String httpCommonResponse  = "NULL";

    private SyncHttpClient syncHttpClient = new SyncHttpClient();

    @Override
    public String sendHttpGetRequest(String url, Map<String, String> additionalHeaders) {

        Log.d("SyncApiConnector", "SyncApiConnector:sendHttpGetRequest");
        this.requestUrl = url;
        this.getAdditionalHeaders = additionalHeaders;

        syncHttpClient.get(requestUrl, new SyncHttpResponseHandler() {
            @Override
            public void sendSuccessMessage(int statusCode, Header[] headers, byte[] responseBody) {
                super.sendSuccessMessage(statusCode, headers, responseBody);
            }

            @Override
            public void sendFailureMessage(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                super.sendFailureMessage(statusCode, headers, responseBody, error);
            }

            @Override
            public void sendRetryMessage(int retryNo) {
                super.sendRetryMessage(retryNo);
            }
        });

        return null;
    }

    @Override
    public String sendHttpDeleteRequest(String url, Map<String, String> additionalHeaders) {

        Log.d("SyncApiConnector", "SyncApiConnector:sendHttpDeleteRequest");
        this.requestUrl = url;
        this.getAdditionalHeaders = additionalHeaders;

        syncHttpClient.delete(requestUrl, new SyncHttpResponseHandler() {
            @Override
            public void sendSuccessMessage(int statusCode, Header[] headers, byte[] responseBody) {
                super.sendSuccessMessage(statusCode, headers, responseBody);
            }

            @Override
            public void sendFailureMessage(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                super.sendFailureMessage(statusCode, headers, responseBody, error);
            }

            @Override
            public void sendRetryMessage(int retryNo) {
                super.sendRetryMessage(retryNo);
            }
        });

        return null;
    }

    @Override
    public String sendHttpJsonPostRequest(String url, Map<String, String> additionalHeaders, RequestParams reqParams) {

        Log.d("SyncApiConnector", "SyncApiConnector:sendHttpJsonPostRequest");
        this.requestUrl = url;
        this.getAdditionalHeaders = additionalHeaders;

        syncHttpClient.post(requestUrl, reqParams, new SyncHttpResponseHandler() {
            @Override
            public void sendSuccessMessage(int statusCode, Header[] headers, byte[] responseBody) {
                super.sendSuccessMessage(statusCode, headers, responseBody);
            }

            @Override
            public void sendFailureMessage(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                super.sendFailureMessage(statusCode, headers, responseBody, error);
            }

            @Override
            public void sendRetryMessage(int retryNo) {
                super.sendRetryMessage(retryNo);
            }
        });

        return null;
    }

    @Override
    public String sendHttpJsonPutRequest(String url, Map<String, String> additionalHeaders, RequestParams reqParams) {

        Log.d("SyncApiConnector", "SyncApiConnector:sendHttpJsonPutRequest");
        this.requestUrl = url;
        this.getAdditionalHeaders = additionalHeaders;

        syncHttpClient.put(requestUrl, reqParams, new SyncHttpResponseHandler() {
            @Override
            public void sendSuccessMessage(int statusCode, Header[] headers, byte[] responseBody) {
                super.sendSuccessMessage(statusCode, headers, responseBody);
            }

            @Override
            public void sendFailureMessage(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                super.sendFailureMessage(statusCode, headers, responseBody, error);
            }

            @Override
            public void sendRetryMessage(int retryNo) {
                super.sendRetryMessage(retryNo);
            }
        });

        return null;
    }
}
