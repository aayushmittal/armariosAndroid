package com.example.aayush.armarios;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aayush on 01/10/16.
 */
public class MainActivityGripAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> categories;
    ArrayList<String> colors;
    public MainActivityGripAdapter(Context context, ArrayList<String> categories) {
        super(context, 0, categories);
        this.context = context;
        this.categories = categories;
        this.colors = new ArrayList<>();
        colors.add("#ff8800");
        colors.add("#00ddff");
        colors.add("#99cc00");
        colors.add("#cc0000");
        colors.add("#aa66cc");
        colors.add("#33b5e5");
        colors.add("#669900");
        colors.add("#ffbb33");
    }
    class ViewHolder{
        TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = View.inflate(this.context,R.layout.main_activity_grid_layout,null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.category);
//           viewHolder.textView.setBackgroundColor(Color.parseColor(colors.get(position)));
            convertView.setTag(viewHolder);
        }
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.textView.setText(categories.get(position));
        //viewHolder.textView.setBackgroundColor(position);
        viewHolder.textView.setBackgroundColor(Color.parseColor(colors.get(position)));

        return convertView;
    }
}







