package com.example.amblogin.ui;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.amblogin.constant.Constant;
import com.example.amblogin.models.UserLoginRequest;
import com.example.amblogin.models.UserLoginResposnse;


public class SharePref {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharePref(Context context) {
        sharedPreferences = context.getSharedPreferences("session", context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharePref getInstance(Context context) {
        return new SharePref(context);
    }

    public void setUser(UserLoginResposnse user) {
        editor.putInt("userPK", user.getPk());
        editor.putString(Constant.EXTRA_EMAIL, user.getEmail());
        editor.putString(Constant.EXTRA_TOKEN, user.getToken());
        editor.commit();
    }

    public UserLoginResposnse getUser() {
        UserLoginResposnse user = new UserLoginResposnse();
        user.setPk(getId());
        user.setToken(getToken());
        user.setEmail(getUserEmail());
        return user;
    }

    public int getId() {
        return sharedPreferences.getInt("userPK", 1);
    }

    public String getUserEmail() {
        return sharedPreferences.getString(Constant.EXTRA_EMAIL, "");
    }

    public void setToken(String token) {
        editor.putString(Constant.EXTRA_TOKEN, token);
        editor.apply();
    }

    public String getToken() {
        return sharedPreferences.getString(Constant.EXTRA_TOKEN, "e44810385e471be16bbc43e99ac3c8736f394cc9");
    }

    public boolean clear() {
        editor.clear();
        return editor.commit();
    }
}