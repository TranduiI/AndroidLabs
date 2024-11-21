package com.example.labax.helpers;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.labax.R;

public class ToastHelper extends AppCompatActivity {
    Context context;

    public ToastHelper(Context context){
        this.context =context;
    }
    public void show(String s1){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_toast, null);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.BOTTOM, -30, 100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        TextView tv1 = (TextView) layout.findViewById(R.id.textView1);

        tv1.setText(s1);
        toast.show();

    }
}
