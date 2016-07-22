package com.kavi.droid.emenu.services.connections;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by kavi707 on 7/22/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class AsyncApiConnector implements IApiConnector {

    private String requestUrl;
    private Map<String, String> getAdditionalHeaders;
    private JSONObject reqParams;
    private String httpCommonResponse  = "NULL";

    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

    @Override
    public String sendHttpGetRequest(String url, Map<String, String> additionalHeaders) {

        Log.d("AsyncApiConnector", "AsyncApiConnector:sendHttpGetRequest");
        this.requestUrl = url;
        this.getAdditionalHeaders = additionalHeaders;

        asyncHttpClient.get(requestUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        return null;
    }

    @Override
    public String sendHttpDeleteRequest(String url, Map<String, String> additionalHeaders) {

        Log.d("AsyncApiConnector", "AsyncApiConnector:sendHttpDeleteRequest");
        this.requestUrl = url;
        this.getAdditionalHeaders = additionalHeaders;

        asyncHttpClient.delete(requestUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        return null;
    }

    @Override
    public String sendHttpJsonPostRequest(String url, Map<String, String> additionalHeaders, RequestParams reqParams) {

        Log.d("AsyncApiConnector", "AsyncApiConnector:sendHttpJsonPostRequest");
        this.requestUrl = url;
        this.getAdditionalHeaders = additionalHeaders;

        asyncHttpClient.post(requestUrl, reqParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        return null;
    }

    @Override
    public String sendHttpJsonPutRequest(String url, Map<String, String> additionalHeaders, RequestParams reqParams) {

        Log.d("AsyncApiConnector", "AsyncApiConnector:sendHttpJsonPutRequest");
        this.requestUrl = url;
        this.getAdditionalHeaders = additionalHeaders;

        asyncHttpClient.put(requestUrl, reqParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        return null;
    }
}
