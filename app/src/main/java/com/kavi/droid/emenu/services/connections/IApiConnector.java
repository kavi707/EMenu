package com.kavi.droid.emenu.services.connections;

import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by kavi707 on 7/22/16.
 *
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public interface IApiConnector {

    /**
     *
     * @param url
     * @param additionalHeaders
     * @return
     */
    String sendHttpGetRequest(String url, Map<String, String> additionalHeaders);

    /**
     *
     * @param url
     * @param additionalHeaders
     * @return
     */
    String sendHttpDeleteRequest(String url, Map<String, String> additionalHeaders);

    /**
     *
     * @param url
     * @param additionalHeaders
     * @param reqParams
     * @return
     */
    String sendHttpJsonPostRequest(String url, Map<String, String> additionalHeaders, RequestParams reqParams);

    /**
     *
     * @param url
     * @param additionalHeaders
     * @param reqParams
     * @return
     */
    String sendHttpJsonPutRequest(String url, Map<String, String> additionalHeaders, RequestParams reqParams);
}
