package com.kavi.droid.emenu.services.connections;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

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
    private String httpCommonResponse  = "NULL";

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
        final Map<String, String> headers = additionalHeaders;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, requestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers != null)
                    return headers;
                else
                    return super.getHeaders();
            }
        };

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
        final Map<String, String> headers = additionalHeaders;

        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, requestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers != null)
                    return headers;
                else
                    return super.getHeaders();
            }
        };

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
        final Map<String, String> headers = additionalHeaders;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, requestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers != null)
                    return headers;
                else
                    return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

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
        final Map<String, String> headers = additionalHeaders;

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, requestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers != null)
                    return headers;
                else
                    return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

        return null;
    }
}
