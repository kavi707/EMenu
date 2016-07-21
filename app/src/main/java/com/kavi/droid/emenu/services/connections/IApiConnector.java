package com.kavi.droid.emenu.services.connections;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by kavi707 on 6/11/16.
 *
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public interface IApiConnector {

    String sendHttpGetOrDeleteRequest(String url, String requestMethod, Map<String, String> additionalHeaders);

    String sendHttpJsonPostOrPutRequest(String url, String requestMethod, Map<String, String> additionalHeaders, JSONObject reqParams);
}
