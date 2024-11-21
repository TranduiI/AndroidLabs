package com.example.laba15;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class SecondAct extends MainBaseAct{

    EditText et;
    private int id;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.la);
        et = (EditText) findViewById(R.id.editText);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String text = extras.getString(EXTRA_TEXT);
            if(text!=null){
                et.setText(text);
                id = extras.getInt(EXTRA_ID);
            }
        }

    }
    public void ready(View view){
        Intent intent = getIntent();
        intent.putExtra(EXTRA_TEXT, et.getText().toString());
        if(getIntent().getExtras().getString(EXTRA_ID)!=null){
            intent.putExtra(EXTRA_ID, id);
        }
        setResult(RESULT_OK,intent);
        finish();
    }
    public void onCancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
