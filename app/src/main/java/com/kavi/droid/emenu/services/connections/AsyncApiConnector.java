package com.kavi.droid.emenu.services.connections;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kavi.droid.emenu.EMenuApplication;

import java.util.Map;

/**
 * Created by kavi707 on 7/22/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class AsyncApiConnector implements IApiConnector {

    private String requestUrl;
    private String httpCommonResponse  = "NULL";

    private ResponseHandler asyncResponseHandler = new ResponseHandler();

    /**
     * Method for sending HTTP GET requests to api asynchronously
     * @param url End point url (String)
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & header value)
     * @param responseHandlerType If this is an async call then type of the response handler
     * @return Json String object
     */
    @Override
    public String sendHttpGetRequest(String url, Map<String, String> additionalHeaders,
                                     final int responseHandlerType) {

        Log.d("AsyncApiConnector", "AsyncApiConnector:sendHttpGetRequest");
        this.requestUrl = url;
        final Map<String, String> headers = additionalHeaders;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, requestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                httpCommonResponse = response;
                asyncResponseHandler.apiResponseHandler(responseHandlerType, httpCommonResponse);
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

        // Adding request to request queue
        EMenuApplication.getEMenuApplicationInstance().addToRequestQueue(stringRequest);

        return httpCommonResponse;
    }

    /**
     * Method for sending HTTP DELETE requests to api asynchronously
     * @param url End point url (String)
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & header value)
     * @param responseHandlerType If this is an async call then type of the response handler
     * @return Json String object
     */
    @Override
    public String sendHttpDeleteRequest(String url, Map<String, String> additionalHeaders,
                                        final int responseHandlerType) {

        Log.d("AsyncApiConnector", "AsyncApiConnector:sendHttpDeleteRequest");
        this.requestUrl = url;
        final Map<String, String> headers = additionalHeaders;

        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, requestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                httpCommonResponse = response;
                asyncResponseHandler.apiResponseHandler(responseHandlerType, httpCommonResponse);
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

        // Adding request to request queue
        EMenuApplication.getEMenuApplicationInstance().addToRequestQueue(stringRequest);

        return httpCommonResponse;
    }

    /**
     * Method for sending HTTP POST requests to api asynchronously
     * @param url End point url (String)
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & header value)
     * @param reqParams Request body params (RequestParams - header key & header value)
     * @param responseHandlerType If this is an async call then type of the response handler
     * @return Json String object
     */
    @Override
    public String sendHttpJsonPostRequest(String url, Map<String, String> additionalHeaders,
                                          Map<String, String> reqParams, final int responseHandlerType) {

        Log.d("AsyncApiConnector", "AsyncApiConnector:sendHttpJsonPostRequest");
        this.requestUrl = url;
        final Map<String, String> headers = additionalHeaders;
        final Map<String, String> params = reqParams;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, requestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                httpCommonResponse = response;
                asyncResponseHandler.apiResponseHandler(responseHandlerType, httpCommonResponse);
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
                if (params != null)
                    return params;
                else
                    return super.getParams();
            }
        };

        // Adding request to request queue
        EMenuApplication.getEMenuApplicationInstance().addToRequestQueue(stringRequest);

        return httpCommonResponse;
    }

    /**
     * Method for sending HTTP PUT  requests to api asynchronously
     * @param url End point url (String)
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & header value)
     * @param reqParams Request body params (RequestParams - header key & header value)
     * @param responseHandlerType If this is an async call then type of the response handler
     * @return Json String object
     */
    @Override
    public String sendHttpJsonPutRequest(String url, Map<String, String> additionalHeaders,
                                         Map<String, String> reqParams, final int responseHandlerType) {

        Log.d("AsyncApiConnector", "AsyncApiConnector:sendHttpJsonPutRequest");
        this.requestUrl = url;
        final Map<String, String> headers = additionalHeaders;
        final Map<String, String> params = reqParams;

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
                if (params != null)
                    return params;
                else
                    return super.getParams();
            }
        };

        return null;
    }
}
