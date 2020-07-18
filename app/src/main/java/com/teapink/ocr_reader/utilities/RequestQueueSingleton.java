package com.teapink.ocr_reader.utilities;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestQueueSingleton {
    private static RequestQueueSingleton requestQueueSingleton;
    private static RequestQueue requestQueue;
    private static Context context;

    private RequestQueueSingleton(Context ctx){
        context = ctx;
        requestQueue = getRequestQueue(context);
    }

    public static synchronized  RequestQueueSingleton getInstance(Context context){
        if (requestQueueSingleton == null){
            requestQueueSingleton = new RequestQueueSingleton(context);
        }
        return requestQueueSingleton;
    }

    public static RequestQueue getRequestQueue(Context context) {
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }
}