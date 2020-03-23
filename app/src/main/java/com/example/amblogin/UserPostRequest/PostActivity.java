package com.example.amblogin.UserPostRequest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amblogin.R;
import com.example.amblogin.service.ApiService;
import com.example.amblogin.ui.SessioManager;
import com.example.amblogin.ui.common.BaseActivity;
import com.example.amblogin.ui.response.ResponseActivity;
import com.example.amblogin.ui.response.ResponseConstant;

import androidx.appcompat.widget.Toolbar;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends BaseActivity {

    private EditText where, to;
    private Button button;
    private SessioManager sessioManager;
    private Toolbar toolbar;
    private Context context;
    private static final String TAG = "PostActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        context = getApplicationContext();

        toolbar = findViewById(R.id.post_activity_my_toolbar_id);
        setSupportActionBar(toolbar);

        where = findViewById(R.id.edit_text_pick_up_location_id);
        to = findViewById(R.id.edit_text_Where_to_go_id);
        button = findViewById(R.id.bottom_find_ambulance_id);
        button.setOnClickListener(listener);
        sessioManager = SessioManager.newInstance(getApplicationContext());
        Log.i(TAG, "fuck" + sessioManager.getUser().getToken());

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String t1 = where.getText().toString();
            String t2 = to.getText().toString();

            if (!(t1.isEmpty() && t2.isEmpty())) {
                Map<String, String> reqmodel = new HashMap<>();
                reqmodel.put("userlocation", t1);
                reqmodel.put("arealocation", t2);
                reqmodel.put("receverid", String.valueOf(sessioManager.getUser().getPk() + "1"));
                Call<AmbulanceResponseModel> call = ApiService.getMainservice().createAMBrequest("Token " + sessioManager.getUser().getToken(), reqmodel);
                call.enqueue(new Callback<AmbulanceResponseModel>() {
                    @Override
                    public void onResponse(Call<AmbulanceResponseModel> call, Response<AmbulanceResponseModel> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(PostActivity.this, "successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(PostActivity.this, ResponseActivity.class);
                            intent.putExtra(ResponseConstant.where, t1);
                            intent.putExtra(ResponseConstant.to, t2);
                            startActivity(intent);

                        }

                        if (!response.isSuccessful()) {
                            Toast.makeText(PostActivity.this, "unsuccessful", Toast.LENGTH_SHORT).show();
                            Log.i(TAG, response.message());
                            try {
                                Log.i(TAG, response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<AmbulanceResponseModel> call, Throwable t) {
                        Log.i(TAG, "failure", t);
                    }
                });

            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_log_out_id:
                logout();
                return true;
            default:
                return true;
        }
    }

    public void logout(){
        if(sessioManager.isLogin()){
            Intent restart = new Intent(context, PostActivity.class);
            int intentId = 123234;
            PendingIntent mIntent = PendingIntent.getActivity(context, intentId, restart, PendingIntent.FLAG_CANCEL_CURRENT);
            AlarmManager alrm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alrm.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mIntent);
            System.exit(0);
        }else {
            Toast.makeText(context, "Error Logout.", Toast.LENGTH_SHORT).show();
        }
    }

    public String getRigthToken(String token) {
        return String.format("%s", token);
    }
}
