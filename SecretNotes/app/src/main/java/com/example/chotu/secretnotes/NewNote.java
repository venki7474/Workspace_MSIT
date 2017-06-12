package com.example.chotu.secretnotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class NewNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Create) {
            createNote();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void createNote(){
        EditText title, content;
        title = (EditText)findViewById(R.id.titleId);
        content = (EditText)findViewById(R.id.contentId);
        String titleStr = title.getText().toString();
        String contntStr = content.getText().toString();
        Note note = new Note(titleStr, contntStr);
        MyNoteDB myDB = new MyNoteDB(this, null, null, 1);
        myDB.createNote(note);
//        MainScreen ms = new MainScreen();
//        MainScreen.printAllNotes();
        Intent intnt = new Intent(this,MainScreen.class);
        startActivity(intnt);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
