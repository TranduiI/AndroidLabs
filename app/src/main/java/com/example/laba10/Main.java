package com.example.laba10;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    private ListView lw;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lm);
        lw = (ListView) findViewById(R.id.lw);

        String []ar = getResources().getStringArray(R.array.items);


        ColorsAdapter adapter = new ColorsAdapter(ar);
        lw.setAdapter(adapter);




    }
}
