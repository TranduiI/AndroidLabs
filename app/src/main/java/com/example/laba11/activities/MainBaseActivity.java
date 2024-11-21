package com.example.laba11.activities;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.laba11.R;

public abstract class MainBaseActivity extends AppCompatActivity {
    public SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE);

    }

    @Override
    public void onResume(){
        super.onResume();

        String colorValKey = getString(R.string.colorValKey);
        int colorVal = preferences.getInt(colorValKey, 0xff000000);
        getWindow().getDecorView().setBackgroundColor(colorVal);

    }
    public void onPause(){
        super.onPause();

        ColorDrawable backColor = (ColorDrawable) getWindow().getDecorView().getBackground();

        int colorVal = backColor.getColor();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(getString(R.string.colorValKey), colorVal);
        editor.commit();
    }

}
