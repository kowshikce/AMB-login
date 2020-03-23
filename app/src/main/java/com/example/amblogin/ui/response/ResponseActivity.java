package com.example.amblogin.ui.response;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amblogin.R;
import com.example.amblogin.ui.response.adapter.ReponseModel;
import com.example.amblogin.ui.response.adapter.ResponseAdapter;

import java.util.ArrayList;

public class ResponseActivity extends AppCompatActivity {

    private String where, to;
    private TextView textView;
    private RecyclerView recyclerView;
    private Button button;
    private ResponseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        Intent intent = getIntent();
        where = intent.getStringExtra(ResponseConstant.where);
        to = intent.getStringExtra(ResponseConstant.to);


        textView = findViewById(R.id.request_text_view_id);
        recyclerView = findViewById(R.id.request_recycler_view_id);
        button = findViewById(R.id.request_button_id);
        button.setOnClickListener(listener);

        textView.append(where);
        textView.append("\n");
        textView.append(to);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ResponseAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);


    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            adapter.setData(new ArrayList<ReponseModel>());
        }
    };
}
