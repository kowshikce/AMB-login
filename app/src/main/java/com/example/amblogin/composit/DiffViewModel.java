package com.example.amblogin.composit;

import com.github.vivchar.rendererrecyclerviewadapter.ViewModel;

import java.util.Objects;

public class DiffViewModel implements ViewModel {

    private final int mID;
    private final String mText;

    public DiffViewModel(int mID, String mText) {
        this.mID = mID;
        this.mText = mText;
    }

    public int getmID() {
        return mID;
    }

    public String getmText() {
        return mText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiffViewModel that = (DiffViewModel) o;
        return mID == that.mID &&
                Objects.equals(mText, that.mText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mID, mText);
    }
}
