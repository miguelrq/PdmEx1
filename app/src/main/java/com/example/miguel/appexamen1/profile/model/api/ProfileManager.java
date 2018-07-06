package com.example.miguel.appexamen1.profile.model.api;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.miguel.appexamen1.profile.model.scheme.Profile;

public class ProfileManager {

    private Context mContext;
    private static ProfileManager instance = new ProfileManager();

    private ProfileManager() {}

    public static ProfileManager getInstance(Context context) {
        if(instance.mContext == null) {
            instance.mContext = context;
            AndroidNetworking.initialize(context);
        }
        return instance;
    }

    public void updateProfile(Profile profileInfo, JSONObjectRequestListener listener) {
        AndroidNetworking.patch("http://demo8075177.mockable.io/profile")
                .addBodyParameter(profileInfo)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(listener);
    }
}
