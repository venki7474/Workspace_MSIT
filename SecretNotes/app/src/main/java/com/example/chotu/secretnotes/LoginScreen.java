package com.example.chotu.secretnotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
    EditText pswd ;
    Button loginButn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        loginButn = (Button)findViewById(R.id.loginButton);
        pswd = (EditText)findViewById(R.id.loginPswd);
        loginButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyNoteDB db = new MyNoteDB(getApplicationContext(), null, null, 1);
                String pin = pswd.getText().toString();
                boolean checkstatus = db.loginCheck(pin);
                if (checkstatus) {
                    Intent intent = new Intent(getApplicationContext(), MainScreen.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect Pasword",Toast.LENGTH_SHORT);
                }
            }
        });
        pswd.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            MyNoteDB db = new MyNoteDB(getApplicationContext(), null, null, 1);
                            String pin = pswd.getText().toString();
                            boolean checkstatus = db.loginCheck(pin);
                            if (checkstatus) {
                                Intent intent = new Intent(getApplicationContext(), MainScreen.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Incorrect Pasword", Toast.LENGTH_SHORT);
                            }
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        finish();
    }

}
