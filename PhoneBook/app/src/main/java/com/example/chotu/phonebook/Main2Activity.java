package com.example.chotu.phonebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        TextView stats = (TextView)findViewById(R.id.status);
        stats.setText("Contact Created....!");
        Intent intnt = getIntent();
        String name = intnt.getStringExtra("n");
        String phone = intnt.getStringExtra("p");
        Toast.makeText(getApplicationContext(), name+"\n"+
                phone,
                Toast.LENGTH_LONG).show();
//        finish();
    }

}
