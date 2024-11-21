package com.example.labakontr2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainAct extends AppCompatActivity  {

    protected static final int CREATE_ACTION = 0x000312;
    ArrayList list;
    ListView lw;
    CustAdapter adapter;
    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lm);
        lw = (ListView) findViewById(R.id.list);
        list = new ArrayList<String>();

        adapter = new CustAdapter(list);
        lw.setAdapter(adapter);
    }


    public void onClick(View view){
        Intent intent = new Intent(this, SecondAct.class);
        startActivityForResult(intent, CREATE_ACTION);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            switch (requestCode) {
                case CREATE_ACTION:
                    list.add(extras.getString("str"));

                    //lw.invalidateViews();
                    break;
            }
        }
    }
}
