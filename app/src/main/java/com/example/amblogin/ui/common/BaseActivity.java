package com.example.amblogin.ui.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.amblogin.ui.SessioManager;
import com.example.amblogin.ui.userlogin.LoginActivity;

public class BaseActivity extends AppCompatActivity {
    SessioManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = SessioManager.newInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        verifyLogin();
    }

    public void verifyLogin() {
        if (!sessionManager.isLogin()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}

