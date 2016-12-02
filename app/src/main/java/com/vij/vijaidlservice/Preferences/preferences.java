package com.vij.vijaidlservice.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by vijayaraj_s on 11/30/2016.
 */

public class preferences extends PrefConstants {

    private static final String TAG = preferences.class.getSimpleName();

    private static SharedPreferences mPreferences;

    private SharedPreferences.Editor mEditor;

    private Context mContext;

    private int PRIVATE_MODE = 0;

    public preferences(Context _ctx) {
        this.mContext = _ctx;
        mPreferences = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mPreferences.edit();
    }

    public boolean getLogin() {
        return mPreferences.getBoolean(IS_SPLASH_SCREEN, false);
    }

    public void setLogin(boolean values) {
        mEditor.putBoolean(IS_SPLASH_SCREEN, values);
        mEditor.commit();
    }

    public String getUserName() {
        return mPreferences.getString(IS_UNAME, "");
    }

    public void setUserName(String values) {
        mEditor.putString(IS_UNAME, values);
        mEditor.commit();
    }

    public String getPasswd() {
        return mPreferences.getString(IS_PASSWD, "");
    }

    public void setPasswd(String values) {
        mEditor.putString(IS_PASSWD, values);
        mEditor.commit();
    }
}