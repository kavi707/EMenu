package com.kavi.droid.emenu.services.connections;

import java.util.Map;

/**
 * Created by kavi707 on 7/22/16.
 *
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public interface IApiConnector {

    /**
     * Method for sending HTTP GET requests to api
     * @param url End point url (String)
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & header value)
     * @param responseHandlerType If this is an async call then type of the response handler
     * @return Json String object
     */
    String sendHttpGetRequest(String url, Map<String, String> additionalHeaders, int responseHandlerType);

    /**
     * Method for sending HTTP DELETE requests to api
     * @param url End point url (String)
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & header value)
     * @param responseHandlerType If this is an async call then type of the response handler
     * @return Json String object
     */
    String sendHttpDeleteRequest(String url, Map<String, String> additionalHeaders, int responseHandlerType);

    /**
     * Method for sending HTTP POST requests to api
     * @param url End point url (String)
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & header value)
     * @param reqParams Request body params (Map<String, String> - header key & header value)
     * @param responseHandlerType If this is an async call then type of the response handler
     * @return Json String object
     */
    String sendHttpJsonPostRequest(String url, Map<String, String> additionalHeaders, Map<String, String> reqParams, int responseHandlerType);

    /**
     * Method for sending HTTP PUT  requests to api
     * @param url End point url (String)
     * @param additionalHeaders Request HTTP headers (Map<String, String> - header key & header value)
     * @param reqParams Request body params (Map<String, String> - header key & header value)
     * @param responseHandlerType If this is an async call then type of the response handler
     * @return Json String object
     */
    String sendHttpJsonPutRequest(String url, Map<String, String> additionalHeaders, Map<String, String> reqParams, int responseHandlerType);
}
