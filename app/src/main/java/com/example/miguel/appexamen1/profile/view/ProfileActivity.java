package com.example.miguel.appexamen1.profile.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.miguel.appexamen1.R;
import com.example.miguel.appexamen1.profile.model.scheme.Profile;
import com.example.miguel.appexamen1.profile.presenter.IProfilePresenter;
import com.example.miguel.appexamen1.profile.presenter.ProfilePresenter;

public class ProfileActivity extends AppCompatActivity implements IProfile{

    IProfilePresenter profilePresenter;

    private EditText name;
    private EditText mail;
    private EditText phone;
    private EditText role;
    private EditText university;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.text_edit_name);
        mail = findViewById(R.id.text_edit_email);
        phone = findViewById(R.id.text_edit_phone);
        role = findViewById(R.id.text_edit_career);
        university = findViewById(R.id.text_edit_university);
        profilePresenter = new ProfilePresenter(this);

    }

    public void save(View view) {
        Profile profile = new Profile();
        profile.setMail(mail.getText().toString());
        profile.setPhone(phone.getText().toString());
        profile.setRole(role.getText().toString());
        profile.setUniversity(university.getText().toString());
        profilePresenter.saveProfile(profile);
    }

    public void toggleEdit(View view) {
        name.setEnabled(!name.isEnabled());
        mail.setEnabled(!mail.isEnabled());
        phone.setEnabled(!phone.isEnabled());
        role.setEnabled(!role.isEnabled());
        university.setEnabled(!university.isEnabled());

    }

    @Override
    public Context getProfileContext() {
        return getApplicationContext();
    }
}
