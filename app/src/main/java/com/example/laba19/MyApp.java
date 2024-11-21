package com.example.laba19;

import android.app.Application;


import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {

    private final List<Note> notes = new ArrayList<>();

    public ToastHelper tH;
    public MyApp(){
        super();
        notes.add(new Note("Test1", "TestText1", new Time(10,30,54)));
        notes.add(new Note("Test1", "TestText1", new Time(15,20,15)));
        //notes.add("Record 2");
        tH = new ToastHelper(this);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void add(Note note){
        notes.add(note);
        tH.show(getResources().getString(R.string.new_toast));
    }
    public void set(int id, Note note){

        notes.get(id).setNote(note.getTitle(),note.getText(),note.getTime());
        tH.show(getResources().getString(R.string.edit_toast));
    }

}
