package com.example.labakontr2;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class CustAdapter extends BaseAdapter {
    public List list;
    private int chk = 0;
    private Boolean chk_t = false;
    public CustAdapter(List list){
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = (LinearLayout) inflater.inflate(R.layout.lw, parent, false);
        TextView textView = (TextView) view.findViewById(R.id.textNote);
        textView.setText(list.get(pos).toString());
        ColoredView rB = (ColoredView) view.findViewById(R.id.rightBox);
        ColoredView lB = (ColoredView) view.findViewById(R.id.leftBox);
        Log.d("curentPos", String.valueOf(pos));
        if(pos % 2 == 0) {
            rB.setColor(ContextCompat.getColor(context,R.color.blue));

            Log.d("ColorSet", "blue");
        }
        else {
            //rB.setColor(R.color.red);
            rB.setColor(ContextCompat.getColor(context,R.color.red));
            Log.d("ColorSet", "red");
        }


        if(chk > 1)
        {
            if(chk_t == false)
            {
                chk_t = true;
            }
            else
            {
                chk_t = false;
            }

            chk=0;
        }
        chk++;
        if(chk_t)
        {
            lB.setColor(ContextCompat.getColor(context,R.color.red));
        }

        else{
            lB.setColor(ContextCompat.getColor(context,R.color.blue));
        }
        return view;
    }
}
