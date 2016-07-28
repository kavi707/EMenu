package com.kavi.droid.emenu.services.connections;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONObject;

import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;
import cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier;

/**
 * Created by kwijewardana on 7/22/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class SyncApiConnector implements IApiConnector {

    private String requestUrl;
    private JSONObject reqParams;
    private String httpCommonResponse  = "NULL";

    private SyncHttpClient syncHttpClient;

    /**
     * Method for sending HTTP GET requests to api synchronously
     * @param url End point url (String)
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & header value)
     * @param responseHandlerType If this is an async call then type of the response handler
     * @return Json String object
     */
    @Override
    public String sendHttpGetRequest(String url, Map<String, String> additionalHeaders,
                                     int responseHandlerType) {

        Log.d("SyncApiConnector", "SyncApiConnector:sendHttpGetRequest");
        this.requestUrl = url;

        syncHttpClient = initSyncClient(true, additionalHeaders);

        syncHttpClient.get(url, new AsyncHttpResponseHandler() {
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

    /**
     * Method for sending HTTP DELETE requests to api synchronously
     * @param url End point url (String)
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & header value)
     * @param responseHandlerType If this is an async call then type of the response handler
     * @return Json String object
     */
    @Override
    public String sendHttpDeleteRequest(String url, Map<String, String> additionalHeaders,
                                        int responseHandlerType) {

        Log.d("SyncApiConnector", "SyncApiConnector:sendHttpDeleteRequest");
        this.requestUrl = url;

        syncHttpClient = initSyncClient(true, additionalHeaders);

        syncHttpClient.delete(requestUrl, new AsyncHttpResponseHandler() {
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

    /**
     * Method for sending HTTP POST requests to api synchronously
     * @param url End point url (String)
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & header value)
     * @param reqParams Request body params (RequestParams - header key & header value)
     * @param responseHandlerType If this is an async call then type of the response handler
     * @return Json String object
     */
    @Override
    public String sendHttpJsonPostRequest(String url, Map<String, String> additionalHeaders,
                                          RequestParams reqParams, int responseHandlerType) {

        Log.d("SyncApiConnector", "SyncApiConnector:sendHttpJsonPostRequest");
        this.requestUrl = url;

        syncHttpClient = initSyncClient(true, additionalHeaders);

        syncHttpClient.post(requestUrl, reqParams, new AsyncHttpResponseHandler() {
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
     * Method for sending HTTP PUT  requests to api synchronously
     * @param url End point url (String)
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & header value)
     * @param reqParams Request body params (RequestParams - header key & header value)
     * @param responseHandlerType If this is an async call then type of the response handler
     * @return Json String object
     */
    @Override
    public String sendHttpJsonPutRequest(String url, Map<String, String> additionalHeaders,
                                         RequestParams reqParams, int responseHandlerType) {

        Log.d("SyncApiConnector", "SyncApiConnector:sendHttpJsonPutRequest");
        this.requestUrl = url;

        syncHttpClient = initSyncClient(true, additionalHeaders);

        syncHttpClient.put(requestUrl, reqParams, new AsyncHttpResponseHandler() {
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
     * Create and initiate SyncHttpClient
     * @param isAllHostAllow Boolean parameter as a flag for give access to all host names
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & heade value)
     * @return SyncHttpClient object
     */
    private SyncHttpClient initSyncClient(boolean isAllHostAllow, Map<String, String> additionalHeaders) {

        SyncHttpClient syncHttpClient = new SyncHttpClient();

        // Allow all host name
        if (isAllHostAllow) {
            HostnameVerifier hostnameVerifier = SSLSocketFactory.getSocketFactory().ALLOW_ALL_HOSTNAME_VERIFIER;
            SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
            socketFactory.setHostnameVerifier((X509HostnameVerifier) hostnameVerifier);
            syncHttpClient.setSSLSocketFactory(socketFactory);
        }

        // Set header to client
        if (additionalHeaders != null) {
            Set<String> headerKeys = additionalHeaders.keySet();
            for (String key : headerKeys) {
                syncHttpClient.addHeader(key,additionalHeaders.get(key));
            }
        }

        return syncHttpClient;
    }
}
