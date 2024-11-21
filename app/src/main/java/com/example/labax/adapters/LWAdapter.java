package com.example.labax.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.labax.R;
import com.example.labax.helpers.TestsHelper;

public class LWAdapter extends BaseAdapter {
    Context context;
    TestsHelper dbHelper;
    public LWAdapter(Context context, TestsHelper testsHelper){
        this.context = context;
        this.dbHelper = testsHelper;
    }

    @Override
    public int getCount() {
        return dbHelper.getNotesCount();
    }

    @Override
    public Object getItem(int pos) {
        return dbHelper.getTest(pos);
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
        noteText.setText(dbHelper.getTest(position).getText()); //myApp.getNotes().get(position).getText()
        TextView noteTitle = (TextView) view.findViewById(R.id.lwTitle);
        noteTitle.setText(dbHelper.getTest(position).getTitle());
        TextView noteTime = (TextView) view.findViewById(R.id.lwTime);
        noteTime.setText(dbHelper.getTest(position).getTime().toString());
        /*if(position%2==0){
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.lwred));
        }
        else {
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.lwblue));
        }*/


        return view;
    }
}
