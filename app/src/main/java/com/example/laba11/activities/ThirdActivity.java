package com.example.laba11.activities;

import android.os.Bundle;
import android.view.View;

import com.example.laba11.R;

public class ThirdActivity extends MainBaseActivity{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lt);
    }
    public void onBack(View view) {
        onBackPressed();
    }

}
