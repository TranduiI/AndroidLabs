package com.example.laba16;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ToastHelper extends AppCompatActivity{
    Context context;

    public ToastHelper(Context context){
        this.context =context;
    }
    public void show(String s1, String s2){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_toast, null);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        TextView tv1 = (TextView) layout.findViewById(R.id.textView1);
        TextView tv2 = (TextView) layout.findViewById(R.id.textView2);
        ImageView iv1 = (ImageView) layout.findViewById(R.id.imageView);

        tv1.setText(s1);

        tv2.setText(s2);

        iv1.setImageResource(R.drawable.toast6);
        toast.show();

    }
}
