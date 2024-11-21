package com.example.laba19.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.laba19.Note;
import com.example.laba19.R;

import java.sql.Time;

public class SecondClass extends MainBaseAct {
    EditText tt;
    TextView tm;
    EditText tit;
    private int id;


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_sec);
        tt = (EditText) findViewById(R.id.editText);
        tm = (TextView) findViewById(R.id.tvTime);
        tit = (EditText) findViewById(R.id.etTitle);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            Note note = (Note) extras.getSerializable(EXTRA_NOTE);
            if(note!=null){
                tt.setText(note.getText());
                tm.setText(note.getTime().toString());
                tit.setText(note.getTitle());
                id = extras.getInt(EXTRA_ID);
            }
        }

    }
    public void ready(View view){
        if(!tt.getText().toString().trim().equals("")&!tit.getText().toString().trim().equals("")){
            Intent intent = getIntent();
            intent.putExtra(EXTRA_NOTE, new Note(tit.getText().toString(),tt.getText().toString(), new Time(System.currentTimeMillis())));
            if(getIntent().getExtras().getString(EXTRA_ID)!=null){
                intent.putExtra(EXTRA_ID, id);
            }
            setResult(RESULT_OK,intent);
            finish();
        }

    }
    public void onCancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}

