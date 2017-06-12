package com.example.chotu.phonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button createButn;
    EditText name, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButn = (Button)findViewById(R.id.createButton);
        name = (EditText)findViewById(R.id.nameId);
        phone = (EditText)findViewById(R.id.phoneId);

        createButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = name.getText().toString();
                String phoneStr = phone.getText().toString();
                Intent myIntent = new Intent(getApplicationContext(), Main2Activity.class);
                myIntent.putExtra("n",nameStr);
                myIntent.putExtra("p",phoneStr);
                startActivity(myIntent);
            }
        });
    }
}
