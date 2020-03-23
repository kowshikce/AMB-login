package com.example.amblogin.example;

import com.github.vivchar.rendererrecyclerviewadapter.ViewModel;

public class YourViewModel implements ViewModel{

    public String getTitle(){
        return String.format("%s %s", "fuck", "you");
    }
}
