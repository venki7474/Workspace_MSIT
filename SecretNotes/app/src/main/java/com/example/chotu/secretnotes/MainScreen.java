package com.example.chotu.secretnotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {
    ListView list_main;
//    View rootView;
    MyNoteDB myDb;
    ArrayList<String> all_notes_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list_main = (ListView)findViewById(R.id.Mainlist);
        registerForContextMenu(list_main);
        printAllNotes();
        list_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = list_main.getItemAtPosition(position).toString();
//                selectedList.add(selected);
                Intent intnt = new Intent(getApplicationContext(), NoteDetail.class).putExtra("selected", selected);
                startActivity(intnt);
                Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT ).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_New) {
            Intent intnt = new Intent(this, NewNote.class);
            startActivity(intnt);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId()==R.id.Mainlist) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_list, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()) {
//            case R.id.edit:
//                // edit stuff here
//                return true;
            case R.id.delete:
                String itemStr = all_notes_list.get(info.position);
                deleteNote(itemStr);
                printAllNotes();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        printAllNotes();
//        finish();
//        Intent intent = new Intent(this, SignupScreen.class);
    }
//    @Override
//    protected void onStop() {
//        super.onStop();
////        System.exit(0);
//    }
    public void printAllNotes(){
        myDb = new MyNoteDB(this, null, null,1);
        all_notes_list = myDb.databaseToString();
        System.out.println(all_notes_list);
        ArrayAdapter adptr = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_activated_1,
                all_notes_list);
        list_main.setAdapter(adptr);
    }
    public void deleteNote(String titleStr){
        myDb.deleteNote(titleStr);
        printAllNotes();
    }


}
