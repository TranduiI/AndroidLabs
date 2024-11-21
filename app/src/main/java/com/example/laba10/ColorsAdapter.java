package com.example.laba10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class ColorsAdapter extends BaseAdapter {

    private String[] names;

    public ColorsAdapter(String [] names){
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Context context = parent.getContext();
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  //с помощью метода
            // getSystemService объекта context класса Context создаем объект inflater класса LayoutInflater
            view = inflater.inflate(R.layout.text_view, parent, false); //с помощью метода inflate объекта inflater
            //создаем из разметки для элемента списка, находящегося в файле list_item.xml папки layout,
            // дерево объектов и возвращаем ссылку на корневой элемент этого дерева.  В данном случае
            //дерево у нас состоит из одного узла - элемента TextView.
        }
        TextView textView = (TextView) view; //преобразуем класс объекта – элемента разметки к TextView
        textView.setText(names[position]);
        if(position%2==0){
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.lwred));
        }
        else {
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.lwblue));
        }


        return view;

    }
}
