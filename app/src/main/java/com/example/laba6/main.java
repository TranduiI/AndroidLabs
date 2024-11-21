package com.example.laba6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class main extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear); //связываем класс для второй активности с разметкой
        //для второй активности, находящейся в файле linear2.xml
        Button second = (Button) findViewById(R.id.button);
        Button third = (Button) findViewById(R.id.button2);
    }
    public void openSecondActivity(View view) {
        Intent intent = new Intent(this, second.class); //создаем объект класса Intent, в качестве
                                                                    //второго параметра передаем ему указание
                                                                    //класс активности, которую требуется открыть
        startActivity(intent); //запускаем активность.  Методу startActivity передаем параметр – объект
                                //класса Intent, в котором содержатся сведения о классе запускаемой
                                //активности
    }
    public void onBack(View view) {
        onBackPressed();
    }
    public void openThirdActivity(View view) {
        Intent intent = new Intent(this, third.class); //создаем объект класса Intent, в качестве
                                                                    //второго параметра передаем ему указание
                                                                    //класс активности, которую требуется открыть
        startActivity(intent); //запускаем активность.  Методу startActivity передаем параметр – объект
                                //класса Intent, в котором содержатся сведения о классе запускаемой
                                //активности
    }
}
