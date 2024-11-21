package com.example.laba19;

import java.io.Serializable;
import java.sql.Time;

public class Note implements Serializable {
    private String note_title;
    private String note_text;
    private Time note_time;

    public Note(String note_title, String note_text, Time note_time){
        this.note_title = note_title;
        this.note_text = note_text;
        this.note_time = note_time;
    }

    public void setTitle(String title){
        note_title = title;
    }
    public void setText(String text){
        note_text = text;
    }
    public void setTime(Time time){
        note_time = time;
    }
    public void setNote(String title, String text, Time time){
        note_title = title;
        note_text = text;
        note_time = time;
    }
    public String getTitle(){
        return note_title;
    }
    public String getText(){
        return note_text;
    }
    public Time getTime(){
        return note_time;
    }


}
