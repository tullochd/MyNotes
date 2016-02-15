package com.example.tullochd.mynotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tullochd on 2/11/2016.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myNotes.db";

    public static final String TABLE_NOTES_LIST = "myNotesList";
    public static final String COLUMN_LIST_ID = "_id";
    public static final String COLUMN_LIST_TITLE = "list_title";
    public static final String COLUMN_LIST_TEXT = "list_text";
    //public static final String COLUMN_LIST_DATE = "list_date";

    public DBHandler(Context context, SQLiteDatabase.CursorFactory factory){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NOTES_LIST + "(" +
                COLUMN_LIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_LIST_TITLE + " TEXT," +
                COLUMN_LIST_TEXT + " TEXT," +
                /*COLUMN_LIST_DATE + " TEXT" +*/
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES_LIST);
        onCreate(db);
    }

    public void addMyNotesList(String title, String text){

        ContentValues values = new ContentValues();

        values.put(COLUMN_LIST_TITLE, title);
        values.put(COLUMN_LIST_TEXT, text);
        //values.put(COLUMN_LIST_DATE, date);

        SQLiteDatabase db = getWritableDatabase();

        db.insert(TABLE_NOTES_LIST, null, values);

        db.close();

    }

    public Cursor getmyNotesLists(){

        SQLiteDatabase db = getWritableDatabase();

        return db.rawQuery("SELECT * FROM " + TABLE_NOTES_LIST, null);
    }
}
