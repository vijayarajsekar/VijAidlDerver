package com.vij.vijaidlservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vij.vijaidlservice.Preferences.preferences;

public class HomeScreen extends AppCompatActivity {

    private EditText mUserName, mPassword;

    private TextView mLoginStatus;

    private preferences mPreferences;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        mPreferences = new preferences(this);

        mUserName = (EditText) findViewById(R.id.editText);
        mPassword = (EditText) findViewById(R.id.editText2);

        mLoginStatus = (TextView) findViewById(R.id.textt);

        mButton = (Button) findViewById(R.id.login);

        if (mPreferences.getLogin()) {

            mUserName.setVisibility(View.GONE);
            mPassword.setVisibility(View.GONE);
            mLoginStatus.setText("AIDL Service - Login");

            mButton.setText("Logout");

            mPreferences.setLogin(true);
        } else {

            mUserName.setVisibility(View.VISIBLE);
            mPassword.setVisibility(View.VISIBLE);
            mLoginStatus.setText("AIDL Service - Logout");

            mButton.setText("Login");
            mPreferences.setLogin(false);
        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!mPreferences.getLogin()) {

                    mPreferences.setUserName(mUserName.getText().toString());
                    mPreferences.setPasswd(mPassword.getText().toString());

                    mUserName.setVisibility(View.GONE);
                    mPassword.setVisibility(View.GONE);
                    mLoginStatus.setText("AIDL Service - Login");

                    mButton.setText("Logout");

                    mPreferences.setLogin(true);


                } else {

                    mPreferences.setUserName("NIL");
                    mPreferences.setPasswd("NIL");

                    mUserName.setVisibility(View.VISIBLE);
                    mPassword.setVisibility(View.VISIBLE);
                    mLoginStatus.setText("AIDL Service - Logout");

                    mButton.setText("Login");
                    mPreferences.setLogin(false);

                }


            }
        });
    }
}
