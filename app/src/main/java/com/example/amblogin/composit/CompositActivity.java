package com.example.amblogin.composit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.amblogin.R;
import com.example.amblogin.example.BetweenSpacesItemDecoration;
import com.example.amblogin.example.YourViewModel;
import com.github.vivchar.rendererrecyclerviewadapter.CompositeViewModel;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;
import com.github.vivchar.rendererrecyclerviewadapter.ViewModel;
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer;
import com.github.vivchar.rendererrecyclerviewadapter.binder.CompositeViewBinder;
import com.github.vivchar.rendererrecyclerviewadapter.binder.ViewBinder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CompositActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composit);

        final RendererRecyclerViewAdapter adapter = new RendererRecyclerViewAdapter();

        adapter.registerRenderer(new CompositeViewBinder<>(R.layout.item_simple_composit, R.id.item_simple_composit_recycler_id, DefaultCompositViewModel.class,
                Collections.singletonList(new BetweenSpacesItemDecoration(10, 10))).registerRenderer(getAnyViewRenderer()));


        adapter.registerRenderer(new ViewBinder<>(R.layout.item_simple, YourViewModel.class, (model, finder, payload) -> finder.setText(R.id.text_view_composit_id, model.getTitle()).setOnClickListener(R.id.text_view_composit_id, v -> {
            Toast.makeText(this, String.format("%s", model.getTitle()), Toast.LENGTH_SHORT).show();
        })));


        adapter.setItems(getData());


        final RecyclerView recyclerView = findViewById(R.id.composit_activity_recycler_id);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new BetweenSpacesItemDecoration(10, 10));

    }

    @SuppressWarnings("deprecation")
    private ViewRenderer getAnyViewRenderer(){
        return new ViewBinder<>(R.layout.item_simple_square, DiffViewModel.class, (model, finder, payloads) -> {finder.setText(R.id.text_square_id, model.getmText());});
    }

    private List<DefaultCompositViewModel> getParentItems(){
        ArrayList<DefaultCompositViewModel> parents = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            ArrayList<DiffViewModel> child = new ArrayList<>();
            for(int j = 0; j < 6; j++){
                child.add(new DiffViewModel(j, String.format("%s %d", "kowshik", j)));
            }
            parents.add(new DefaultCompositViewModel(child));
        }
        return parents;
    }

    public List<ViewModel> getData(){
        ArrayList<ViewModel> data = new ArrayList<>();
        data.addAll(getParentItems());
        data.addAll(getItems());
        return data;
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
