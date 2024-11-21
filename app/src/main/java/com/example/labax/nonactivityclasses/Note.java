package com.example.labax.nonactivityclasses;

import java.io.Serializable;

public class Note implements Serializable {
    private String note_title;
    private String note_text;
    private String note_time;

    private int priority;

    public Note(String note_title, String note_text, String note_time, int priority){
        this.note_title = note_title;
        this.note_text = note_text;
        this.note_time = note_time;
        this.priority = priority;
    }

    public void setTitle(String title){
        note_title = title;
    }
    public void setText(String text){
        note_text = text;
    }
    public void setTime(String time){
        note_time = time;
    }
    public void setNote(String title, String text, String time, String priority){
        note_title = title;
        note_text = text;
        note_time = time;
        priority = priority;
    }
    public String getTitle(){
        return note_title;
    }
    public String getText(){
        return note_text;
    }
    public String getTime(){
        return note_time;
    }
    public int getPriority(){
        return priority;
    }

}
