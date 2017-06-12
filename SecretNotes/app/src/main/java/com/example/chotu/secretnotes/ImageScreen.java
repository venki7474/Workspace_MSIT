package com.example.chotu.secretnotes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ImageScreen extends Activity {
    Button iB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_image_screen);
        Intent intnt = getIntent();
        iB = (Button) findViewById(R.id.imageBtn);
        iB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent2 = new Intent(getApplicationContext(), NextScreen.class);
//                startActivity(intent2);
                Toast.makeText(ImageScreen.this,
                        "ImageButton is clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
