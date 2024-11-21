package com.example.laba11.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.laba11.R;

public class Main extends MainBaseActivity {



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lm);
        Button b1 =(Button)findViewById (R.id.button1);
        Button b2 =(Button) findViewById(R.id.button2);

    }
    public void openSecondActivity(View view) {
        Intent intent = new Intent(this, SettingsClass.class);
        startActivity(intent);
    }
    public void openThirdActivity(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }


}
