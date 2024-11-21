package com.example.laba18;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainAct extends AppCompatActivity {
    EditText et1, et2;
    LinearLayout lm;
    LayoutInflater inflater;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lm);
        et1 = (EditText) findViewById(R.id.editTextText);
        et2 = (EditText) findViewById(R.id.editTextText2);

        lm = (LinearLayout) findViewById(R.id.lMainInto);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    public void setSimpleTV(View view){
        if(!et1.getText().toString().trim().equals("")){
            TextView textView = (TextView) inflater.inflate(R.layout.let, null);
            textView.setText(et1.getText());
            lm.addView(textView);
        }
    }
    public void setNameAgeTV(View view){
        if(!et1.getText().toString().trim().equals("")&!et2.getText().toString().trim().equals("")){
            LinearLayout root = (LinearLayout) inflater.inflate(R.layout.lna, null);
            TextView textView = (TextView) root.findViewById(R.id.textView2T);
            TextView textView2 = (TextView) root.findViewById(R.id.textView3T);
            textView.setText(et1.getText());
            textView2.setText(et2.getText());
            lm.addView(root);
        }

    }
    public void onClear(View view){
        lm.removeAllViews();
    }
}
