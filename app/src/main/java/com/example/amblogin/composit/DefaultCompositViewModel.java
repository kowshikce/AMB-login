package com.example.amblogin.composit;

import androidx.annotation.NonNull;

import com.github.vivchar.rendererrecyclerviewadapter.CompositeViewModel;
import com.github.vivchar.rendererrecyclerviewadapter.ViewModel;

import java.util.List;

public class DefaultCompositViewModel implements CompositeViewModel{

    protected final List<? extends ViewModel> mItems;

    public DefaultCompositViewModel(List<? extends ViewModel> mItems) {
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public List<? extends ViewModel> getItems() {
        return mItems;
    }

}
