package com.example.labax.activities;

import androidx.appcompat.app.AppCompatActivity;

public abstract class MainBaseAct extends AppCompatActivity {
    protected static final int CREATE_ACTION = 0x000312;
    protected static final int EDIT_ACTION = 0x000313;
    protected static final String EXTRA_NOTE = "note";
    protected static final String EXTRA_ID = "id";
}
