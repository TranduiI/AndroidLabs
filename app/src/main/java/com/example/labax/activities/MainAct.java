package com.example.labax.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.labax.nonactivityclasses.Note;
import com.example.labax.R;
import com.example.labax.helpers.TestsHelper;
import com.example.labax.helpers.ToastHelper;
import com.example.labax.adapters.LWAdapter;

public class MainAct extends MainBaseAct implements AdapterView.OnItemClickListener{

    public ToastHelper tH;
    ListView lw;
    private TestsHelper dbHelper;



    private LWAdapter adapter;

    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.lm);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        tH = new ToastHelper(this);

        dbHelper = new TestsHelper(this);
        dbHelper.loadTests();

        lw = (ListView) findViewById(R.id.lw);
        lw.setOnItemClickListener(this);
        adapter = new LWAdapter(this, dbHelper);
        lw.setAdapter(adapter);

    }
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        Intent intent = new Intent(this, SecondClass.class);
        intent.putExtra(EXTRA_NOTE, dbHelper.getTest(pos)); //
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
                    dbHelper.addTest((Note) extras.getSerializable(EXTRA_NOTE));
                    dbHelper.loadTests();
                    tH.show(getResources().getString(R.string.new_toast));
                    lw.invalidateViews();

                    break;
                case EDIT_ACTION:
                    dbHelper.setTest( extras.getInt(EXTRA_ID),(Note) extras.getSerializable(EXTRA_NOTE));
                    dbHelper.loadTests();
                    tH.show(getResources().getString(R.string.edit_toast));
                    lw.invalidateViews();

                    break;
            }

        }

    }



}
