package com.example.laba14;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainAct extends AppCompatActivity {

    protected static final int MY_ACTION=0x000314;

    EditText et1,et2;


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lm);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
    }

    public void openSecondActivity(View view) {
        Intent intent = new Intent(this, SecondAct.class);
        intent.putExtra(String.valueOf(R.string.et1), et1.getText().toString());
        intent.putExtra(String.valueOf(R.string.et2), et2.getText().toString());
        startActivityForResult(intent, MY_ACTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { //если не было отмены
            Bundle extras = data.getExtras(); //получаем ссылку на объект, содержащий данные
            et1.setText(extras.getString(String.valueOf(R.string.et1)));
            et2.setText(extras.getString(String.valueOf(R.string.et2)));
        }
    }
}
