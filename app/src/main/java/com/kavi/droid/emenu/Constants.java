package com.kavi.droid.emenu;

/**
 * Created by kavi707 on 7/21/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class Constants {

    // TODO - Hardcoded username/password
    public static final String USERNAME = "kavi707";
    public static final String PASSWORD = "V1qaz2wsx@";

    public static final String ASYNC_METHOD = "ASYNC";
    public static final String SYNC_METHOD = "SYNC";

    public static final int USER_LOGIN = 101;
    public static final int CREATE_USER = 102;
    public static final int UPDATE_USER = 103;
    public static final int GET_TOKEN = 104;
    public static final int GET_TABLES = 105;
    public static final int UPDATE_TABLE_STATUS = 106;

    public static final int ITEM_PORTION_SMALL = 1;
    public static final int ITEM_PORTION_MEDIUM = 2;
    public static final int ITEM_PORTION_LARGE = 3;

    public static final int CART_ITEM_STATE_NEW = 1;
    public static final int CART_ITEM_STATE_ORDERED = 2;
    public static final int CART_ITEM_STATE_READY = 3;
    public static final int CART_ITEM_STATE_DELIVERED = 4;

    public static final int ANIMATE_STOP = 0;
    public static final int ANIMATE_START = 1;
    public static final int LIGHT_TO_DARK = 0;
    public static final int DARK_TO_LIGHT = 1;

    public static final String BASE_URL = "https://api.usergrid.com";
    public static final String GET_TOKEN_URL = "/kavi707/carrot/token";
    public static final String GET_TABLES_URL = "/kavi707/carrot/tables";
    public static final int ENTITY_LIMIT_TABLES = 50;
    public static final String UPDATE_TABLE_STATUS_URL = "/kavi707/carrot/tables/";
}
