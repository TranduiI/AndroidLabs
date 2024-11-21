package com.example.laba17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected MyApp myApp;
    protected static final int MY_ACT =0x000314;
    EditText et1,et2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lm);

        String defStr1 = getResources().getString(R.string.defStr1);
        String defStr2 = getResources().getString(R.string.defStr2);

        myApp= (MyApp)getApplicationContext();
        myApp.setStr1(defStr1);
        myApp.setStr2(defStr2);

        et1 = (EditText) findViewById(R.id.editTextText);
        et2 = (EditText) findViewById(R.id.editTextText2);
        et1.setText(myApp.getStr1());
        et2.setText(myApp.getStr2());

    }
    public void openSecondActivity(View view) {
        myApp.setStr1(et1.getText().toString());
        myApp.setStr2(et2.getText().toString());
        Intent intent = new Intent(this, SecondAct.class);
        startActivityForResult(intent, MY_ACT);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, null);
        if (resultCode == RESULT_OK) {
            et1.setText(myApp.getStr1());
            et2.setText(myApp.getStr2());
        }
    }
}
