package com.example.laba19.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.laba19.R;
import com.example.laba19.MyApp;
import com.example.laba19.activities.SecondClass;

public class LWAdapter extends BaseAdapter {
    Context context;
    MyApp myApp;
    public LWAdapter(Context context){
        this.context = context;
        this.myApp = (MyApp) context.getApplicationContext();
    }

    @Override
    public int getCount() {
        return myApp.getNotes().size();
    }

    @Override
    public Object getItem(int pos) {
        return myApp.getNotes().get(pos);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Context context = parent.getContext();
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lw_element, parent, false);
        }

        TextView noteText = (TextView) view.findViewById(R.id.lwText);
        noteText.setText(myApp.getNotes().get(position).getText());
        TextView noteTitle = (TextView) view.findViewById(R.id.lwTitle);
        noteTitle.setText(myApp.getNotes().get(position).getTitle());
        TextView noteTime = (TextView) view.findViewById(R.id.lwTime);
        noteTime.setText(myApp.getNotes().get(position).getTime().toString());
        /*if(position%2==0){
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.lwred));
        }
        else {
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.lwblue));
        }*/


        return view;
    }



}
