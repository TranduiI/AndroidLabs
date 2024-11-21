package com.example.labakontr2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondAct extends AppCompatActivity {
    EditText et1;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ls);
        et1 = (EditText) findViewById(R.id.editText);
        Bundle extras = getIntent().getExtras();
    }
    public void onAdd(View view){
        Intent intent = getIntent();
        intent.putExtra("str", et1.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

}
