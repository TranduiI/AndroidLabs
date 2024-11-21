package com.example.laba11.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.laba11.R;

public class ColorsAdapter extends BaseAdapter{
    private String[] names;
    private int[] colors;


    public ColorsAdapter( String[] names, int[] colors){
        this.names = names;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public String getItem(int pos) {
        return names[pos];
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }
    public int getColor(int pos){
        return colors[pos];
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        Context context = parent.getContext();
        if (view==null){
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view =inflater.inflate(R.layout.text, parent, false);
        }

        TextView textView =(TextView)view;
        textView.setText(names[pos]);
        textView.setBackgroundColor(colors[pos]);

        return view;
    }
}
