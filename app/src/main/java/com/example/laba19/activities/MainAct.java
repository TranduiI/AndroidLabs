package com.example.laba19.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.laba19.MyApp;
import com.example.laba19.Note;
import com.example.laba19.R;
import com.example.laba19.adapters.LWAdapter;

import java.util.List;

public class MainAct extends MainBaseAct implements AdapterView.OnItemClickListener {
    protected MyApp myApp;
    List<Note> list;
    ListView lw;
    private LWAdapter adapter;

    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.lm);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        myApp = (MyApp)getApplicationContext();
        list = myApp.getNotes();
        lw = (ListView) findViewById(R.id.lw);
        lw.setOnItemClickListener(this);
        adapter = new LWAdapter(this);
        lw.setAdapter(adapter);

    }
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        Intent intent = new Intent(this, SecondClass.class);
        intent.putExtra(EXTRA_NOTE, myApp.getNotes().get(pos));
        intent.putExtra(EXTRA_ID, pos);
        startActivityForResult(intent, EDIT_ACTION);
    }
    public void onAdd(View view){
        Intent intent = new Intent(this, SecondClass.class);
        startActivityForResult(intent, CREATE_ACTION);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { //если не было отмены
            Bundle extras = data.getExtras();
            switch (requestCode){
                case CREATE_ACTION:
                    myApp.add((Note) extras.getSerializable(EXTRA_NOTE));
                    lw.invalidateViews();
                    break;
                case EDIT_ACTION:
                    myApp.set(extras.getInt(EXTRA_ID),(Note) extras.getSerializable(EXTRA_NOTE));
                    lw.invalidateViews();

                    break;
            }

        }

    }
}
