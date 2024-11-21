package com.example.laba14;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SecondAct extends Activity {


    EditText et3,et4;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.la);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){  //проверяем, были ли переданы данные
            String txt=extras.getString(String.valueOf(R.string.et1));
            if(txt!=null){
                et3.setText(extras.getString(String.valueOf(R.string.et1)));
            }
            String txt2 =extras.getString(String.valueOf(R.string.et2));
            if(txt2!=null){
                et4.setText(extras.getString(String.valueOf(R.string.et2)));
            }
        }
    }
    public void ready(View view){
        Intent intent = getIntent();
        intent.putExtra(String.valueOf(R.string.et1), et3.getText().toString());
        intent.putExtra(String.valueOf(R.string.et2), et4.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
    public void onCancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

}
