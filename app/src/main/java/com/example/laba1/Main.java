package com.example.laba1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity
    implements View.OnClickListener
{
@Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        Button button1=(Button)findViewById(R.id.button);
        button1.setOnClickListener(this);
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4=(
                Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Button b=(Button) v;
        b.setText(R.string.after_click);
    }
}
