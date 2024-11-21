package com.example.laba15;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainAct extends MainBaseAct implements AdapterView.OnItemClickListener {

    private ArrayAdapter<String>  adapter;
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        setContentView(R.layout.lm);
        ListView lw = (ListView) findViewById(R.id.lw);

        adapter = new ArrayAdapter<>(this,R.layout.text);

        lw.setAdapter(adapter);
        lw.setOnItemClickListener(this);
        adapter.add("FirstEl");
        adapter.add("SecondEl");

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        Intent intent = new Intent(this, SecondAct.class);
        intent.putExtra(EXTRA_TEXT, adapter.getItem(pos));
        intent.putExtra(EXTRA_ID, pos);
        startActivityForResult(intent, EDIT_ACTION);
    }
    public void onAdd(View view){
        Intent intent = new Intent(this, SecondAct.class);
        startActivityForResult(intent, CREATE_ACTION);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { //если не было отмены
            Bundle extras = data.getExtras();
            switch (requestCode){
                case CREATE_ACTION:
                    adapter.add(extras.getString(EXTRA_TEXT).toString());
                    break;
                case EDIT_ACTION:
                    String sE = adapter.getItem(extras.getInt(EXTRA_ID));
                    adapter.remove(sE);
                    adapter.insert(extras.getString(EXTRA_TEXT).toString(),extras.getInt(EXTRA_ID));
                    break;
            }

        }

    }

}
