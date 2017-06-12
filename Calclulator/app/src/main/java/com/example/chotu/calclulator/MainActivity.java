package com.example.chotu.calclulator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView res;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdot,bequal,bplus,bminus,bmul,bdiv,bclear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        b0 = (Button) findViewById(R.id.button0);
        bdot = (Button) findViewById(R.id.buttonDot);
        bequal = (Button) findViewById(R.id.buttonEqualTo);
        bplus = (Button) findViewById(R.id.AddButton);
        bminus = (Button) findViewById(R.id.SubButton);
        bmul = (Button) findViewById(R.id.MulButton);
        bdiv = (Button) findViewById(R.id.DivButton);
        bclear = (Button) findViewById(R.id.buttonclear);
        res = (TextView) findViewById(R.id.result);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = b1.getText().toString();
                res.append(str);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = b2.getText().toString();
                res.append(str);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = b3.getText().toString();
                res.append(str);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = b4.getText().toString();
                res.append(str);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = b5.getText().toString();
                res.append(str);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = b6.getText().toString();
                res.append(str);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = b7.getText().toString();
                res.append(str);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = b8.getText().toString();
                res.append(str);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = b9.getText().toString();
                res.append(str);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = b0.getText().toString();
                res.append(str);
            }
        });
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = bplus.getText().toString();
                res.append(str);
            }
        });
        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = bminus.getText().toString();
                res.append(str);
            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = bmul.getText().toString();
                res.append(str);
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = bdiv.getText().toString();
                res.append(str);
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String str = bdot.getText().toString();
                res.append(".");
            }
        });
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText("");
            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = res.getText().toString();
                boolean flag = false;
                for(int i = 0;i < str.length();i++){
                    switch(str.charAt(i)){
                        case '+':
                            String[] st = str.split("\\+");
                            Double val = Double.parseDouble(st[0]);
                            for(int j = 1;j<st.length;j++){
                                val = val + Double.parseDouble(st[j]);
                            }
                            res.setText(""+val);
                            flag = true;
                            break;
                        case '-':
                            String[] st1 = str.split("\\-");
                            Double val1 = Double.parseDouble(st1[0]);
                            for(int j = 1;j<st1.length;j++){
                                val1 = val1 - Double.parseDouble(st1[j]);
                            }
                            res.setText(""+val1);
                            flag = true;
                            break;
                        case '/':
                            String[] st2 = str.split("\\/");
                            Double val2 = Double.parseDouble(st2[0]);
                            for(int j = 1;j<st2.length;j++){
                                val2 = val2 / Double.parseDouble(st2[j]);
                            }
                            res.setText(""+val2);
                            flag = true;
                            break;
                        case '*':
                            String[] st3 = str.split("\\*");
                            Double val3 = Double.parseDouble(st3[0]);
                            for(int j = 1;j<st3.length;j++){
                                val3 = val3 * Double.parseDouble(st3[j]);
                            }
                            res.setText(""+val3);
                            flag = true;
                            break;
                    }
                    if(flag == true){
                        break;
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
