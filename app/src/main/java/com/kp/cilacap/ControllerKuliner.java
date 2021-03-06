package com.kp.cilacap;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

public class ControllerKuliner extends Application {
    private static final String TAG = Application.class.getSimpleName();
    private static ControllerKuliner instance;
    RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized ControllerKuliner getInstance() {
        return instance;
    }

    private RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public  <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public void cancelAllRequest(Object req) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(req);
        }
    }

    public void addToRequestQueue(JsonArrayRequest arrayRequest) {
    }
}
