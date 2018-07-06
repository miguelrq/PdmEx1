package com.example.miguel.appexamen1.news.model.api;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

public class NewsManager {

    private Context mContext;
    private static NewsManager instance = new NewsManager();

    private NewsManager() {}

    public static NewsManager getInstance(Context context) {
        if(instance.mContext == null) {
            instance.mContext = context;
            AndroidNetworking.initialize(context);
        }
        return instance;
    }

    public void loadArticle(JSONObjectRequestListener listener) {
        AndroidNetworking.get("http://demo8075177.mockable.io/news")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(listener);
    }
}
