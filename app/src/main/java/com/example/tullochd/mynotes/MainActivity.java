package com.example.tullochd.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    DBHandler dbHandler;
    NotesLists notesListsAdapter;
    ListView myNotesListsView;

    //onCreate ethod gets called when activity starts up. Initializes user interface.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHandler = new DBHandler(this, null);

        myNotesListsView = (ListView) findViewById(R.id.myNotesListView);

        notesListsAdapter = new NotesLists(this, dbHandler.getmyNotesLists(), 0);

        myNotesListsView.setAdapter(notesListsAdapter);
    }

    public void openCreateNotes (View view){
        intent = new Intent(this, CreateNotes.class);
        startActivity(intent);
    }

    //Creates overflow menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Gets initiated when a selection is made in overflow menu.
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
