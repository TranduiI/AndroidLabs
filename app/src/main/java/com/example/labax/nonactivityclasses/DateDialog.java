package com.example.labax.nonactivityclasses;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

import com.example.labax.R;
import com.example.labax.activities.SecondClass;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateDialog extends DialogFragment {

    int date, month, year, hour, minute;

    TextView dPT, tPT;
    Button dPB, tPB;

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.dialog, null);
        builder.setIcon(R.drawable.clock);

        builder.setTitle("Выберете дату и время");
        builder.setView(view);
        dPT = view.findViewById(R.id.datepicktext);
        tPT = view.findViewById(R.id.timepicktext);

        dPB = view.findViewById(R.id.datepick);
        tPB = view.findViewById(R.id.timepick);


        date = LocalDate.now().getDayOfMonth();
        month = LocalDate.now().getMonthValue();
        year = LocalDate.now().getYear();

        hour = LocalTime.now().getHour();
        minute = LocalTime.now().getMinute();
        dPT.setText(date + "." + month + "." + year);
        tPT.setText(hour + ":" + minute);

        dPB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int yearSel, int monthSel, int dateSel) {
                        date = dateSel;
                        month = monthSel+1;
                        year = yearSel;
                        if(String.valueOf(month).length() == 1){
                            dPT.setText(date + ".0" + month + "." + year);
                        }
                        else {
                            dPT.setText(date + "." + month + "." + year);
                        }
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),  onDateSetListener, year, month-1,date);
                datePickerDialog.setTitle("Select Date");
                datePickerDialog.show();
            }
        });
        tPB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourSel, int minuteSel) {
                        hour = hourSel;
                        minute = minuteSel;
                        if(String.valueOf(minute).length() == 1){
                            tPT.setText(hour + ":0" + minute);
                        }
                        else {
                            tPT.setText(hour + ":" + minute);
                        }
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), onTimeSetListener, hour, minute, true);
                timePickerDialog.setTitle("Set time!");

                timePickerDialog.show();
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if(dPT.getText().toString() != "" & tPT.getText().toString() != ""){
                    ((SecondClass) getActivity()).okClicked();
                }


            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                ((SecondClass)  getActivity()).cancelClicked();
            }
        });

        return builder.create();
    }
    public String getDataTime(){
        String dateTime = tPT.getText().toString() + " / " + dPT.getText().toString();
        return dateTime;
    }


}
