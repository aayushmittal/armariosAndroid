package com.example.aayush.armarios;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aayush on 01/10/16.
 */
public class WardrobeGridAdapter extends ArrayAdapter<UrlData> {

    Context context;
    ArrayList<UrlData> urls;

    public WardrobeGridAdapter(Context context, ArrayList<UrlData> urls) {
        super(context,0,urls);
        this.context = context;
        this.urls = urls;


    }
    class ViewHolder{
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = View.inflate(this.context,R.layout.wardrobe_grid_layout,null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        }
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        Picasso.with(context).load(urls.get(position).getUrl()).into(viewHolder.imageView);
        return convertView;
    }
}
