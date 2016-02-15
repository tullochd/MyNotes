package com.example.tullochd.mynotes;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateNotes extends AppCompatActivity {
    Intent intent;
    EditText titleEditText;
    EditText textEditText;

    Calendar calendar;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titleEditText = (EditText) findViewById(R.id.titleEditText);
        textEditText = (EditText) findViewById(R.id.textEditText);

        calendar = Calendar.getInstance();

        dbHandler = new DBHandler(this, null);
    }

    //Creates the Notes Activity by initiating add button on overflow menu.
    public void createNotes(MenuItem menuItem){

        String title = titleEditText.getText().toString();
        String text = textEditText.getText().toString();


        if (title.trim().equals("") || text.trim().equals("")){
            Toast.makeText(this, "Please enter title and text!", Toast.LENGTH_LONG).show();
        } else {
            dbHandler.addMyNotesList(title, text);
            Toast.makeText(this, "MyNotes Added!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_create_notes:
                intent = new Intent(this, CreateNotes.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
