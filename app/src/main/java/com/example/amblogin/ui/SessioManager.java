package com.example.amblogin.ui;

import android.content.Context;
import android.text.TextUtils;

import com.example.amblogin.models.UserLoginResposnse;

import java.time.Instant;

public class SessioManager {

        Context context;
        SharePref sessionPref;

        public SessioManager(Context context) {
            this.context = context;
            sessionPref = SharePref.getInstance(context);
        }

        public static SessioManager newInstance(Context context) {
            return new SessioManager(context);
        }

        public boolean isLogin() {
            return !TextUtils.isEmpty(sessionPref.getToken());
        }

        public boolean logout() {
            return sessionPref.clear();
        }

        public void setUser(UserLoginResposnse user) {
            sessionPref.setUser(user);
        }

        public UserLoginResposnse getUser() {
            return sessionPref.getUser();
        }

    }



