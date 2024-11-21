package com.example.laba7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lm);
        Button b1 =(Button)findViewById(R.id.button1);

    }
    public void openSecondActivity(View view) {
        Intent intent = new Intent(this, ActiveClass.class);
        startActivity(intent);
    }

}
