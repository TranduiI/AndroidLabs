package com.example.laba36;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LWAdapter extends BaseAdapter {

    List<TestValute> testValutes;

    public LWAdapter(List<TestValute> testValutes){
        this.testValutes = testValutes;
        Log.d("Lw adapteCreated", "Готово");
        //Log.d("Lw adapteVal",testValutes.get(0).getValuteNumCode());
    }
    @Override
    public int getCount() {
        return testValutes.size();
    }

    @Override
    public Object getItem(int position) {
        return testValutes.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Context context = parent.getContext();
        Log.d("InGetView", "Все ок");
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lw_element, parent, false);
        }

        TextView curProd = (TextView) view.findViewById(R.id.arBuy);
        TextView curPokup = (TextView) view.findViewById(R.id.arSell);
        if(position % 2 ==0) {
            curProd.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arup, 0);
            curPokup.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ardown, 0);
        } else {
            curProd.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ardown, 0);
            curPokup.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arup, 0);
        }

        TextView valuteName = (TextView) view.findViewById(R.id.lwValuteName);
        valuteName.setText(testValutes.get(position).getValuteName());
        TextView valuteCharCode = (TextView) view.findViewById(R.id.lwValuteCharCode);
        valuteCharCode.setText(testValutes.get(position).getValuteCharCode());
        //TextView valuteNumCode = (TextView) view.findViewById(R.id.lwValuteNumCode);
        //valuteNumCode.setText(testValutes.get(position).getValuteNumCode());
        TextView valuteValueBuy = (TextView) view.findViewById(R.id.lwValuteValueBuy);
        TextView valuteValueSell = (TextView) view.findViewById(R.id.lwValuteValueSell);
        valuteValueBuy.setText(String.format("%2f",testValutes.get(position).getValuteValue()-testValutes.get(position).getValuteValue()*0.1));
        valuteValueSell.setText(String.format("%2f",testValutes.get(position).getValuteValue()+testValutes.get(position).getValuteValue()*0.1));


        return view;
    }
}
