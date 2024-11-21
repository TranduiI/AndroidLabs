package com.example.laba13;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TextWatcher{

    private EditText et1;
    private TextView tv1;
    private Button b1;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lm);

        b1 =(Button)findViewById (R.id.button);
        b1.setEnabled(false);
        et1 = (EditText) findViewById(R.id.editTextText);
        tv1 = (TextView) findViewById(R.id.textView);


        et1.addTextChangedListener( this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(et1.getText().toString().trim().length() == 0){
            b1.setEnabled(false);
        }
        else{
            b1.setEnabled(true);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    public void onClick(View view){
        tv1.setText(et1.getText());
        et1.setText("");
    }
}
