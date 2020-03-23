package com.example.amblogin.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.amblogin.R;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;
import com.github.vivchar.rendererrecyclerviewadapter.ViewModel;
import com.github.vivchar.rendererrecyclerviewadapter.binder.ViewBinder;

import java.util.ArrayList;
import java.util.List;


public class exampleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        RendererRecyclerViewAdapter rendererRecyclerViewAdapter = new RendererRecyclerViewAdapter();
        rendererRecyclerViewAdapter.registerRenderer(new ViewBinder<>(R.layout.item_simple, YourViewModel.class, (model, finder, payload) -> finder.setText(R.id.text_view_composit_id, model.getTitle()).setOnClickListener(R.id.text_view_composit_id, v -> {
            Toast.makeText(this, String.format("%s", model.getTitle()), Toast.LENGTH_SHORT).show();
        })));

        rendererRecyclerViewAdapter.setItems(getItems());

        RecyclerView recyclerView = findViewById(R.id.example_main_activity_id);
        recyclerView.setAdapter(rendererRecyclerViewAdapter);
        recyclerView.addItemDecoration(new BetweenSpacesItemDecoration(10 , 10));

    }

    public List<YourViewModel> getItems(){
        List<YourViewModel> items = new ArrayList<>();
        items.add(new YourViewModel());
        items.add(new YourViewModel());
        items.add(new YourViewModel());
        items.add(new YourViewModel());
        return items;
    }

}
