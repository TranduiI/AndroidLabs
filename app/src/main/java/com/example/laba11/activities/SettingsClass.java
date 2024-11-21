package com.example.laba11.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.laba11.adapters.ColorsAdapter;
import com.example.laba11.R;


public class SettingsClass extends MainBaseActivity implements AdapterView.OnItemClickListener{

    private ColorsAdapter adapter;



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.la);
        ListView lw = (ListView) findViewById(R.id.lw);

        String[] arCN = getResources().getStringArray(R.array.color_names);
        int[] arC = getResources().getIntArray(R.array.color_values);

        adapter = new ColorsAdapter( arCN, arC);
        lw.setAdapter(adapter);
        lw.setOnItemClickListener(this);

    }
    public void onBack(View view) {
        onBackPressed();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt(getString(R.string.colorValKey), adapter.getColor(position));
        editor.commit();

        getWindow().getDecorView().setBackgroundColor(adapter.getColor(position));

    }
}