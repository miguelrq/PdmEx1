package com.example.miguel.appexamen1.profile.presenter;

import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.miguel.appexamen1.profile.model.api.ProfileManager;
import com.example.miguel.appexamen1.profile.model.scheme.Profile;
import com.example.miguel.appexamen1.profile.view.IProfile;

import org.json.JSONObject;

public class ProfilePresenter implements IProfilePresenter{

    IProfile profileView;

    public ProfilePresenter(IProfile profileView) {this.profileView = profileView;}


    @Override
    public void saveProfile(Profile profile) {
        ProfileManager.getInstance(profileView.getProfileContext())
                .updateProfile(profile, new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
