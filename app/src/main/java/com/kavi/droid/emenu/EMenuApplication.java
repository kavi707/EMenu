package com.kavi.droid.emenu;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by kavi707 on 9/24/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */

public class EMenuApplication extends Application {

    public static final String TAG = "EMenu";

    private RequestQueue volleyRequestQueue;

    private static EMenuApplication eMenuApplicationInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        eMenuApplicationInstance = this;
    }

    public static synchronized EMenuApplication getEMenuApplicationInstance() {
        return eMenuApplicationInstance;
    }

    public RequestQueue getVolleyRequestQueue() {
        if (volleyRequestQueue == null) {
            volleyRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return volleyRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getVolleyRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getVolleyRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (volleyRequestQueue != null) {
            volleyRequestQueue.cancelAll(tag);
        }
    }
}
