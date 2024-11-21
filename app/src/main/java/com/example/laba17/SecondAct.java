package com.example.laba17;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondAct extends Activity {
    EditText et1, et2;
    protected MyApp myApp;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lm2);
        et1 = (EditText) findViewById(R.id.editTextText3);
        et2 = (EditText) findViewById(R.id.editTextText4);
        myApp= (MyApp)getApplicationContext();
        et1.setText(myApp.getStr1());
        et2.setText(myApp.getStr2());

    }
    public void onSave(View view){
        Intent intent = getIntent();
        myApp.setStr1(et1.getText().toString());
        myApp.setStr2(et2.getText().toString());

        setResult(RESULT_OK, intent);
        finish();
    }
    public void onCancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
