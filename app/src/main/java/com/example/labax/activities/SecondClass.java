package com.example.labax.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.labax.helpers.ToastHelper;
import com.example.labax.nonactivityclasses.DateDialog;
import com.example.labax.nonactivityclasses.Note;
import com.example.labax.R;
import com.example.labax.nonactivityclasses.Priority;

import java.io.Serializable;

public class SecondClass extends MainBaseAct{
    EditText tt;
    TextView tm;
    EditText tit;
    private int id;
    DateDialog dD;
    public ToastHelper tH;

    Spinner sp;

    Priority pr;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_sec);
        tt = (EditText) findViewById(R.id.editText);
        tm = (TextView) findViewById(R.id.tvTime);
        tit = (EditText) findViewById(R.id.etTitle);
        sp = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapterForSP = new ArrayAdapter<>(this, R.layout.spinlay);
        adapterForSP.addAll(Priority.values());
        sp.setAdapter(adapterForSP);



        dD = new DateDialog();
        tH = new ToastHelper(this);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            Note note = (Note) extras.getSerializable(EXTRA_NOTE);
            if(note!=null){
                tt.setText(note.getText());
                tm.setText(note.getTime().toString());
                tit.setText(note.getTitle());
                id = extras.getInt(EXTRA_ID);
                pr = Priority.valueOf(note.getPriority());
                sp.setSelection(note.getPriority());
            }
        }
    }
    public void ready(View view){
        if(!tt.getText().toString().trim().equals("")&!tit.getText().toString().trim().equals("")) {
            dD.show(getSupportFragmentManager(), "custom");
        }
        else {
            tH.show(getResources().getString(R.string.cancel_toast_create));
        }
    }
    public void onCancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }


    public void okClicked() {

            Intent intent = getIntent();
            intent.putExtra(EXTRA_NOTE, new Note(tit.getText().toString(),tt.getText().toString(), dD.getDataTime(), sp.getSelectedItemPosition()));
            intent.putExtra(EXTRA_ID, id);
            setResult(RESULT_OK,intent);
            finish();
    }

    public void cancelClicked() {
        dD.dismiss();
    }
}
