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
import android.widget.TextView;

import org.w3c.dom.Text;

public class NoteDetail extends AppCompatActivity {
    TextView titleText, contentText;
    MyNoteDB myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myDb = new MyNoteDB(this, null, null, 1);
        titleText = (TextView)findViewById(R.id.title_detail);
        contentText = (TextView)findViewById(R.id.content_detail);

        Intent intnt = getIntent();

        if (intnt != null ){
            String titleStr = intnt.getStringExtra("selected");

            String contentStr = myDb.getDetails(titleStr);
            System.out.println("--------------------->"+titleStr +" ---> "+contentStr);
            titleText.setText(titleStr);
            contentText.setText(contentStr);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.note_detail_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Edit) {
            editNote();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void editNote() {
        titleText.getText().toString();
        contentText.getText().toString();
        Intent intent = new Intent(getApplicationContext(),NoteDetail_edit.class);
        intent.putExtra("title",titleText.getText().toString());
        intent.putExtra("content",contentText.getText().toString());
        startActivity(intent);
    }
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        finish();
////        Intent intent = new Intent(this, SignupScreen.class);
//    }

}
