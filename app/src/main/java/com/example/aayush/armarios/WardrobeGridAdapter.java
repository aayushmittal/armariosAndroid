package com.example.aayush.armarios;

import android.content.Context;
import android.widget.ArrayAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by aayush on 01/10/16.
 */
public class WardrobeGridAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<String> urls;

    public WardrobeGridAdapter(Context context, ArrayList<String> urls) {
        super(context,0,urls);
        this.context = context;
        this.urls = urls;


    }
}
