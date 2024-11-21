package com.example.laba6new;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Third extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear3); //связываем класс для второй активности с разметкой
        //для второй активности, находящейся в файле linear2.xml
    }
    public void onBack(View view) {
        onBackPressed();
    }

}
