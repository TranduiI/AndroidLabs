package com.example.laba16;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainAct extends AppCompatActivity {

    ToastHelper th1;
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lm);
        th1 = new ToastHelper(this);
        et1 = (EditText) findViewById(R.id.editTextText);
        et2 = (EditText) findViewById(R.id.editTextText2);
    }

    public void showToastB1(View view) {

        Toast toast = Toast.makeText(getApplicationContext(),
                "Кнопка 1!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
    public void showToastB2(View view){
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(getApplicationContext(),
                R.string.laba16_b2, duration);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }
    public void showToastB3(View view) {
        Toast toast3 = Toast.makeText(getApplicationContext(),
                R.string.laba16_b3, Toast.LENGTH_LONG);
        toast3.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastContainer = (LinearLayout) toast3.getView();
        ImageView toastImageView = new ImageView(getApplicationContext());
        toastImageView.setImageResource(R.drawable.toast3);
        toastContainer.addView(toastImageView, 0);
        toastContainer.setBackgroundColor(Color.TRANSPARENT);
        toast3.show();
    }

    public void showToastB4(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                null);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    public void showToastB5(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                null);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        TextView tv1 = (TextView) layout.findViewById(R.id.textView1);
        TextView tv2 = (TextView) layout.findViewById(R.id.textView2);
        ImageView iv1 = (ImageView) layout.findViewById(R.id.imageView);

        tv1.setText("Кнопка 5-1");
        tv1.setBackgroundColor(getColor(R.color.custToast5T1Back));
        tv1.setTextColor(getColor(R.color.custToast5T1Text));

        tv2.setText("Кнопка 5-2");
        tv2.setBackgroundColor(getColor(R.color.custToast5T2Back));
        tv2.setTextColor(getColor(R.color.custToast5T2Text));

        iv1.setImageResource(R.drawable.toast5);

        toast.show();
    }

    public void showToastB6(View view) {

        th1.show(et1.getText().toString(),et2.getText().toString());

    }



}
