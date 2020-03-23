package com.example.amblogin.ui.response;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amblogin.R;
import com.example.amblogin.service.ApiService;
import com.example.amblogin.ui.SessioManager;
import com.example.amblogin.ui.response.adapter.ReponseModel;
import com.example.amblogin.ui.response.adapter.ResponseAdapter;
import com.example.amblogin.ui.response.model.DriverCommentModel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResponseActivity extends AppCompatActivity {

    private String where, to;
    private TextView textView;
    private RecyclerView recyclerView;
    private Button button;
    private ResponseAdapter adapter;
    private SessioManager sessioManager;
    private ProgressBar progressBar;
    private Handler mHandler;

    private static final String TAG = "ResponseActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        Intent intent = getIntent();
        where = intent.getStringExtra(ResponseConstant.where);
        to = intent.getStringExtra(ResponseConstant.to);

        progressBar = findViewById(R.id.determinateBar);

        textView = findViewById(R.id.request_text_view_id);
        recyclerView = findViewById(R.id.request_recycler_view_id);
        button = findViewById(R.id.request_button_id);
        button.setOnClickListener(listener);

        textView.append("From "+ where);
        textView.append("\n");
        textView.append("To " + to);


        mHandler = new Handler();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ResponseAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);

        sessioManager = SessioManager.newInstance(getApplicationContext());

    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            progressBar.setVisibility(View.VISIBLE);
            Call<List<DriverCommentModel>> drivers = ApiService.getMainservice().getDrivers(sessioManager.getUser().getToken(), String.valueOf(sessioManager.getUser().getPk()));
            drivers.enqueue(new Callback<List<DriverCommentModel>>() {
                @Override
                public void onResponse(Call<List<DriverCommentModel>> call, Response<List<DriverCommentModel>> response) {
                    progressBar.setProgress(100);
                    mHandler.postDelayed(() -> {progressBar.setVisibility(View.GONE);}, 250);

                    if(response.isSuccessful()){
                        if(!response.body().isEmpty()){
                            Log.i(TAG, "successful and not empty");
                            ArrayList<ReponseModel> models = new ArrayList<>();
                            for(DriverCommentModel m : response.body()){
                                models.add(new ReponseModel(m.getSenderid(), m.getMessage()));
                            }
                            adapter.setData(models);
                        }else{
                            Log.i(TAG, "successful but empty");
                        }
                    }

                    if(!response.isSuccessful()){
                        Log.i(TAG, "not successful");
                    }
                }

                @Override
                public void onFailure(Call<List<DriverCommentModel>> call, Throwable t) {
                    mHandler.postDelayed(() -> {progressBar.setVisibility(View.GONE);}, 250);
                    Log.i(TAG, "error", t);
                }
            });
        }
    };


}
