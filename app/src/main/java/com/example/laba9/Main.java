package com.example.laba9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    private EditText et1,et2,et3;

    private SharedPreferences preferences;  //ссылка на объект-настройку
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences(  //метод getSharedPreferences возвращает объект-настройку
                //с именем, которое содержится в первом параметре.
                getString(R.string.preferences),        //имя настройки здесь берется из строкового ресурса
                MODE_PRIVATE                                   //скрытый режим – только наше приложение может читать
        );                                                                  //этот файл-настройку
        setContentView(R.layout.lm);
        et1 = (EditText)findViewById(R.id.editTextText);
        et2 = (EditText)findViewById(R.id.editTextText2);
        et3 = (EditText)findViewById(R.id.editTextText3);
    }

    @Override
    protected void onResume() { //обработчик события, которое помещает активность на передний план
        super.onResume();              //вызов обработчика базового класса
        String intElKey = getString(R.string.int_element); //получаем из строкового ресурса ключ
        //все ключи – строкового типа
        int intEl  = preferences.getInt(intElKey, 5);  //извлекаем из настройки целочисленное значение
        //по его ключу, находящемуся в строке intElKey,
        //если элемента с таким ключом в настройке нет,
        //используем значение по умолчанию 5
        //можно было предварительно проверить,
        //существует ли в настройке элемент с таким ключом:
        //   if(preferences.contains(intElKey)) …
        String str1Key = getString(R.string.str1KeyEl);
        String str2Key = getString(R.string.str2KeyEl);

        String str1 = preferences.getString(str1Key, "default1");
        String str2 = preferences.getString(str2Key, "default2");//извлекаем из настройки остальные элементы.  Для строковых элементов используем getString



        et1.setText(Integer.toString(intEl));    //извлеченные из настройки элементы (или значения по умолчанию) помещаем в EditText-ы
        et2.setText(str1);
        et3.setText(str2);
    }
    @Override
    protected void onPause() {  //обработчик события, которое убирает активность с переднего плана
        super.onPause();               //вызов обработчика базового класса

        int nIntElKey = Integer.parseInt(et1.getText().toString());
        String nStr1 = et2.getText().toString();//извлекаем сохраняемые значения из EditText-ов
        String nStr2 = et3.getText().toString();

        SharedPreferences.Editor editor = preferences.edit(); //с помощью метода edit объекта-активности
        //получаем объект-редактор editor
        editor.putInt(getString(R.string.int_element), nIntElKey); //с помощью редактора помещаем в настройку
        //элемент.  Первый параметр putInt – ключ           						                        //элемента, взятый из строкового ресурса,
        //второй параметр – значение элемента,
        //извлеченное из соответствующего EditText-а
        editor.putString(getString(R.string.str1KeyEl), nStr1);
        editor.putString(getString(R.string.str2KeyEl), nStr2);//аналогично помещаем в настройку остальные элементы.  Для строковых элементов
        //используем putString
        editor.commit();   //применяем изменения настройки
    }


}
