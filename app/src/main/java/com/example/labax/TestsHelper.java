package com.example.labax;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.sql.Time;

public class TestsHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "newTestFix";
    public Cursor cursor;
    public static final class Tests {
        public static final String TABLE_NAME = "newTestFixed";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TEXT = "text";
        public static final String COLUMN_DATE = "date";


        public static String getCreateStatement(){
            return String.format(
                    "CREATE TABLE %s(" +
                            "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "%s TEXT," +
                            "%s TEXT," +
                            "%s TEXT" +
                            ")",
                    TABLE_NAME,
                    BaseColumns._ID,
                    COLUMN_TITLE,
                    COLUMN_TEXT,
                    COLUMN_DATE
            );
        }
        public static Note getTest(Cursor cursor){
            int ID = cursor.getColumnIndex(BaseColumns._ID),
                    titleID = cursor.getColumnIndex(COLUMN_TITLE),
                    textID = cursor.getColumnIndex(COLUMN_TEXT),
                    dateID = cursor.getColumnIndex(COLUMN_DATE);

            return( new  Note(cursor.getString(titleID),cursor.getString(textID), cursor.getString(dateID)));
        }
        public static long insertTest(SQLiteDatabase db, Note note){
            ContentValues values = new ContentValues();

            values.put(COLUMN_TITLE, note.getTitle());
            values.put(COLUMN_TEXT, note.getText());
            values.put(COLUMN_DATE, note.getTime());
            return db.insert(TABLE_NAME, null, values);
        }
        public static int updateTest(SQLiteDatabase db, int id,  Note note){
            ContentValues values = new ContentValues();
            id = id+1;
            values.put(COLUMN_TITLE, note.getTitle());
            values.put(COLUMN_TEXT, note.getText());
            values.put(COLUMN_DATE, note.getTime());

            return db.update(TABLE_NAME, values, "_id = ?", new String[]{String.valueOf(id)});
        }
    }
    public TestsHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tests.getCreateStatement());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void loadTests(){
        cursor = getReadableDatabase().rawQuery(
                String.format(
                        "SELECT * FROM %s",
                        Tests.TABLE_NAME
                ), null);
    }
    public void addTest(Note note){
        Tests.insertTest(
                getWritableDatabase(),
                note
        );
        loadTests();

    }
    public void setTest(int id, Note note){
        Tests.updateTest(getWritableDatabase(), id, note );
        loadTests();
    }
    public Note getTest(int id){
        cursor.moveToPosition(id);
        return Tests.getTest(cursor);
    }
    public int getNotesCount(){
        return cursor.getCount();
    }


}

