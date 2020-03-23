package com.example.amblogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amblogin.models.SignupResp;
import com.example.amblogin.service.ApiService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    TextView textView;
    EditText username, userEmail, userPhone, userYear, userMonth, userDay, userPassword, userConfirmPassword;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        textView = findViewById(R.id.back);

        signup = findViewById(R.id.ac_sign_up_button_id);

        username = findViewById(R.id.ac_sign_up_name_id);
        userEmail = findViewById(R.id.ac_sign_up_email_id);
        userPhone = findViewById(R.id.ac_sign_up_number_id);
        userYear = findViewById(R.id.ac_sign_up_year_id);
        userMonth = findViewById(R.id.ac_sign_up_month_id);
        userDay = findViewById(R.id.ac_sign_up_day_id);
        userPassword = findViewById(R.id.ac_sign_up_password_id);
        userConfirmPassword = findViewById(R.id.acsign_up_confirm_password_id);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.super.onBackPressed();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTrue(username.getText().toString(), userEmail.getText().toString(), String.format("%s-%s-%s", userYear.getText().toString(), userMonth.getText().toString(),
                        userDay.getText().toString()), userPhone.getText().toString(), userPassword.getText().toString(), userConfirmPassword.getText().toString()))
                {

                }
                else {
                    Toast.makeText(Main2Activity.this, "SIGN IN ERROR. NULL EXCEPTION.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isTrue(String name, String email, String dob, String phone, String password, String confirmPassword){
        if(name.isEmpty()){
            username.setError("Name Can not be Empty.");
            return false;
        }else if(email.isEmpty()){
            userEmail.setError("Email Can Not Be Empty.");
            return false;
        }else if(dob.isEmpty()){
            userPhone.setError("Date Of Birth Can Not Be Empty.");
            return false;
        }else if(phone.isEmpty()){
            userPhone.setError("Phone Can Not Be Empty.");
            return false;
        }else if(password.isEmpty()){
            userPassword.setError("password Can Not Be Empty.");
            return false;
        }else if(confirmPassword.isEmpty()){
            userConfirmPassword.setError("Cant Not Be Empty.");
            return false;
        }else if(!password.equals(confirmPassword)){
            Toast.makeText(this, "PASSWORD DO NOT MATCH." , Toast.LENGTH_SHORT).show();
            return false;
        }else {
            Map map = new HashMap();
            map.put("email", email);
            map.put("username", name);
            map.put("mobile_number", phone);
            map.put("password", password);
            map.put("password2", confirmPassword);
            Call<SignupResp> resp = ApiService.getMainservice().getSignUp(map);
            resp.enqueue(new Callback<SignupResp>() {
                @Override
                public void onResponse(Call<SignupResp> call, Response<SignupResp> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(Main2Activity.this, "Successful.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Main2Activity.this, "UnSuccessful", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<SignupResp> call, Throwable t) {
                    Log.i("px", "error", t.getCause());
                }
            });
            return true;
        }
    }
}
