package com.example.laba7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ActiveClass extends Activity {
    private ArrayAdapter<String> arad1,arad2;
    private Button b1,b2,b3;
    private ListView lw1,lw2;
    private EditText et;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.la);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        lw1 =(ListView) findViewById(R.id.lw1);
        lw2 =(ListView) findViewById(R.id.lw2);
        et = (EditText) findViewById(R.id.editText1);

        arad1 = new ArrayAdapter<String>(this, R.layout.text);
        arad2 = new ArrayAdapter<String>(this, R.layout.text);
        lw1.setAdapter(arad1);
        lw2.setAdapter(arad2);

        String []ar1 = getResources().getStringArray(R.array.ar1);
        String []ar2 = getResources().getStringArray(R.array.ar2);

        arad1.addAll(ar1);
        arad2.addAll(ar2);
    }


    public void onAddL1(View view){
        String s=et.getText().toString();
        arad1.add(s);
    }
    public void onAddL2(View view){
        String s=et.getText().toString();
        arad2.add(s);
    }
    public void onBack(View view) {
        onBackPressed();
    }

}
