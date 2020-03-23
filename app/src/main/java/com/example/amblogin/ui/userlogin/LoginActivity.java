package com.example.amblogin.ui.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amblogin.MainActivity;
import com.example.amblogin.R;
import com.example.amblogin.UserPostRequest.PostActivity;
import com.example.amblogin.models.UserLoginRequest;
import com.example.amblogin.models.UserLoginResposnse;
import com.example.amblogin.service.ApiService;
import com.example.amblogin.ui.SessioManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";
    EditText userName, userPassword;
    Button login;

    SessioManager sessioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessioManager = SessioManager.newInstance(this);
        userName = findViewById(R.id.username);
        userPassword = findViewById(R.id.user_password);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (validate(userName) && validate(userPassword)) {
            Log.i(TAG, "NOT NULL");

            UserLoginRequest userLoginRequest = new UserLoginRequest(userName.getText().toString(), userPassword.getText().toString());
            ApiService.getMainservice().getlogin(userLoginRequest).enqueue(new Callback<UserLoginResposnse>() {
                @Override
                public void onResponse(Call<UserLoginResposnse> call, Response<UserLoginResposnse> response) {
                    if (response.isSuccessful()) {
                        sessioManager.setUser(response.body());
                        startActivity(new Intent(LoginActivity.this, PostActivity.class));
                        finish();
                    } else {

                    }
                }

                @Override
                public void onFailure(Call<UserLoginResposnse> call, Throwable t) {
                    Log.e(TAG, "onFailure: ", t);
                }
            });

        } else {
            Log.i(TAG, "ELSE NULL");
        }

    }


    public boolean validate(EditText editText) {
        if (editText.getText().length() < 0) {
            editText.setError("please fill that field.");
            return false;
        } else {
            return true;
        }
    }
}
