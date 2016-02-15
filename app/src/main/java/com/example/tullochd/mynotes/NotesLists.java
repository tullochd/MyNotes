package com.example.tullochd.mynotes;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by tullochd on 2/14/2016.
 */
public class NotesLists extends CursorAdapter {

    public NotesLists (Context context, Cursor cursor, int flags){
        super(context, cursor, flags);
    }
    //Creates NotesLists rows.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        //Returns an inflated custom row.
        return LayoutInflater.from(context).inflate(R.layout.ni_my_notes_list, parent, false);
    }

    //Binds Cursor to text views in custom rows
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ((TextView) view.findViewById(R.id.titleTextView)).
                setText(cursor.getString(cursor.getColumnIndex("list_title")));

        ((TextView) view.findViewById(R.id.textTextView)).
                setText(cursor.getString(cursor.getColumnIndex("list_text")));
    }
}
