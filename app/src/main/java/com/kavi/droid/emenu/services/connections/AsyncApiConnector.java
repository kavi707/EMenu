package com.kavi.droid.emenu.services.connections;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLServerSocketFactory;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;
import cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier;

/**
 * Created by kavi707 on 7/22/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class AsyncApiConnector implements IApiConnector {

    private String requestUrl;
    private JSONObject reqParams;
    private String httpCommonResponse  = "NULL";

    private AsyncHttpClient asyncHttpClient;

    @Override
    public String sendHttpGetRequest(String url, Map<String, String> additionalHeaders) {

        Log.d("AsyncApiConnector", "AsyncApiConnector:sendHttpGetRequest");
        this.requestUrl = url;

        asyncHttpClient = initAsyncClient(true, additionalHeaders);

        asyncHttpClient.get(requestUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                httpCommonResponse = new String(responseBody);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                httpCommonResponse = new String(responseBody);
            }
        });

        return httpCommonResponse;
    }

    @Override
    public String sendHttpDeleteRequest(String url, Map<String, String> additionalHeaders) {

        Log.d("AsyncApiConnector", "AsyncApiConnector:sendHttpDeleteRequest");
        this.requestUrl = url;

        asyncHttpClient = initAsyncClient(true, additionalHeaders);

        asyncHttpClient.delete(requestUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                httpCommonResponse = new String(responseBody);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        return httpCommonResponse;
    }

    @Override
    public String sendHttpJsonPostRequest(String url, Map<String, String> additionalHeaders, RequestParams reqParams) {

        Log.d("AsyncApiConnector", "AsyncApiConnector:sendHttpJsonPostRequest");
        this.requestUrl = url;

        asyncHttpClient = initAsyncClient(true, additionalHeaders);

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

        asyncHttpClient = initAsyncClient(true, additionalHeaders);

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


    /**
     * Create and initiate AsyncHttpClient
     * @param isAllHostAllow Boolean parameter as a flag for give access to all host names
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & heade value)
     * @return AsyncHttpClient object
     */
    private AsyncHttpClient initAsyncClient(boolean isAllHostAllow, Map<String, String> additionalHeaders) {

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        // Allow all host name
        if (isAllHostAllow) {
            HostnameVerifier hostnameVerifier = SSLSocketFactory.getSocketFactory().ALLOW_ALL_HOSTNAME_VERIFIER;
            SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
            socketFactory.setHostnameVerifier((X509HostnameVerifier) hostnameVerifier);
            asyncHttpClient.setSSLSocketFactory(socketFactory);
        }

        // Set header to client
        if (additionalHeaders != null) {
            Set<String> headerKeys = additionalHeaders.keySet();
            for (String key : headerKeys) {
                asyncHttpClient.addHeader(key,additionalHeaders.get(key));
            }
        }

        return asyncHttpClient;
    }
}
