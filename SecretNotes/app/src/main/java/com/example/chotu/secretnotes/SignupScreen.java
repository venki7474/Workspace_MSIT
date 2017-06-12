package com.example.chotu.secretnotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupScreen extends Activity {
    EditText psswd1, psswd2;
    MyNoteDB myDb = new MyNoteDB(this, null, null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        Button enter = (Button)findViewById(R.id.SignupButton);
        myDb= new MyNoteDB(this, null, null, 1);
        boolean userCheck = myDb.check_for_user();
        if (userCheck ) {
            enter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    psswd1 = (EditText) findViewById(R.id.password1);
                    psswd2 = (EditText) findViewById(R.id.password2);
                    String p1, p2;
                    p1 = psswd1.getText().toString();
                    p2 = psswd2.getText().toString();
                    if (p1.equals(p2)) {
                        myDb.createUser(p1);
                        Intent intnt = new Intent(getApplicationContext(), LoginScreen.class);
                        startActivity(intnt);
                    } else {
                        Toast.makeText(getApplicationContext(),"password doesnt match", Toast.LENGTH_SHORT);
                    }
                }
            });

        } else {
            Intent intnt = new Intent(this, LoginScreen.class);
            startActivity(intnt);
        }

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }
}
