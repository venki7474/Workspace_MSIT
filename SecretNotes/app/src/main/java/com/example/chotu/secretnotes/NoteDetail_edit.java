package com.example.chotu.secretnotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class NoteDetail_edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        EditText titleText = (EditText)findViewById(R.id.title_detail_edit);
        LinedEditText contentText = (LinedEditText) findViewById(R.id.content_detail_edit);
//        EditText contentText = (EditText)findViewById(R.id.content_detail_edit);
        titleText.setText(intent.getStringExtra("title"));
        contentText.setText(intent.getStringExtra("content"));


    }

}
