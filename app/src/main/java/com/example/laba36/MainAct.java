package com.example.laba36;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class MainAct extends Activity {
    public String tagName, textNumCode, textCharCode, textName;
    float textValue;
    final String LOG_TAG = "myLogs";
    List<TestValute> list;

    TextView date;

    ListView lw;

    private LWAdapter adapter;

    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.main_act);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        list = new ArrayList<>();
        date = (TextView) findViewById(R.id.date);
        date.setText("25.11.2023");
        //date.setText(new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date())); //Если нужна сегодняшняя дата
        //list.add(new TestValute("123", "123", "213", 123));
        //Log.d("List values", list.get(0).getValuteCharCode());
        lw = (ListView) findViewById(R.id.lw);
        try {
            XmlPullParser xpp = prepareXpp();

            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (xpp.getEventType()) {
                    // начало тэга
                    case XmlPullParser.START_TAG:
                        tagName = xpp.getName();
                        /*Log.d(LOG_TAG, "START_TAG: name = " + xpp.getName()
                                + ", depth = " + xpp.getDepth() + ", attrCount = "
                                + xpp.getAttributeCount());*/
                        // конец тэга
                    case XmlPullParser.END_TAG:
                        //Log.d(LOG_TAG, "END_TAG: name = " + xpp.getName());
                        if( tagName.equals("Valute") ){
                            list.add(new TestValute(textNumCode, textCharCode,textName, textValue));
                        }
                        break;
                    // содержимое тэга
                    case XmlPullParser.TEXT:
                        //Log.d(LOG_TAG, "text = " + xpp.getText());
                        if( tagName.equals("NumCode") ){
                            textNumCode = xpp.getText();
                        }
                        if( tagName.equals("CharCode") ){
                            textCharCode = xpp.getText();
                        }
                        if( tagName.equals("Name") ){
                            textName = xpp.getText();
                        }
                        if( tagName.equals("Value") ){
                            textValue = Float.valueOf(xpp.getText().replace(',','.'));
                        }
                        break;

                    default:
                        break;
                }
                // следующий элемент
                xpp.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.remove(0);
        adapter = new LWAdapter(list);
        lw.setAdapter(adapter);



    }
    XmlPullParser prepareXpp() {
        return getResources().getXml(R.xml.data);
    }
}
