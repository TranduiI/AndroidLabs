package com.example.laba5;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class main extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayAdapter<String> arad;
    private Button b, b1, b2, b3;
    private ListView lv;
    private EditText et;

    private int curP;
    private View curView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);
        b = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button3);
        b3 = (Button) findViewById(R.id.button4);
        lv = (ListView) findViewById(R.id.lw);
        et = (EditText) findViewById(R.id.editTextText);
        arad = new ArrayAdapter<String>(this, R.layout.text);
        lv.setAdapter(arad);
        arad.add("first");
        arad.add("second");
        lv.setOnItemClickListener(this);
        b1.setEnabled(false);
        b2.setEnabled(false);

    }

    public void onAdd (View view){
        if (curView!=null) {
            curView.setBackgroundColor(ContextCompat.getColor(this, R.color.lwnull));
        }
        String s=et.getText().toString();
        arad.add(s);
    }
    public void onEdit (View view){
        if (curView!=null) {
            curView.setBackgroundColor(ContextCompat.getColor(this, R.color.lwnull));
        }
        String s2=arad.getItem(curP);
        arad.remove(s2);
        arad.insert(et.getText().toString(),curP);
        b1.setEnabled(false);
    }
    public void onDel (View view){
        String s3=arad.getItem(curP);
        arad.remove(s3);
        b2.setEnabled(false);

    }
    public void onClear (View view){
        arad.clear();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (curView!=null) {
            curView.setBackgroundColor(ContextCompat.getColor(this, R.color.lwnull));
        }
        curView=view;
            curView.setBackgroundColor(ContextCompat.getColor(this, R.color.lwafter));
            String s2 = arad.getItem(position);

            curP = position;
            et.setText(s2);
            b1.setEnabled(true);
            b2.setEnabled(true);
    }
}

